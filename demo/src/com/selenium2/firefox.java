package com.selenium2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;

import com.sun.jna.platform.FileUtils;


public class firefox {
	public static void main(String[] args) throws Exception {
		System.out.println("start");

		String url = "https://www.baidu.com";

		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//当前的url;
		driver.get(url);
		//由当前url,跳转另外的url
		driver.navigate().to("http://www.dezzal.com/");
		driver.manage().window().maximize();
		driver.navigate().refresh();//刷新頁面；
		driver.navigate().back();//頁面返回上一层；
		
		/*File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(srcFile, new File("c:\\1.png"));*/   //不成功；
		
//		Actions action = new Actions(driver);
//		action.contextClick(driver.findElement(By.id("kw"))).perform();
		
		//WindowsUtils.tryToKillByName("chromedriver.exe");
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("over");
	}
}