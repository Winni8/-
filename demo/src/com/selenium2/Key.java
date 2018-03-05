package com.selenium2;
/**
 * 键盘的相关操作；
 * sendKeys(Keys.BACK_SPACE) 删除键（BackSpace）
	sendKeys(Keys.SPACE) 空格键(Space)
	sendKeys(Keys.TAB) 制表键(Tab)
	sendKeys(Keys.ESCAPE) 回退键（Esc）
	sendKeys(Keys.ENTER) 回车键（Enter）
	sendKeys(Keys.CONTROL,"a") 全选（Ctrl+A）
	sendKeys(Keys.CONTROL,"c") 复制（Ctrl+C）
	sendKeys(Keys.CONTROL,"x") 剪切（Ctrl+X）
	sendKeys(Keys.CONTROL,"v") 粘贴（Ctrl+V）
	sendKeys(Keys.F1) 键盘 F1
	……
    sendKeys(Keys.F12) 键盘 F12 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Key {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement we =driver.findElement(By.id("kw"));
		we.sendKeys("selenium");
		we.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		
		we.sendKeys(Keys.SPACE);
		we.sendKeys("教程");
		
		Thread.sleep(5000);
		we.sendKeys(Keys.CONTROL,"a");
		we.sendKeys(Keys.CONTROL,"x");
		Thread.sleep(3000);
		driver.navigate().to("https://www.jd.com/2017?t=");
		
		WebElement we1 =driver.findElement(By.id("key"));
		
		we1.sendKeys(Keys.CONTROL,"v");
		we1.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}
}
