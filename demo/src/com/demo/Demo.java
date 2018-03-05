package com.demo;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 演示实例
 * @author linchaojiang
 *
 */
public class Demo {
	
	WebDriver driver;
	
	/**
	 * 运行类之前运行
	 * 一般做一些初始化操作
	 */
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); 		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();  
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));  
        ChromeOptions options = new ChromeOptions();  
        options.addArguments("--test-type");  
        capabilities.setCapability("chrome.binary", "driver/chromedriver.exe");  
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);  
        driver = new ChromeDriver(capabilities);
	}
	
	/**
	 * 运行测试
	 */
	@Test
	public void login(){
		//打开url
		driver.get("https://login.sammydress.com.trunk.s1.egomsl.com/m-users-a-sign.htm");
		//获取到用户名输入框,并输入账号
		driver.findElement(By.id("email")).sendKeys("autotest01@globalegrow.com");
		//获取到密码输入框,并输入密码
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		//获取到验证码输入框,并输入值
		driver.findElement(By.id("code")).sendKeys("123456");
		//获取到登录按钮,并点击登录
		driver.findElement(By.id("js_signInBtn")).click();
		//停留5秒
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//获取订单链接
		WebElement order = driver.findElement(By.cssSelector("#mCSB_1 > div.mCSB_container.mCS_no_scrollbar > ul > li:nth-child(1) > a"));
		//断言
		if (!order.equals(null)) {
			System.out.println("登录成功！！！");
			Assert.assertTrue(true);
		}else {
			System.out.println("登录失败！！！");
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * 运行完类之后执行
	 * 一般执行收尾工作
	 */
	@AfterClass
	public void afterClass(){
		//关闭浏览器
		driver.quit();
	}

}
