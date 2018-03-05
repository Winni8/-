package com.com.demo;
/***
 * 
 * 数组 搞不定；
 * 
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testarray {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://login.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-sign.htm";
		// 定义对象数组
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider(name = "user")
	public Object[][] Users() {
		return new Object[][] { 
			{" ","","Please enter a valid email address"},
			{"2694571567@qq.com","456789 ","Your email/password is incorrect. Please try again."},
			{"456123@qq.com ","123456","Your email/password is incorrect. Please try again."},
			{"5467913@qq.com","46513213","Your email/password is incorrect. Please try again."},
			};
	}

	@Test(dataProvider = "user")
	public void testCase(String username, String password, String expectText) throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		Log_in.login(driver, username, password);
		Thread.sleep(2000);

		String text = driver.findElement(By.xpath("//div[@class='operalForm pt10']/p")).getText();
		System.out.println(text);
		System.out.println(expectText);
		Assert.assertEquals(text, expectText);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}