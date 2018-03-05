package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IE {
	public static void main(String[] args) {
		String url = "https://www.baidu.com";
		System.out.println("seting brwoser");
		
		System.setProperty("webdriver.IEDriverServer.driver",
				"C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(url);
		wd.navigate().to(url);
		wd.quit();
		System.out.println("voer");

	}
}
