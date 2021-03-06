package com.Blog;
/**
 * @author chenjingjian
 * 验证点：窗口切换 与通过标题验证窗口；
 * 
 */
import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testmultiplewindowtitle {
	WebDriver Driver;
	
	@BeforeClass
	public void setup(){
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	Driver = new ChromeDriver();
	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Driver.get("https://www.w3schools.com/jsref/met_win_open.asp");
	}
	
	@Test
	public void testwindow() throws Exception{
		String parentwin=Driver.getWindowHandle();
//		String s1="Window open() Method";
//		String s2=Driver.getTitle();
//		if(s1.equals(s2)){
//			System.out.println("相等");
//		}
		assertEquals("Window open() Method", Driver.getTitle());
		WebElement teybutton =Driver.findElement(By.xpath(".//*[@id='main']/div[2]/a"));
		teybutton.click();
		
		Set<String> allwins =Driver.getWindowHandles();
		//类似，设一个临时句柄，相对于总句柄而言，使这个临时句柄历遍集合，也就是历遍总句柄；
		for(String windowild :allwins){
			if(Driver.switchTo().window(windowild).getTitle().contains("Tryit")){
				Driver.switchTo().window(windowild);
				break;				
			}		
		}
		assertEquals("Tryit Editor v3.5", Driver.getTitle());
		
		Driver.switchTo().window(parentwin);
		assertEquals("Window open() Method", Driver.getTitle());
	}
	@AfterClass
	public void quit(){
		Driver.quit();
	}
}
