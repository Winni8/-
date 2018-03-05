package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * 
 * 
 * ��������
 */

public class Firefox4 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		// dr.get("https://www.twinkledeals.com/");
		// dr.navigate().refresh();
		/*
		 * WebElement el =dr.findElement(By.xpath("//input[@name='k1']"));
		 * Select k1 =new Select(el); k1.deselectByIndex(3);
		 */

		dr.get("http://sahitest.com/demo/selectTest.htm");
		WebElement element = dr.findElement(By.id("s1Id"));
		Select s1Id = new Select(element);
		s1Id.selectByIndex(1);
		// s1Id.selectByValue("o2");
		// s1Id.selectByVisibleText("o3");

		// Thread.sleep(3000);
		// dr.quit();
	}
}
