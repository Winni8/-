package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {
	public static void main(String[] args) throws Exception {
		String url = "http://rosegal.com.h.s1.egomsl.com/";
		System.out.println("seting brwoser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(url);
		// wd.navigate().to(url);
		// String title = wd.getTitle();
		// String currenturl = wd.getCurrentUrl();
		// System.out.println(title + "\n" + currenturl);
		// System.out.println(wd.getWindowHandle());
		// System.out.println(wd.getPageSource());
		// wd.quit();
		// Thread.sleep(5000);
		//wd.manage().window().maximize();//	窗口实际上没有最大化；
		wd.navigate().to("www.baidu.com");
		
		System.out.println("voer");

	}

}
