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
			dr.findElement(By.id("kw")).sendKeys("С̹�� ����԰");
			dr.findElement(By.linkText("�ٶ�һ��")).click();�ٶ�ݔ�������*/
			
			/*dr.get("https://www.taobao.com");
			WebElement souso=dr.findElement(By.className("search-combobox-input"));
			souso.sendKeys("����");
			souso.submit();*/  //����className�ķ�ʽ��λ���Ԍ��W��������
			
			/*dr.get("https://www.baidu.com");
			dr.findElement(By.xpath("//input[@id='kw']")).sendKeys("����");*/
			//xpath �õ�����,����Ϊ���·����
			
			try{
				Thread.sleep(4000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("������");
			dr.quit();
		}
		
}
