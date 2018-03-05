package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * 
 * 获取验证码++++
 * 
 */
public class TitleRul {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.dezzal.com/sign-up.html");
		driver.navigate().to("https://www.baidu.com");
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		System.out.println("Before login===========");
		System.out.println("title of current page is %s\n:" + driver.getTitle());
		System.out.println("url of current page is %s\n:" + driver.getCurrentUrl());

		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");			
		driver.findElement(By.id("passwordsign")).sendKeys("123456");	
		driver.findElement(By.id("js_signInBtn")).click();

		System.out.println("After login============");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		System.out.println("Over");
		Thread.sleep(2000);
		driver.quit();
	}
}
