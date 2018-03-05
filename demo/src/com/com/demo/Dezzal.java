package com.com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dezzal {

	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://login.dezzal.com/sign-up.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void DZLogin() {
		driver.get(baseUrl);
		String e_mail = "2694571567@qq.com";
		String password = "123456";
		Log_in.login(driver, e_mail, password);
	}

	@Test(priority = 2)
	public void getprotect() throws InterruptedException {
		driver.navigate().to("http://www.dezzal.com/bottoms-d_81/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='js_proList']/ul/li[2]/p/a")).click();	
		WebElement addbag = driver.findElement(By.id("new_addcart"));
		addbag.click();
		driver.findElement(By.xpath("//*[@id='js_topCart']/span[2]")).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

		WebElement price1 = driver.findElement(By.id("items_sub_total"));
		System.out.println("���ﳵ���ܼ۸�" + price1.getText());
		driver.findElement(By.xpath("//*[@id='js_floatBox']/section/div/p[2]/a")).click();

		WebElement price2 = driver.findElement(By.id("price_total"));
		System.out.println("����ҳ�۸�" + price2.getText());

		if (price1.equals(price2)) {
			System.out.println("���ﳵ�����ҳ�۸���ȣ�");
		} else {
			System.out.println("���ﳵ�����ҳ�۸���ȣ�");
		}
	}

	@Test(priority = 3)
	public void Getnu() throws InterruptedException {
		driver.findElement(By.id("js_upMyOrder")).click();
		//������Ԫ�ؾ��Ƕ�λ��������֪��ʲôԭ��
		driver.findElement(By.xpath("//*[@id='cancelLink']")).click();
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.linkText("MY ORDERS"))).perform();
		WebElement Number=
		driver.findElement(By.xpath("//div[class='userH_box orderBox p15']/table/tbody/tr[2]/td[1]/a"));
		System.out.println("�����ţ�"+Number.getText());
	}

	@AfterClass
	public void DZquit() {
		// driver.quit();
	}

}
