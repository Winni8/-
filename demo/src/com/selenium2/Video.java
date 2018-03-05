package com.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//播放 暂停 失败
public class Video {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://videojs.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement video =
	driver.findElement(By.xpath("//div[@class='vjs-poster']"));
		
		JavascriptExecutor jse =( JavascriptExecutor)driver;
		System.out.println(jse.executeScript("return arguments[0].currentSrc", video));
		jse.executeScript("return arguments[0].play()", video);
		
		Thread.sleep(5000);
		jse.executeScript("arguments[0].pause()", video);
		
		
		System.out.println("播放成功");
		driver.quit();
	}
}
