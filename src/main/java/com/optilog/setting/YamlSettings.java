package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.exception.ConfigureException;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlSettings {
	public static void yaml(String path, boolean isClasspath, Optilog instance) {
		Map<String, LinkedHashMap> map;
		if (!isClasspath) {
			try (InputStream input = new FileInputStream(path)) {
				Yaml yaml = new Yaml();
				map = yaml.load(input);
			} catch (IOException e) {
				instance.consoleFileMasterCaution = false;
				throw new ConfigureException("Can't find'" + path + "'.", e);
			}
		} else {
			try (InputStream input = Optilog.class.getResourceAsStream(path)) {
				Yaml yaml = new Yaml();
				map = yaml.load(input);
				//System.out.println(map.get("info").get("print"));
			} catch (IOException e) {
				instance.consoleFileMasterCaution = false;
				throw new ConfigureException("Can't find'" + path + "'.", e);
			}
		}
		LinkedHashMap<String, String> lInfo = map.get("info");
		LinkedHashMap<String, String> lError = map.get("error");
		LinkedHashMap<String, String> lDebug = map.get("debug");
		LinkedHashMap<String, String> lFatal = map.get("fatal");
		LinkedHashMap<String, String> lWarn = map.get("warn");
		instance.allSetting.printInfo = Boolean.parseBoolean(lInfo.get("print"));
		instance.allSetting.printError = Boolean.parseBoolean(lError.get("print"));
		instance.allSetting.printWarn = Boolean.parseBoolean(lWarn.get("print"));
		instance.allSetting.printDebug = Boolean.parseBoolean(lDebug.get("print"));
		instance.allSetting.printFatal = Boolean.parseBoolean(lFatal.get("print"));
		
		instance.allSetting.consoleInfo = Boolean.parseBoolean(lInfo.get("console"));
		instance.allSetting.consoleError = Boolean.parseBoolean(lError.get("console"));
		instance.allSetting.consoleDebug = Boolean.parseBoolean(lDebug.get("console"));
		instance.allSetting.consoleWarn = Boolean.parseBoolean(lWarn.get("console"));
		instance.allSetting.consoleFatal = Boolean.parseBoolean(lFatal.get("console"));
		
		instance.allSetting.serverInfo = Boolean.parseBoolean(lInfo.get("server"));
		instance.allSetting.serverError = Boolean.parseBoolean(lError.get("server"));
		instance.allSetting.serverWarn = Boolean.parseBoolean(lWarn.get("server"));
		instance.allSetting.serverDebug = Boolean.parseBoolean(lDebug.get("server"));
		instance.allSetting.serverFatal = Boolean.parseBoolean(lFatal.get("server"));
		
		String packing$packingFormat = (String) map.get("packing").get("packingFormat");
		if (packing$packingFormat != null) {
			instance.allSetting.packingFormat = packing$packingFormat;
		}
		
		String file$defaultConsolePath = (String) map.get("file").get("defaultConsolePath");
		if (file$defaultConsolePath != null) {
			instance.allSetting.defaultConsolePath = file$defaultConsolePath;
		}
		String file$Path1 = (String) map.get("file").get("Path1");
		if (file$Path1 != null) {
			instance.allSetting.Path1 = file$Path1;
		}
		String file$Path2 = (String) map.get("file").get("Path2");
		if (file$Path2 != null) {
			instance.allSetting.Path2 = file$Path2;
		}
		String file$Path3 = (String) map.get("file").get("Path3");
		if (file$Path3 != null) {
			instance.allSetting.Path3 = file$Path3;
		}
		String file$Path4 = (String) map.get("file").get("Path4");
		if (file$Path4 != null) {
			instance.allSetting.Path4 = file$Path4;
		}
		String file$Path5 = (String) map.get("file").get("Path5");
		if (file$Path5 != null) {
			instance.allSetting.Path5 = file$Path5;
		}
		
		String file$infoPath = (String) map.get("file").get("infoPath");
		if (file$infoPath != null) {
			instance.allSetting.infoPath = file$infoPath;
		}
		String file$errorPath = (String) map.get("file").get("errorPath");
		if (file$errorPath != null) {
			instance.allSetting.errorPath = file$errorPath;
		}
		String file$warnPath = (String) map.get("file").get("warnPath");
		if (file$warnPath != null) {
			instance.allSetting.warnPath = file$warnPath;
		}
		String file$debugPath = (String) map.get("file").get("debugPath");
		if (file$debugPath != null) {
			instance.allSetting.debugPath = file$debugPath;
		}
		String file$fatalPath = (String) map.get("file").get("fatalPath");
		if (file$fatalPath != null) {
			instance.allSetting.fatalPath = file$fatalPath;
		}
		
		String file$fileName = (String) map.get("file").get("fileName");
		if (file$fileName != null) {
			instance.allSetting.fileName = file$fileName;
		}
		
		instance.allSetting.startClient = Boolean.parseBoolean((String) map.get("server").get("startClient"));
		
		String server$host = (String) map.get("server").get("host");
		if (server$host != null) {
			instance.allSetting.host = server$host;
		}
		
		try {
			int server$socketNumber = Integer.parseInt((String) map.get("server").get("socketNumber"));
			if (server$socketNumber != 0) {
				instance.allSetting.socketNumber = server$socketNumber;
			}
		} catch (NumberFormatException | NullPointerException ignored) {
		}
	}
}