package com.selenium2;
/**
 * ���̵���ز�����
 * sendKeys(Keys.BACK_SPACE) ɾ������BackSpace��
	sendKeys(Keys.SPACE) �ո��(Space)
	sendKeys(Keys.TAB) �Ʊ��(Tab)
	sendKeys(Keys.ESCAPE) ���˼���Esc��
	sendKeys(Keys.ENTER) �س�����Enter��
	sendKeys(Keys.CONTROL,"a") ȫѡ��Ctrl+A��
	sendKeys(Keys.CONTROL,"c") ���ƣ�Ctrl+C��
	sendKeys(Keys.CONTROL,"x") ���У�Ctrl+X��
	sendKeys(Keys.CONTROL,"v") ճ����Ctrl+V��
	sendKeys(Keys.F1) ���� F1
	����
    sendKeys(Keys.F12) ���� F12 
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
		we.sendKeys("�̳�");
		
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
