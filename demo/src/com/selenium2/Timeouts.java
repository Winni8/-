package com.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Timeouts {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		dr.get("http://www.baidu.com/");
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.findElement(By.id("kw")).sendKeys("selenium");
		
		dr.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
		
		dr.quit();
	}
}
