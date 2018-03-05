package com.com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Getorder {
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
	public void checkout() throws InterruptedException {
		// String actuals = "Australia";

		driver.findElement(By.id("js_checkoutBtn")).click();
		// 编辑地址：
		WebElement addressedit = driver.findElement(By.id("js_address_edit"));
		addressedit.click();

		// 选择国家
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.id("address_edit_country")));
		select.selectByValue("11");

		// 选择城市
		Thread.sleep(3000);
		Select select2 = new Select(driver.findElement(By.id("states_0_0")));
		select2.selectByVisibleText("New South Wales");

		WebElement name = driver.findElement(By.name("city"));
		name.clear();
		name.sendKeys("tesRW");

		// 提交编辑的地址；
		driver.findElement(By.id("address_edit_submit")).click();

		// 查询地址是否更改成功
		WebElement jsconsign = driver.findElement(By.xpath("//*[@id='jsconsigneeList']/li[3]"));
		String s = jsconsign.getText();
		System.out.println("地址：" + s);

		/*
		 * if( ){ System.out.println("更改成功；"); }else{
		 * System.out.println("编辑失败"); }
		 */

	}

	@Test(priority = 4)
	public void pricecomparison() throws Exception {
		// 获取页面的总价，不要带有$的符号等其他符号
		WebElement pricetotal = driver.findElement(By.id("price_total"));
		String price = pricetotal.getText();
		String prices = price + " USD";
		System.out.println("pp结算页的总价为:" + prices);

		// 选择支付方式； 這個鬼定位订了3个小时
		driver.findElement(By.xpath("//*[@id='paymentlistPayPal']")).click();

		WebElement upfrom = driver.findElement(By.id("js_upFormBtn"));
		upfrom.click();
		Thread.sleep(3000);

		WebElement pricetotal1 = driver
				.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		String price1 = pricetotal1.getText();
		System.out.print("获取PP页面的总价为:" + price1+" 价格相不相等?:");

		if (prices.equals(price1)) {
			System.out.println("价格相等");
		} else {
			System.out.println("价格不相等");
		}
	}

	@Test(priority = 5)
	public void getorder() throws InterruptedException {
		WebElement iframe1 = driver.findElement(By.name("injectedUl"));
		
		driver.switchTo().frame(iframe1);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("441817_1310950685_per@qq.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123123123");
		// 时而成功时而不成功 搞不懂？
		driver.findElement(By.id("btnLogin")).click();

		// 返回默认的iframe
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@value='继续']"))).perform();
	}

	@Test(enabled = false)
	public void getnumber() {
		WebElement order = driver.findElement(By.id("mainWrap"));
		String number = order.getText();
		System.out.println("订单号：" + number);

		WebElement shop = driver.findElement(By.className("my_shop_price fb violet"));
		String shopprice = shop.getText();
		System.out.println("付款后的价格：" + shopprice);
	}

	
	@Test(priority = 7,dependsOnMethods={"testcase"})
	public void Nu(){
		driver.navigate().to("http://user.rosewholesale.com.b.s1.egomsl.com/m-users-a-order_list.htm");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		driver.findElement(By.id("js_signInBtn")).click();
		WebElement nu =driver.findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[1]"));
		String nus=nu.getText();
		System.out.println("订单号："+nus);
		
		WebElement price3=driver.findElement(By.xpath("//*[@id='userMain']/div[2]/table/tbody/tr[2]/td[3]"));
		String finalprice=price3.getText();
		System.out.println("个人中心的价格："+finalprice);
	}
	@AfterClass
	public void qiutcase() {
		driver.quit();
		System.out.println("執行成功");
	}
}
