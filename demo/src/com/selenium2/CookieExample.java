package com.selenium2;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//”õ‰õæè¥Ê£ª
public class CookieExample {
  public static void main(String[] args) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://userm.dezzal.com/sign-up.html");
		
		System.out.println("url="+driver.getCurrentUrl());
		
		Thread.sleep(3000);
		System.out.println(driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		
		Cookie c1 =new Cookie("email","2694571567@qq.com");
		Cookie c2 =new Cookie("password","123456");
		
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		
		System.out.println("ok");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
  	}
}
