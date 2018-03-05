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
 * ��ʾʵ��
 * @author linchaojiang
 *
 */
public class Demo {
	
	WebDriver driver;
	
	/**
	 * ������֮ǰ����
	 * һ����һЩ��ʼ������
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
	 * ���в���
	 */
	@Test
	public void login(){
		//��url
		driver.get("https://login.sammydress.com.trunk.s1.egomsl.com/m-users-a-sign.htm");
		//��ȡ���û��������,�������˺�
		driver.findElement(By.id("email")).sendKeys("autotest01@globalegrow.com");
		//��ȡ�����������,����������
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		//��ȡ����֤�������,������ֵ
		driver.findElement(By.id("code")).sendKeys("123456");
		//��ȡ����¼��ť,�������¼
		driver.findElement(By.id("js_signInBtn")).click();
		//ͣ��5��
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//��ȡ��������
		WebElement order = driver.findElement(By.cssSelector("#mCSB_1 > div.mCSB_container.mCS_no_scrollbar > ul > li:nth-child(1) > a"));
		//����
		if (!order.equals(null)) {
			System.out.println("��¼�ɹ�������");
			Assert.assertTrue(true);
		}else {
			System.out.println("��¼ʧ�ܣ�����");
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * ��������֮��ִ��
	 * һ��ִ����β����
	 */
	@AfterClass
	public void afterClass(){
		//�ر������
		driver.quit();
	}

}
