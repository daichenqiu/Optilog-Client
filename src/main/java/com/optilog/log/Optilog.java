package com.optilog.log;

import com.optilog.setting.SettingFiles;

import java.net.DatagramSocket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Optilog implements Log {
    public DatagramSocket socket;
    public boolean consoleFileMasterCaution = true;
    boolean alreadyInit;
    
    public SettingFiles allSetting;
    
    String settingFilePath;
    
    public String info;
    public String error;
    public String warn;
    public String debug;
    public String fatal;
    
    @Override
    public void info() {
        LogEvent infoEvent = new LogEvent(" ", Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, (String) occupy[i - 1]);
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent infoEvent = new LogEvent(previousMsg, Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }
        
        Throwable throwable = ex;
        
        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent infoEvent = new LogEvent(returnString.toString(), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(long x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(double x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(short x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(int x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(float x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent infoEvent = new LogEvent(x, Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void info(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent infoEvent = new LogEvent(x.toString(), Level.INFO);
        Logger.INSTANCE.logInfo(infoEvent, this);
    }
    
    @Override
    public void error() {
        LogEvent errorEvent = new LogEvent(" ", Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, (String) occupy[i - 1]);
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent errorEvent = new LogEvent(previousMsg, Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }
        
        Throwable throwable = ex;
        
        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent errorEvent = new LogEvent(returnString.toString(), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(long x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(double x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(short x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(int x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(float x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent errorEvent = new LogEvent(x, Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void error(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent errorEvent = new LogEvent(x.toString(), Level.ERROR);
        Logger.INSTANCE.logError(errorEvent, this);
    }
    
    @Override
    public void warn() {
        LogEvent warnEvent = new LogEvent(" ", Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, (String) occupy[i - 1]);
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent warnEvent = new LogEvent(previousMsg, Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }
        
        Throwable throwable = ex;
        
        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent warnEvent = new LogEvent(returnString.toString(), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(long x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(double x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(short x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(int x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(float x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent warnEvent = new LogEvent(x, Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void warn(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent warnEvent = new LogEvent(x.toString(), Level.WARN);
        Logger.INSTANCE.logWarn(warnEvent, this);
    }
    
    @Override
    public void debug() {
        LogEvent debugEvent = new LogEvent(" ", Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, (String) occupy[i - 1]);
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent debugEvent = new LogEvent(previousMsg, Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }
        
        Throwable throwable = ex;
        
        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent debugEvent = new LogEvent(returnString.toString(), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(long x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(double x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(short x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(int x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(float x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent debugEvent = new LogEvent(x, Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void debug(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent debugEvent = new LogEvent(x.toString(), Level.DEBUG);
        Logger.INSTANCE.logDebug(debugEvent, this);
    }
    
    @Override
    public void fatal() {
        LogEvent fatalEvent = new LogEvent(" ", Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, (String) occupy[i - 1]);
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent fatalEvent = new LogEvent(previousMsg, Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }
        
        Throwable throwable = ex;
        
        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent fatalEvent = new LogEvent(returnString.toString(), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(long x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(double x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(short x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(int x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(float x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent fatalEvent = new LogEvent(x, Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void fatal(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent fatalEvent = new LogEvent(x.toString(), Level.FATAL);
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }
    
    @Override
    public void command(String cmd) {
        if (cmd == null) {
            cmd = "null";
        }
        Logger.logCommand(cmd, this);
    }
}

