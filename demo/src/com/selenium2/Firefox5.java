package com.selenium2;
/**
 * 
 * 
 * 
 * 模拟鼠标事件失败
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Firefox5 {
	public static void main(String[] args) throws Exception {
		System.out.println("kaihsi");
		System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.jd.com/");
		WebElement element = dr.findElement(By.linkText("我的京东"));
		
		Actions Action = new Actions(dr);
		Action.click(element).perform();
		
		//Action mouserOverlogin = builder.moveToElement(element).build();
		//mouserOverlogin.perform();//执行所有Actions中存储的行为。
		Thread.sleep(3000);
		dr.quit();
		System.out.println("jieshu");
	}
}
