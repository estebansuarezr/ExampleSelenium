package com.arreglatech.project.utils.spoilers;

import com.arreglatech.project.utils.gif.GifUtil;
import com.arreglatech.project.utils.logs.LogUtil;
import com.arreglatech.project.utils.screenshots.ScreenshotUtil;
import com.arreglatech.project.utils.time.WaitUtil;
import io.cucumber.java.Scenario;
import lombok.experimental.UtilityClass;
import net.serenitybdd.core.Serenity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Spoiler (.gif evidence)
 * <[SPOILER_GIF_EVIDENCE]>
 */
@UtilityClass
public class SpoilerUtil
{

    public static final String SPOILER_RELATIVE_PATH = "spoiler.path.relative";

    private static final String EXTENSION_GIF = ".gif";
    private static final String EXTENSION_PNG = ".png";

    private static final Path ROOT_PATH = Paths.get(
            System.getProperty("user.dir")
    ).normalize();

    private static final Path REPORT_PATH_RELATIVE = Paths.get(
            "target","site","serenity"
    ).normalize();


    public static void prepare(Scenario scenario)
    {
        try {

            String pathFeature = scenario.getUri().getSchemeSpecificPart()
                    .replaceAll("([.]feature)$", StringUtils.EMPTY);

            Path pathSpoilerRelative = Paths.get(
                    REPORT_PATH_RELATIVE.toString(),"spoilers", pathFeature,scenario.getName(),
                    "ex-line."+scenario.getLine()
            ).normalize();

            Path targetPath = Paths.get(
                    ROOT_PATH.toString(),pathSpoilerRelative.toString()
            ).normalize();

            if (!Files.exists(targetPath)) {
                Files.createDirectories(targetPath);
            }

            Serenity.setSessionVariable(SPOILER_RELATIVE_PATH).to(pathSpoilerRelative);

        } catch (IOException  e) {
            LogUtil.error(e);
        }
    }

    public static void film(Scenario scenario)
    {
        try {
            Path pathSpoilerRelative = Serenity.sessionVariableCalled(SpoilerUtil.SPOILER_RELATIVE_PATH);
            File fileSpoilerRelative = pathSpoilerRelative.toFile();

            WaitUtil.stopFor(1000);

            ScreenshotUtil.screenshot(
                    String.valueOf(pathSpoilerRelative),
                    5
            );

            List<File> lstScreenshots =
                    FileUtils.listFiles(
                            fileSpoilerRelative,
                            new String[]{EXTENSION_PNG},
                            false
                    ).stream().sorted(Comparator.comparingInt(
                            f -> Integer.parseInt(FilenameUtils.getBaseName(f.getName()))
                    )).toList();

            if(!lstScreenshots.isEmpty())
            {
                Path gifFile = Paths.get(
                    pathSpoilerRelative.toString(),
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
                            + StringUtils.SPACE + scenario.getStatus().toString()
                            + StringUtils.SPACE + fileSpoilerRelative.getName()
                            + StringUtils.SPACE + scenario.getName() + EXTENSION_GIF
                ).normalize();

                GifUtil.createGif(
                        lstScreenshots,
                        gifFile.toFile()
                );

                Serenity.recordReportData().asEvidence()
                        .withTitle("See Full Test: "+
                                FilenameUtils.getBaseName(gifFile.getFileName().toString()))
                        .downloadable().fromFile(gifFile);

                for(File screenshot : lstScreenshots){
                    screenshot.deleteOnExit();
                }

            }

        } catch (Exception e) {
            LogUtil.error(e);
        }

    }

}
