package com.Blog;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testhandle {

	private WebDriver Driver;

	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	@AfterClass
	public void closeFirefox() {
		//Driver.quit();
	}
	
	@Test
	public void testIframe() throws InterruptedException {
		Driver.findElement(By.id("user")).sendKeys("my test");
		// 切换ifame
		WebElement element = Driver.findElement(By.name("aa"));
		Driver.switchTo().frame(element);

		Driver.findElement(By.id("user")).sendKeys("iframe test");
		//*************************************
		//返回默认的iframe；注意应经返回了；
		//Driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver.findElement(By.id("user")).sendKeys("my end test");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// 对多个窗口进行切换操作

		WebElement element2 = Driver.findElement(By.className("open"));
		element2.click();
		Set<String> handles = Driver.getWindowHandles();
		System.out.println("总句柄个数："+handles.size());
		
		String handle = Driver.getWindowHandle(); // 得到默认最初窗体句柄	
		System.out.println("默认窗口句柄:"+handle);
		
		handles.remove(handle);
		if(handles.size()>0){
			try{
				Driver.switchTo().window(handles.iterator().next());
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String handle2= Driver.getWindowHandle();
		System.out.println("切换窗口之后的句柄："+handle2);
		
		// 跳到百度，輸入myString
		//Driver.findElement(By.id("kw")).sendKeys("myString");
		Thread.sleep(3000);

		// 回到最开始的窗口
		Driver.switchTo().window(handle);
		
		String handle1 = Driver.getWindowHandle();
		System.out.println("返回默认窗口之后的句柄："+handle1);
		//我都没有返回默认iframe，怎么就跑到默认iframe里操作了？？？,********************
		
		
		if(handle.equals(handle1)){
			System.out.println("说明在同一窗口；");
		}else{
			System.out.println("false");
		}
		//再次切到iframe去
		Driver.switchTo().frame(element);
		Driver.findElement(By.id("user")).sendKeys("new test");

	}
}
