package com.Blog;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetNum {
	private WebDriver driver;
	private String baseUrl;
	private String e_mail = "2694571567@qq.com";
	private String password = "123456";

	@BeforeClass
	public void Setup() {
		System.out.println("开始运行测试点：");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://login.rosewholesale.com.b.s1.egomsl.com/m-users-a-sign.htm";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Login() {
		driver.get(baseUrl);
		RW_Login.Login(driver, e_mail, password);
	}

	@Test(priority = 2)
	public void get_num() {
		// 获取列表行数，注意这个tr
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr"));

		// 或css
		// List<WebElement> rows =driver.findElements(By.cssSelector("#userMain
		// > div.userH_box.orderBox.p15 > table > tbody > tr"));
		// i就是控制你要取的那几行
		for (int i = 1; i < rows.size(); i++) {
			// 取得数据
			String OrderNo = rows.get(i).findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[1]"))
					.getText();
			String Ordertime = rows.get(i).findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[2]"))
					.getText();
			String Totalamount = rows.get(i)
					.findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[3]/span[2]")).getText();
			String OrderStatus = rows.get(i).findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[4]"))
					.getText();
			String Operation = rows.get(i)
					.findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[5]/a[2]")).getText();

			System.out.println("表格数据" + i + ":" + OrderNo + " " + Ordertime + " " + Totalamount + " " + OrderStatus
					+ " " + Operation);
		}
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}

}
