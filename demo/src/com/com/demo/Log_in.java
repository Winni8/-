package com.com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Log_in {
	public static void login(WebDriver driver, String username, String password) {

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='signinform']/div[3]/button")).click();
	}

	public static void logout(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='header']/div/div[6]/a"))).perform();
		action.click(driver.findElement(By.linkText("Logout"))).perform();
	}
}
