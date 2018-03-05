package com.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Js {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("webdriver api");
		driver.findElement(By.id("su")).click();
		//�������Ҫ����Ϊҳ���Ԫ��û��ȫ�������꣬�Ϳ�ʼ��Ԫ�أ�������ô�Ҷ��Ҳ�����
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		WebElement element = driver.findElement(By.xpath("//div[@id='foot']/span/a[1]")); 
		JavascriptExecutor je = (JavascriptExecutor) driver; 
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		
		///html/body/div[1]/div[3]/div[2]/span/a[1]
		Thread.sleep(3000);
		
		//((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=0");
		Thread.sleep(3000);
		
		System.out.println("�ɹ�");
		
		//driver.quit();
		driver.close();
	}
	
}
