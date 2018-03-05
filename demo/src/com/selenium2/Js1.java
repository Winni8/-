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
        
        // ����csdn�ײ� ��˾��� ���Ԫ��
        WebElement element = driver.findElement(By.xpath("//*/dd[@class='foot_sub_menu']/a[1]"));
        //����һ��javascript ִ��ʵ��
      	JavascriptExecutor je = (JavascriptExecutor) driver;
     		
      	//ִ��js��䣬��ק�������������ֱ����Ԫ�ص��ײ������ϾͲ����Լ�
      	je.executeScript("arguments[0].scrollIntoView(true);",element);
      
      	System.out.println("�춯�ɹ�");
      	
      	driver.quit();
    }  
}
