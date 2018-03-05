package com.selenium2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * 
 * 切换窗口：成功
 * 
 */
public class Firefox6 {
	public static boolean switchToWindow(String windowTitle, WebDriver dr) {
		boolean flag = false;
		try {
			String currentHandle = dr.getWindowHandle();
			Set<String> handles = dr.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle)) {
					continue;
				} else {
					dr.switchTo().window(s);
					if (dr.getTitle().contains(windowTitle)) {
						flag = true;
					System.out.println("Switch to window: " + windowTitle + " successfully!");
						break;
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			System.out.printf("Window: " + windowTitle + " cound not found!", e.fillInStackTrace());
			flag = false;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yeshen.com/");
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("夜神游戏"))).perform();
		
		action.click(driver.findElement(By.linkText("游戏中心"))).perform();
		action.click(driver.findElement(By.linkText("游戏论坛"))).perform();
				
		Thread.sleep(3000);
		
		Firefox6.switchToWindow("游戏中心_夜神安卓模拟器", driver);
		driver.findElement(By.linkText("辅助"));
		Thread.sleep(3000);
		
		System.out.println("over");
		driver.close();
		
	}
}
