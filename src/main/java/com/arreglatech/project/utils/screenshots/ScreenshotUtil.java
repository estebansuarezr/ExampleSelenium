package com.arreglatech.project.utils.screenshots;

import com.arreglatech.project.exceptions.general.BusinessException;
import com.arreglatech.project.utils.time.WaitUtil;
import lombok.experimental.UtilityClass;
import net.serenitybdd.core.Serenity;
import net.thucydides.model.screenshots.ScreenshotAndHtmlSource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Spoiler (.gif evidence)
 * <[SPOILER_GIF_EVIDENCE]>
 */
@UtilityClass
public class ScreenshotUtil
{

    private static final String EXTENSION = ".png";

    private static final String PATH_ROOT = System.getProperty("user.dir");

    public static void screenshot(String path, String name, int count)
    {
        try {

            Path pathTarget = Paths.get(
                    PATH_ROOT,
                    path
            ).normalize();

            if( !Files.exists(pathTarget) )
            {
                FileUtils.forceMkdir(pathTarget.toFile());
            }

            int countTakes = count == 0 ? 1:count;

            for(int i=0; i<countTakes; i++)
            {
                String nameFixed = (
                        (name == null || name.trim().isEmpty())
                                ? String.valueOf(
                                FileUtils.listFiles(
                                        pathTarget.toFile(),
                                        new String[]{EXTENSION},
                                        false
                                ).size()+1
                        ) : name+"_"+(i+1)
                )+EXTENSION;

                List<ScreenshotAndHtmlSource> lstScreenshots = Serenity.takeScreenshots();

                if(lstScreenshots != null && !lstScreenshots.isEmpty())
                {
                    File screenshot = lstScreenshots.get(0).getScreenshot();

                    while(!Files.exists(Paths.get(screenshot.toURI())))
                    {
                        WaitUtil.stopFor(500);
                    }

                    Files.copy(
                            Paths.get(screenshot.toURI()).normalize(),
                            Paths.get(pathTarget.toString(),nameFixed).normalize(),
                            //StandardCopyOption.ATOMIC_MOVE,
                            StandardCopyOption.REPLACE_EXISTING
                    );
                }
            }

        } catch (IOException e) {
            throw new BusinessException.Runtime(e);
        }
    }

    public static void screenshot(String path){
        ScreenshotUtil.screenshot(path,null,0);
    }

    public static void screenshot(String path, String name){
        ScreenshotUtil.screenshot(path,name,0);
    }

    public static void screenshot(String path, int count){
        ScreenshotUtil.screenshot(path,null,count);
    }
}
