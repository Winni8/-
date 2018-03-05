package com.Blog;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testjs {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("selenium3");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//处理滚动条的；
		String high = "scroll(0,10000);";
		((JavascriptExecutor) driver).executeScript(high);
		driver.findElement(By.linkText("帮助")).click();

		String surhand = driver.getWindowHandle();
		Set<String> hands = driver.getWindowHandles();
		hands.remove(surhand);

		for (String temp : hands) {
			if( driver.switchTo().window(temp).getPageSource().contains("服务支持")){
			driver.switchTo().window(temp);
		}
		}
		
		if(driver.getTitle().contains("服务中心") ){
			System.out.println("表明跳转ok");
		}
		
		driver.quit();
	}
}
