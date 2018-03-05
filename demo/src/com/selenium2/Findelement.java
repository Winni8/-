package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Findelement {
		public static void main(String[] args) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
			WebDriver dr  =new FirefoxDriver();
			/*dr.get("https://www.baidu.com");
			dr.findElement(By.id("kw")).sendKeys("小坦克 博客园");
			dr.findElement(By.linkText("百度一下")).click();百度輸入框級搜索*/
			
			/*dr.get("https://www.taobao.com");
			WebElement souso=dr.findElement(By.className("search-combobox-input"));
			souso.sendKeys("杯子");
			souso.submit();*/  //采用className的方式定位，淘寶網的搜索框；
			
			/*dr.get("https://www.baidu.com");
			dr.findElement(By.xpath("//input[@id='kw']")).sendKeys("美团");*/
			//xpath 用单引号,此例为相对路径；
			
			try{
				Thread.sleep(4000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("结束。");
			dr.quit();
		}
		
}
