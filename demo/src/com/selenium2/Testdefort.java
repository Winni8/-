package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//搞不懂 默认是驱动路径就不行 必须的绝对路径；？？？？？？？？？？？？？？
public class Testdefort {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com");
		Thread.sleep(3000);
		driver.quit();
	}
}
