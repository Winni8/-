package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//�������  �ȸ���������ԣ�Ŀǰ�����ĺ���汾����
public class Mouse2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("����"))).perform();
		
		action.click(driver.findElement(By.linkText("������ʷ"))).perform();
		
		try{
			Thread.sleep(5000);		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
