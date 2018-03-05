package com.selenium2;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ShotScreen {
	public static void main(String[] args) throws Exception {
		System.out.println("开始");
		String url="https://www.rosewholesale.com/";
		
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr =new FirefoxDriver();
		dr.get(url);
		
		Thread.sleep(3000);
		
		File screenShotFile =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new
				File("D:/test.png"));
		
		System.out.println("截屏成功；");
		dr.quit();
	}
}
