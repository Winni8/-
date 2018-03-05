package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//鼠标悬浮  谷歌浏览器可以，目前本机的狐火版本不行
public class Mouse2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("设置"))).perform();
		
		action.click(driver.findElement(By.linkText("搜索历史"))).perform();
		
		try{
			Thread.sleep(5000);		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
