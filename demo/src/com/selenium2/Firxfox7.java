package com.selenium2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firxfox7 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();

		String searchHandle = driver.getWindowHandle();
		System.out.println("baidu search handle : " + searchHandle);

		// ��ȡ�ٶ����ŵ����ӣ�Ȼ������js��һ���µĴ���
		waitTime(3000);
		String href = driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
		System.out.println("the link of news is : " + href);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.open('" + href + "')");

		waitTime(3000);
		Set<String> handles = driver.getWindowHandles();
		Iterator iterator = handles.iterator();
		Iterator iterator2 = handles.iterator();

		// ����ٶ����Ŵ���,����ȡtitle��֤
		waitTime(3000);
		while (iterator.hasNext()) {
			String h = (String) iterator.next();
			if (h != searchHandle) {
				driver.switchTo().window(h);
				if (driver.getTitle().contains("�ٶ�����")) {
					System.out.println("switch to news page successfully");
					break;
				} else {
					continue;
				}
			}

		}

		// ���ذٶ���ҳ
		waitTime(3000);
		/*
		 * ����ֱ��ʹ��searchHandle���л���Ҳ�������ñ������л�
		 * driver.switchTo().window(searchHandle);
		 * if(driver.getTitle().contains("�ٶ�һ��")){ System.out.println(
		 * "switch to search page successfully");
		 * driver.findElement(By.cssSelector("#kw")).sendKeys(
		 * "switch successfully"); }
		 */
		while (iterator2.hasNext()) {
			String h = (String) iterator2.next();
			if (searchHandle.equals(h)) {
				driver.switchTo().window(h);
				if (driver.getTitle().contains("�ٶ�һ��")) {
					System.out.println("switch to search page successfully");
					driver.findElement(By.cssSelector("#kw")).sendKeys("switch successfully");
					break;
				} else {
					continue;
				}
			}

		}

		waitTime(3000);
		driver.quit();

	}

	static public void waitTime(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}