package com.selenium2;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upfile {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		File file = new File("E:/upfile.html"); 
		String filePath =file.getAbsolutePath();
		driver.get(filePath);
		driver.findElement(By.name("file")).sendKeys("E:\\bug的小结");
		
		Thread.sleep(6000);
		
		System.out.println("上传成功");
		driver.quit();
		
	}
}
