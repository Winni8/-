package com.Blog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testisenabled {
	public static void main(String[] args) {
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Driver.get("https://www.baidu.com/");
		
		if(Driver.findElement(By.id("kw")).isEnabled() ){
			System.out.println("¿É±à¼­");
			Driver.findElement(By.id("kw")).sendKeys("±à¼­");
		}else{
			System.out.println("²»¿É±à¼­");
		}
		
		Driver.quit();
	}
}