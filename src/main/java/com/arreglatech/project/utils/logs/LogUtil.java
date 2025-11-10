package com.arreglatech.project.utils.logs;

import com.arreglatech.project.utils.params.ParamsUtil;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.Arrays;

/**
 * Utility for managing traces (logs), which support the debugging process
 */
@UtilityClass
public class LogUtil
{
    //public static final String RGX_FOUND_METHOD = "(?<gr>\\.[^.]+\\.[^.]+)$"
    //public static final String RGX_INCLUDE_JUMP_START_METHOD = "\n\tTraza: ${gr}"

    public static final String RGX_FOUND_METHOD = "(\\.[^.]+\\.[^.]+)$";
    public static final String RGX_INCLUDE_JUMP_START_METHOD = "\n\tLog: $1";

    public static final String FORMAT = "\n\t\t{1}";

    /**
     *	constant q identifies the position of interest to extract from the java call stack, when drawing a log, to
     *	recover the class path that caused the call to make the log trace
     */
    public static final int ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD = 4;

    public static final String JUMP_LINE = "\n";

    public static final String TAB_LINE = "\t";

    public static final String IDENTATION = "\n\t\t";

    public static final String RGX_FINISH_JUMP_OR_TAB = "[\\n\\t]+$"; //"(\\n|\\t)+$"


    private static final String LOG_FORMAT = "{}{}{}";
    private static final String RESET_COLOR_ANSI = "\u001B[0m";
    private static final String RED_COLOR_ANSI = "\u001B[31m";
    private static final String YELLOW_COLOR_ANSI = "\u001B[33m";
    private static final String CYAN_COLOR_ANSI = "\u001B[36m";
    private static final String MAGENTA_COLOR_ANSI = "\u001B[35m";
    private static final String BLUE_COLOR_ANSI = "\u001B[34m";

    public static void info(Throwable pEx,Object pReg, Object ... pParameters )
    {
        LogUtil.log(null,Level.INFO, pEx,pReg, pParameters);
    }

