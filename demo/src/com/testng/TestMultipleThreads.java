package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestMultipleThreads {
	@Test(invocationCount = 3)
    public void loadTestThisWebsite() {
		System.setProperty("webdriver.gecko.driver", 
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");      
        WebDriver driver = new FirefoxDriver();  
        driver.get("http://www.yiibai.com");
        System.out.println("Page Title is " + driver.getTitle());
        //AssertJUnit.assertEquals("Google", driver.getTitle());
        driver.quit();
	}

}
