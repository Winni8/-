package com.selenium2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExampe {
	public static void main(String[] args) {
		String url = "https://www.51.com";
		System.out.println("seting brwoser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(url);
		String js = "var user_input = document.getElementById(\"passport_51_user\").title;return user_input;";
		String title = (String) ((JavascriptExecutor) wd).executeScript(js);
		System.out.println(title);

	}
}