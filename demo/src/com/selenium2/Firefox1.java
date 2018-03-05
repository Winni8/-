package com.selenium2;

/**
 * 
 * 
 * 
 * selenium 的百度输入内容，点击click
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.baidu.com");
		dr.findElement(By.name("wd")).sendKeys("selenium");
		dr.findElement(By.id("su")).click();

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dr.quit();

	}
}
