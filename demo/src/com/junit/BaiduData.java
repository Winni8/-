package com.junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaiduData {
	public static void baiduTest(String lineTxt) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("testdate");
		driver.findElement(By.id("su")).click();
		
		Thread.sleep(3000);
		driver.close();		
	}
	public static void readTetFile(String filePath){
		try{
			String encoding="GBK";
			File file =new File(filePath);
			if(file.isFile() && file.exists()){
				InputStreamReader read = new InputStreamReader(	new FileInputStream(file),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt=bufferedReader.readLine())!= null) {
					System.out.println(lineTxt);
					baiduTest(lineTxt);
				}
				read.close();
			}else{
				System.out.println("找不到指定文件");
				
			}
			
		}catch(Exception e){
			System.out.println("讀取內容");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String filePath ="E:\\info.txt";
		readTetFile(filePath);
		
	}
}
