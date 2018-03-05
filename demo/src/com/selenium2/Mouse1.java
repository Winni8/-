package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
// Û±Í”“º¸   ß∞‹£∫
public class Mouse1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://yunpan.360.cn/");
		Actions action =new Actions(driver);
		action.contextClick(driver.findElement(By.id("su"))).perform();
	}
}
