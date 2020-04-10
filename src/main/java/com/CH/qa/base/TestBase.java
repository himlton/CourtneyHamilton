
package com.CH.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.CH.qa.util.util;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static String path;

	//To launch browser
	public static void init() throws IOException, InterruptedException {

		prop = new Properties();
		path = System.getProperty("user.dir");
		FileInputStream fileInputSteream = new FileInputStream(path+"\\src\\main\\java\\com\\CH\\qa\\config\\config.properties");
		prop.load(fileInputSteream);


		System.setProperty("webdriver.chrome.driver",path+prop.getProperty("Chrome_Driver"));
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		File file = new File(path + "\\ScreenShots");
		if(!(file.exists())) {
			file.mkdir();
		}

	}

	//Function to take screenshot
	public void takeScreenShot(String fileName) throws IOException {
		Screenshot takeScreenShot = new AShot().takeScreenshot(driver);
		ImageIO.write(takeScreenShot.getImage(), "png", new File(path+"\\ScreenShots\\" + fileName + ".png"));
	}
}


