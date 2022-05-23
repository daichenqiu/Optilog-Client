package com.optilog.log.console;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    @OnlyInInit
    public static void file(Optilog instance) {
        instance.allSetting.fileName = instance.allSetting.fileName.replace("%time", DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()));
        
        if (instance.allSetting.defaultConsolePath != null && !instance.allSetting.defaultConsolePath.equals("")) {
            final File f = new File(instance.allSetting.defaultConsolePath);
            if (Console.checkFile(f) && instance.consoleFileMasterCaution) {
                File defFile = new File(instance.allSetting.defaultConsolePath + "//" + instance.allSetting.fileName);
                try {
                    if (!defFile.isFile()) {
                        if (!defFile.createNewFile()) {
                            instance.consoleFileMasterCaution = false;
                        }
                    }
                    if (instance.consoleFileMasterCaution) {
                        instance.info = defFile.getAbsolutePath();
                        instance.error = defFile.getAbsolutePath();
                        instance.warn = defFile.getAbsolutePath();
                        instance.debug = defFile.getAbsolutePath();
                        instance.fatal = defFile.getAbsolutePath();
                    }
                    return;
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                }
            } else {
                instance.consoleFileMasterCaution = false;
                return;
            }
        }
        if (instance.allSetting.infoPath != null) {
            if (instance.allSetting.Path1 != null && !instance.allSetting.Path1.equals("")) {
                File file = new File(instance.allSetting.Path1 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path2 != null && !instance.allSetting.Path2.equals("")) {
                File file = new File(instance.allSetting.Path2 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path3 != null && !instance.allSetting.Path3.equals("")) {
                File file = new File(instance.allSetting.Path3 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path4 != null && !instance.allSetting.Path4.equals("")) {
                File file = new File(instance.allSetting.Path4 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path5 != null && !instance.allSetting.Path5.equals("")) {
                File file = new File(instance.allSetting.Path5 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            
            if (instance.allSetting.infoPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.infoPath.replace("%path", "").equals("1")) {
                        instance.info = instance.allSetting.Path1;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("2")) {
                        instance.info = instance.allSetting.Path2;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("3")) {
                        instance.info = instance.allSetting.Path3;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("4")) {
                        instance.info = instance.allSetting.Path4;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("5")) {
                        instance.info = instance.allSetting.Path5;
                    }
                    if (instance.info == null) {
                        instance.consoleFileMasterCaution = false;
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                }
            }
            if (instance.allSetting.errorPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.errorPath.replace("%path", "").equals("1")) {
                        instance.error = instance.allSetting.Path1;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("2")) {
                        instance.error = instance.allSetting.Path2;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("3")) {
                        instance.error = instance.allSetting.Path3;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("4")) {
                        instance.error = instance.allSetting.Path4;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("5")) {
                        instance.error = instance.allSetting.Path5;
                    }
                    if (instance.error == null) {
                        instance.consoleFileMasterCaution = false;
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                }
            }
            if (instance.allSetting.warnPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.warnPath.replace("%path", "").equals("1")) {
                        instance.warn = instance.allSetting.Path1;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("2")) {
                        instance.warn = instance.allSetting.Path2;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("3")) {
                        instance.warn = instance.allSetting.Path3;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("4")) {
                        instance.warn = instance.allSetting.Path4;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("5")) {
                        instance.warn = instance.allSetting.Path5;
                    }
                    if (instance.warn == null) {
                        instance.consoleFileMasterCaution = false;
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                }
            }
            if (instance.allSetting.debugPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.debugPath.replace("%path", "").equals("1")) {
                        instance.debug = instance.allSetting.Path1;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("2")) {
                        instance.debug = instance.allSetting.Path2;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("3")) {
                        instance.debug = instance.allSetting.Path3;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("4")) {
                        instance.debug = instance.allSetting.Path4;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("5")) {
                        instance.debug = instance.allSetting.Path5;
                    }
                    if (instance.debug == null) {
                        instance.consoleFileMasterCaution = false;
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                }
            }
            if (instance.allSetting.fatalPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("1")) {
                        instance.fatal = instance.allSetting.Path1;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("2")) {
                        instance.fatal = instance.allSetting.Path2;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("3")) {
                        instance.fatal = instance.allSetting.Path3;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("4")) {
                        instance.fatal = instance.allSetting.Path4;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("5")) {
                        instance.fatal = instance.allSetting.Path5;
                    }
                    if (instance.fatal == null) {
                        instance.consoleFileMasterCaution = false;
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                }
            }
        }
    }
    
    @OnlyInInit
    private static boolean checkFile(File f) {
        try {
            return f.isDirectory() & f.canRead() & f.canWrite();
        } catch (NullPointerException npe) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}