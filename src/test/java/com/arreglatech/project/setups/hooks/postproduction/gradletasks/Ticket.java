package com.arreglatech.project.setups.hooks.postproduction.gradletasks;

import java.io.IOException;
import java.nio.file.*;

public class Ticket {

    private static final String PATH_ROOT = System.getProperty("user.dir");
    private static final String PATH_REPORT_SITE_DEFAULT = "/target/site";
    private static final String DIR_REPORT_SERENITY = "/serenity";
    private static final String DIR_REPORT_FINAL = "/report";
    private static final String INDEX_HTML = "/index.html";
    private static final String PATH_RELATIVE_INDEX_HTML = DIR_REPORT_FINAL +INDEX_HTML;
    private static final String IFRAME_SHORCUT_INDEX_HTML = "<iframe src=\"."+ PATH_RELATIVE_INDEX_HTML +"\" title=\"W3Schools Free Online Web Tutorials\" width=\"100%\" height=\"100%\"></iframe>";

    public static void main(String[] args) throws IOException
    {
        String pathReportSite =
                (   args.length>0
                        ?   args[0]
                        :   PATH_ROOT+PATH_REPORT_SITE_DEFAULT
                );

        String pathReportSerenityInitial = pathReportSite+DIR_REPORT_SERENITY;

        Path indexHtml = Paths.get(pathReportSerenityInitial+INDEX_HTML).normalize();

        if( Files.exists(indexHtml) )
        {
            String pathReportSerenityFinal = pathReportSerenityInitial+DIR_REPORT_FINAL;
            Path dirReportSerenityInitial = Paths.get(pathReportSerenityInitial).normalize();
            Path dirTempReportSerenityFinal = Paths.get(pathReportSite+DIR_REPORT_FINAL).normalize();
            Files.move(dirReportSerenityInitial,dirTempReportSerenityFinal);
            Path dirReportSerenityFinal = Paths.get(pathReportSerenityFinal).normalize();
            Files.createDirectories(dirReportSerenityFinal);
            Files.move(dirTempReportSerenityFinal,dirReportSerenityFinal,StandardCopyOption.REPLACE_EXISTING);

            Files.writeString(indexHtml,IFRAME_SHORCUT_INDEX_HTML, StandardOpenOption.CREATE);
        }
    }
}

