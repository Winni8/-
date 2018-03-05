package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Download {
	public static void main(String[] args) throws InterruptedException {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", "d:\\java");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/octet-stream");
		
		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://pypi.Python.org/pypi/selenium");
		dr.findElement(By.partialLinkText("selenium-3.8.1-py2.py3-none-any.whl")).click();
		
		Thread.sleep(5000);
		
		System.out.println("œ¬‘ÿ≥…π¶");
		dr.quit();
	}
}