    public static void info(Logger logger, Throwable pEx, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.INFO, pEx,pReg, pParameters);
    }

    public static void info(Object pReg, Object ... pParameters )
    {
        LogUtil.log(null,Level.INFO, null,pReg, pParameters);
    }

    public static void info(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.INFO, null,pReg, pParameters);
    }

    public static void info(Throwable pEx)
    {
        LogUtil.log(null,Level.INFO, pEx,null);
    }

    public static void info(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.INFO, pEx,null);
    }

    public static void error (Throwable pEx,Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.ERROR, pEx,pReg, pParameters);
    }

    public static void error (Logger logger, Throwable pEx,Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.ERROR, pEx,pReg, pParameters);
    }

    public static void error (Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.ERROR, null,pReg, pParameters);
    }

    public static void error (Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.ERROR, null,pReg, pParameters);
    }

    public static void error(Throwable pEx)
    {
        LogUtil.log(null,Level.ERROR, pEx,null);
    }

    public static void error(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.ERROR, pEx,null);
    }

    public static void warn(Throwable pEx,Object pReg, Object ... pParameters)
    {
        LogUtil.log(null, Level.WARN, pEx,pReg, pParameters);
    }

    public static void warn(Logger logger, Throwable pEx,Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.WARN, pEx,pReg, pParameters);
    }

    public static void warn(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null, Level.WARN, null,pReg, pParameters);
    }

    public static void warn(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.WARN, null,pReg, pParameters);
    }

    public static void warn(Throwable pEx)
    {
        LogUtil.log(null,Level.WARN, pEx,null);
    }

    public static void warn(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.WARN, pEx,null);
    }

    public static void debug(Throwable pEx, Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.DEBUG, pEx,pReg, pParameters);
    }

    public static void debug(Logger logger,Throwable pEx, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.DEBUG, pEx, pReg, pParameters);
    }

    public static void debug(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.DEBUG, null,pReg, pParameters);
    }

    public static void debug(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.DEBUG, null, pReg, pParameters);
    }

    public static void debug(Throwable pEx)
    {
        LogUtil.log(null,Level.DEBUG, pEx,null);
    }

    public static void debug(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.DEBUG, pEx,null);
    }

    public static void trace(Throwable pEx, Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.TRACE, pEx,pReg, pParameters);
    }

    public static void trace(Logger logger, Throwable pEx, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.TRACE,pEx, pReg, pParameters);
    }

    public static void trace(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.TRACE,null, pReg, pParameters);
    }

    public static void trace(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.TRACE, null,pReg, pParameters);
    }

    public static void trace(Throwable pEx)
    {
        LogUtil.log(null,Level.TRACE, pEx,null);
    }

    public static void trace(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.TRACE, pEx,null);
    }


    public static void general	(	Level pLevel,
                                       Throwable ex,
                                       Object pReg,
                                       Object ... pParameters
    )
    {
        LogUtil.log(null,pLevel,ex, pReg, pParameters);
    }


    public static void general	(	Logger logger,
                                       Level pLevel,
                                       Throwable ex,
                                       Object pReg,
                                       Object ... pParameters
    )
    {
        LogUtil.log(logger,pLevel,ex, pReg, pParameters);
    }


    private static void log(Logger logger,
                            Level pLevel,
                            Throwable ex,
                            Object pReg,
                            Object ... pParameters
    )
    {
        String strReg;
        logger = LogUtil.calculateLogger(logger);

        strReg = LogUtil.formatLog(ex,pReg, pParameters);

        switch(pLevel){
            case DEBUG:
                if(logger.isDebugEnabled()){
                    logger.debug(LOG_FORMAT, MAGENTA_COLOR_ANSI,strReg, RESET_COLOR_ANSI);
                }
                break;
            case INFO:
                if(logger.isInfoEnabled()){
                    logger.info(LOG_FORMAT, CYAN_COLOR_ANSI,strReg, RESET_COLOR_ANSI);
                }
                break;
            case ERROR:
                if(logger.isErrorEnabled()){
                    logger.error(LOG_FORMAT, RED_COLOR_ANSI,strReg, RESET_COLOR_ANSI);
                }
                break;
            case WARN:
                if(logger.isWarnEnabled()){
                    logger.warn(LOG_FORMAT, YELLOW_COLOR_ANSI,strReg, RESET_COLOR_ANSI);
                }
                break;
            default:
                if(logger.isTraceEnabled()){
                    logger.trace(LOG_FORMAT, BLUE_COLOR_ANSI,strReg, RESET_COLOR_ANSI);
                }
                break;
        }
    }

    private static String formatLog(Throwable ex,Object pReg, Object ... pParameters)
    {
        String strLogFixed;

        if(pReg==null || pReg.toString().isEmpty()) {
            strLogFixed = StringUtils.EMPTY;
        }else {
            strLogFixed = ParamsUtil.processParameters(pReg.toString(), pParameters)+JUMP_LINE;
        }

        if(ex!=null) {
            strLogFixed = strLogFixed+ex+JUMP_LINE
                    +Arrays.toString(ex.getStackTrace()).replace(",",JUMP_LINE);
        }

        strLogFixed = strLogFixed.replace(JUMP_LINE, IDENTATION)
                .replaceAll(RGX_FINISH_JUMP_OR_TAB, StringUtils.EMPTY);

        return ParamsUtil.processParameters(FORMAT, Thread.currentThread().getId(),strLogFixed);
    }

    private static Logger calculateLogger(Logger logger)
    {
        String strTrace = null;

        if(logger != null) {
            for(int i = ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD; i<Thread.currentThread().getStackTrace().length ; i++ ) {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i];
                if(stackTraceElement.getClassName().equals(logger.getName())) {
                    strTrace = stackTraceElement.toString();
                    break;
                }
            }
        }

        if(strTrace == null) {

            strTrace = Thread.currentThread().getStackTrace()[ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD].toString();
        }

        return LoggerFactory.getLogger(strTrace.replaceAll(RGX_FOUND_METHOD, RGX_INCLUDE_JUMP_START_METHOD));
    }

    public static Logger getLogger()
    {
        return getLogger(Thread.currentThread().getStackTrace().length-1);
    }

    public static Logger getLogger(int idPosClaseStackTraceCurrentThread)
    {
        String strClass;

        strClass = Thread.currentThread().getStackTrace()[idPosClaseStackTraceCurrentThread].getClassName();

        return LoggerFactory.getLogger(strClass);
    }
}
