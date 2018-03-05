package com.selenium2;

/**
 * 
 * 
 * 
 * selenium 的一些get方法
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.baidu.com");
		dr.findElement(By.name("wd")).sendKeys("selenium");
		dr.findElement(By.id("su")).click();

		String title = dr.getTitle();
		System.out.println(title);
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getWindowHandles());

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dr.quit();

	}
}
