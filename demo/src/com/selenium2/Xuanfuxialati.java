package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Xuanfuxialati {
	public static void main(String[] args) throws Exception {
		System.out.println("�_ʼ");
		System.setProperty("webdriver.gecko.driver",
					"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.jd.com");
		WebElement we =dr.findElement(By.linkText("�ҵľ���"));
		Actions builder = new Actions(dr);
		Action mouserOverlogin = builder.moveToElement(we).build();
		mouserOverlogin.perform();
		
		
		Thread.sleep(3000);
		System.out.println("ok");
		dr.quit();
	}
}
