package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//�㲻�� Ĭ��������·���Ͳ��� ����ľ���·��������������������������������
public class Testdefort {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com");
		Thread.sleep(3000);
		driver.quit();
	}
}
