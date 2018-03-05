package com.Blog;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testhandle1 {
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
		// Driver.quit();
	}

	@Test
	public void testhands() {
		String cuthandle = Driver.getWindowHandle();
		Driver.findElement(By.xpath(".//*[@id='open']/a")).click();
		Set<String> handles = Driver.getWindowHandles();
		System.out.println(handles);
		handles.remove(cuthandle);
		// 虽然说剩余句柄一样，但是直接使用handles不行，因为他是个数组；必行重新获取当前的句柄；
		String newhandles = handles.iterator().next();
		System.out.println(handles);
		Driver.switchTo().window(newhandles);
		Driver.findElement(By.id("q")).sendKeys("袜子");
		Driver.findElement(By.xpath(".//*[@id='J_TSearchForm']/div[1]/button")).click();
		// Driver.switchTo().window(cuthandle);

		// Driver.navigate().to("https://www.baidu.com");
		//把窗口设成一个 数组表，从表的索引去跳转链接；与本地链接跳转一个意思；
		ArrayList<String> tabs = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs.get(1));
		Driver.get("https://www.baidu.com");

		Driver.close();
		Driver.switchTo().window(cuthandle);
		Driver.findElement(By.id("user")).sendKeys("回来了");

	}

}
