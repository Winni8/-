package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr =new FirefoxDriver();
		/*dr.get("https://www.taobao.com/");
		Actions action = new Actions(dr);
		action.click(dr.findElement(By.className("search-combobox-input"))).sendKeys("����");*/
		//�Lԇ��
		dr.get("https://www.baidu.com/");
		//�������
		/*dr.navigate().back();
		Thread.sleep(3000);
		
		Actions action=new Actions(dr);
		action.click(dr.findElement(By.name("wd"))).sendKeys("�ֵ�");*/
		
		//˫��
		Actions action=new Actions(dr);
		action.clickAndHold(dr.findElement(By.id("1"))).moveToElement(dr.findElement(By.id("3"))).perform();
		action.release();
		
		Thread.sleep(5000);
		System.out.println("�ɹ�");
		dr.quit();
	}
}
