package com.tej.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static Properties prop;
	public static FileInputStream fIn;
	public static WebDriver driver;

	public TestBase() {
		prop=new Properties();
		try {
			fIn=new FileInputStream("C:/Users/tejas/eclipse-workspace/SelectorsHubPractice/src/main/java/com/tej/properties/config.properties");
			prop.load(fIn);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		if(prop.getProperty("driver").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/tejas/Documents/Docs/Drivers/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
