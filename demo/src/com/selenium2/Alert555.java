package com.selenium2;
/**
 * 
 * �������ڵ�Ԫ�ض�λ���������²��ɹ���
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alert555 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("����"))).perform();
		
		driver.findElement(By.className("setpref")).click();
		driver.findElement(By.xpath("//div[@='gxszButton']/a")).click();
		
		
		driver.findElement(By.linkText("��������")).click();
		driver.switchTo().alert().accept();
		 
		 Thread.sleep(5000);
		 driver.quit();
		
	}
}
