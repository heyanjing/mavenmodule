package com.he.maven.module.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 提供日志的打印
 */
public class Logs {

    public static final Logger logger = Logs.getLogger(Logs.class);

    public static Logger getLogger(Object obj) {
        Logger logger = null;
        if (obj instanceof Class) {
            logger = LoggerFactory.getLogger((Class<?>) obj);
        } else if (obj instanceof String) {
            logger = LoggerFactory.getLogger((String) obj);
        } else {
            logger = LoggerFactory.getLogger(obj.getClass());
        }
        return logger;
    }

    // ########################################
    // ###**************trace**************####
    // ########################################
    public static boolean isTraceEnabled(Object obj) {
        return Logs.getLogger(obj).isTraceEnabled();
    }

    public static void trace(Object obj, String msg) {
        Logs.getLogger(obj).trace(msg);
    }

    public static void trace(Object obj, String msg, Throwable t) {
        Logs.getLogger(obj).trace(msg, t);
    }

    public static void trace(Object obj, String format, Object... args) {
        if (Logs.isTraceEnabled(obj)) {
            Logs.getLogger(obj).trace(format, args);
        }
    }

    // ########################################
    // ###**************debug**************####
    // ########################################
    public static boolean isDebugEnabled(Object obj) {
        return Logs.getLogger(obj).isDebugEnabled();
    }

    public static void debug(Object obj, String msg) {
        Logs.getLogger(obj).debug(msg);
    }

    public static void debug(Object obj, String msg, Throwable t) {
        Logs.getLogger(obj).debug(msg, t);
    }

    public static void debug(Object obj, String format, Object... args) {
        if (Logs.isDebugEnabled(obj)) {
            Logs.getLogger(obj).debug(format, args);
        }
    }

    // ########################################
    // ###**************info**************####
    // ########################################
    public static boolean isInfoEnabled(Object obj) {
        return Logs.getLogger(obj).isInfoEnabled();
    }

    public static void info(Object obj, String msg) {
        Logs.getLogger(obj).info(msg);
    }

    public static void info(Object obj, String msg, Throwable t) {
        Logs.getLogger(obj).info(msg, t);
    }

    public static void info(Object obj, String format, Object... args) {
        if (Logs.isInfoEnabled(obj)) {
            Logs.getLogger(obj).info(format, args);
        }
    }

    // ########################################
    // ###**************warn**************####
    // ########################################
    public static boolean isWarnEnabled(Object obj) {
        return Logs.getLogger(obj).isWarnEnabled();
    }

    public static void warn(Object obj, String msg) {
        Logs.getLogger(obj).warn(msg);
    }

    public static void warn(Object obj, String msg, Throwable t) {
        Logs.getLogger(obj).warn(msg, t);
    }

    public static void warn(Object obj, String format, Object... args) {
        if (Logs.isWarnEnabled(obj)) {
            Logs.getLogger(obj).warn(format, args);
        }
    }

    // ########################################
    // ###**************error**************####
    // ########################################
    public static boolean isErrorEnabled(Object obj) {
        return Logs.getLogger(obj).isErrorEnabled();
    }

    public static void error(Object obj, String msg) {
        Logs.getLogger(obj).error(msg);
    }

    public static void error(Object obj, String msg, Throwable t) {
        Logs.getLogger(obj).error(msg, t);
    }

    public static void error(Object obj, String format, Object... args) {
        if (Logs.isErrorEnabled(obj)) {
            Logs.getLogger(obj).error(format, args);
        }
    }

    // ########################################
    // ###**************println**************####
    // ########################################
    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void msg(List<?> objs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < objs.size(); i++) {
            Object obj = objs.get(i);
            sb.append(Strings.toString(obj));
            if (i < objs.size() - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void msg(Object obj) {
        String msg = Strings.toString(obj, true);
        msg = Strings.removeStart(msg, "'");
        msg = Strings.removeEnd(msg, "'");
        msg(msg);
    }

    public static void msg(Object... obj) {
        msg(Strings.toString(obj));
    }

    public static void msg(String msg) {
        if (isDebug()) {
            System.out.println(msg);
        } else {
            Logs.info(Logs.class, msg);
        }
    }

    public static boolean isDebug() {
        return (logger.isInfoEnabled() && (logger.isWarnEnabled() || logger.isErrorEnabled()));
    }

    public static void LogToDB(Logger log, Exception ex) {
        if (log == null) {
            log = logger;
        }
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];
        //出错行
        int lineNumber = stackTraceElement.getLineNumber();
        //方法签名
        String methodName = stackTraceElement.getMethodName();
        //获得类名
        String className = stackTraceElement.getClassName();

        log.error("方法" + className + "." + methodName, "参数" + stackTraceElement, "错误行：" + lineNumber, "时间" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "异常内容" + ex.toString());

    }

    public static void LogToDB(Exception ex) {
        LogToDB(null, ex);
    }
}
