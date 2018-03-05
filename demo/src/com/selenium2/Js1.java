package com.selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Js1 {
	public static void main(String[] args) throws Exception {        
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();     
               
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);        
        driver.get("http://blog.csdn.net/u011541946");       
        Thread.sleep(5000);
        
        // 定义csdn底部 公司简介 这个元素
        WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));
        //创建一个javascript 执行实例
      	JavascriptExecutor je = (JavascriptExecutor) driver;
     		
      	//执行js语句，拖拽浏览器滚动条，直到该元素到底部，马上就不可以见
      	je.executeScript("arguments[0].scrollIntoView(true);",element);
      
      	System.out.println("混动成功");
      	
      	driver.quit();
    }  
}
