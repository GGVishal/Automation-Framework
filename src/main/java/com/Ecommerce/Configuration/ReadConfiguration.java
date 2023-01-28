package com.Ecommerce.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {
	Properties pro;

	public ReadConfiguration() {
		File src = new File(
				"C:\\Users\\Vishal\\eclipse-workspace\\Automation_Framework\\src\\main\\java\\com\\Ecommerce\\Configuration\\Config.properties");

		FileInputStream fis;

		try {
			fis = new FileInputStream(src);
			pro = new Properties();

			try {
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
 
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String password = pro.getProperty("username");
		return password;

	}

	public String getPassword() {
		String chromepath = pro.getProperty("password");
		return chromepath;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxpath() {
		String firefox = pro.getProperty("Firefox");
		return firefox;
	}

}
