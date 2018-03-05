package com.com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRW {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://login.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-sign.htm";
		// 隐身等待；
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1) // 登陆
	public void testcase() throws Exception {
		// String url =
		// "http://user.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-order_list.htm";
		driver.get(baseUrl);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		List<WebElement> getsize = driver.findElements(By.tagName("input"));
		System.out.println("总数为:" + getsize.size());
		driver.findElement(By.id("js_signInBtn")).click();
		Thread.sleep(3000);
		/*
		 * String geturl = driver.getCurrentUrl(); Assert.assertEquals(geturl,
		 * url); String getname =
		 * driver.findElement(By.partialLinkText("Hi")).getText();
		 */
	}

	@Test(priority = 2) // 商品添加到购物车；
	public void addProduct() {
		driver.navigate().to("http://rosewholesale.com.trunk.s1.egomsl.com/cheap-online/plus-sizes-c157/");
		driver.findElement(By.xpath("//*[@id='js_proList']/ul/li[1]/p[1]/a[1]/img")).click();
		driver.findElement(By.id("new_addcart")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void checkout() throws InterruptedException{		
		//String actuals = "Australia";
		
		driver.findElement(By.id("js_checkoutBtn")).click();
		Thread.sleep(3000);
		//编辑地址：
		WebElement addressedit = driver.findElement(By.id("js_address_edit"));
		addressedit.click();
		
		//选择国家
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.id("address_edit_country")));
		select.selectByValue("11");
		
		//选择城市
		Thread.sleep(3000);
		Select select2 = new Select(driver.findElement(By.id("states_0_0")));
		select2.selectByVisibleText("New South Wales");
		
		WebElement name = driver.findElement(By.name("city"));
		name.clear();
		name.sendKeys("tesRW");
		
		//提交编辑的地址；
		driver.findElement(By.id("address_edit_submit")).click();
	
		// 查询地址是否更改成功
		WebElement jsconsign = driver.findElement(By.xpath("//*[@id='jsconsigneeList']/li[3]"));
		String s= jsconsign.getText();
		System.out.println("地址："+s);

/*		if(   ){
			System.out.println("更改成功；");
		}else{
			System.out.println("编辑失败");
		}*/
		
	}
	
	@Test(priority = 4)
	 
	public void pricecomparison() throws Exception{
		// 获取页面的总价，不要带有$的符号等其他符号
		WebElement pricetotal = driver.findElement(By.id("price_total"));
		String price=pricetotal.getText();
		String prices=price+" USD";
		System.out.println("获取页面的总价为:"+prices);
		
		//选择支付方式
		driver.findElement(By.xpath("//*[@id='paymentlistPayPal']")).click();
				
		WebElement upfrom = driver.findElement(By.id("js_upFormBtn"));
		upfrom.click();
		Thread.sleep(3000);
		
		WebElement pricetotal1=
			driver.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		String price1=pricetotal1.getText();
		System.out.println("获取PP页面的总价为:"+price1);
		
		if(prices.equals(price1)){
			System.out.println("价格相等");
		}else{
			System.out.println("价格不相等");
		}
	}
		

	@AfterClass
	public void qiutcase() {
		driver.quit();
		System.out.println("執行成功");
	}
}
