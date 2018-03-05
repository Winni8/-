/*package com.com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.util.URIUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

public class login<util> {
	WebDriver driver;
	util method;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.binary", "driver/chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get("http://login.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-sign.htm");
		driver.manage().window().maximize();
		method = new util();
	}

	
	 * @BeforeClass public void beforeClass() {
	 * System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	 * capabilities.setCapability("chrome.switches",
	 * Arrays.asList("--incognito")); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--test-type");
	 * options.addArguments("start-maximized");
	 * options.addArguments("chrome.switches", "--disable-extensions");
	 * capabilities.setCapability("chrome.binary",
	 * "resources/chromedriver.exe");
	 * capabilities.setCapability(ChromeOptions.CAPABILITY, options); try {
	 * driver = new RemoteWebDriver(new
	 * URL("http://10.33.6.230:4444/hub"),capabilities); } catch
	 * (MalformedURLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * driver.get(
	 * "http://login.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-sign.htm");
	 * driver.manage().window().maximize(); method = new util(); }
	 

	@Test(priority = 0)
	public void login() {
		String url = "http://user.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-profile.htm";
		driver.findElement(By.id("email")).sendKeys("zhang@qq.com");
		driver.findElement(By.name("passwordsign")).sendKeys("123456");
		List<WebElement> getsize = driver.findElements(By.tagName("input"));
		System.out.println("总数为:" + getsize.size());
		driver.findElement(By.id("js_signInBtn")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String geturl = driver.getCurrentUrl();
		Assert.assertEquals(geturl, url);
		String getname = driver.findElement(By.partialLinkText("Hi")).getText();
		// Assert.assertEquals(getname, "Hi, zhang");

	}

	@Test(priority = 1)
	public void addProduct() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String product = method.getGoodUrl("one", "http://rosewholesale.com.trunk.s1.egomsl.com/", "n", "n");
		driver.get(product);
		// 第一步：获取商品价格
		String A = driver.findElement(By.id("unit_price2")).getText();
		System.out.println("商品价格为:" + A);
		// 第二步：点击添加商品按钮
		driver.findElement(By.id("new_addcart")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 第三步：对比商品数据
		String B = driver.findElement(By.xpath("//*[@id='js_floatBox']/section/div/div[3]/ul[2]/li[2]/span[2]"))
				.getText();
		System.out.println("商品价格为:" + B);
		// Assert.assertEquals(A, B);
		driver.findElement(By.id("js_checkoutBtn")).click();
	}

	*//**
	 * 
	 * @测试点: 商品进行结算 1.添加商品，修改商品地址，修改点击保存 2.提交到支付页面，
	 * @验证点: 支付页面商品价格与支付页面价格一致
	 * @param @备注：
	 *            void
	 * @author zhangjun
	 * @date 2018年1月9日
	 * @修改说明
	 *//*
	@Test(priority = 2)
	public void ClearingGoods() {
		String actuals = "Algeria";

		// 编辑按钮的对象
		WebElement addressedit = driver.findElement(By.id("js_address_edit"));
		addressedit.click();

		// 获取select 元素
		sleep(3);
		Select select = new Select(driver.findElement(By.id("address_edit_country")));
		select.selectByValue("46");

		// 修改state,设置不同的值
		sleep(3);
		Select select2 = new Select(driver.findElement(By.id("states_0_0")));
		select2.selectByVisibleText("Delvine");
		//
		// 清除city的元素，在次进行输入----来实操
		WebElement name = driver.findElement(By.name("city"));

		// 点击使用更改新地址，也就是确定
		WebElement editsubmit = driver.findElement(By.id("address_edit_submit"));

		// 查询地址是否更改成功
		WebElement jsconsign = driver.findElement(By.xpath("//*[@id='jsconsigneeList']/li[4]"));
		// 获取页面文本，并断言数据是否是自己需要的数据

		System.out.println("获取页面的元素为:");

		// 获取页面的总价，不要带有$的符号等其他符号
		WebElement pricetotal = driver.findElement(By.id("price_total"));
		System.out.println("获取页面的总价为:");

		// 点击购物按钮跳转到PP支付页面
		WebElement upfrom = driver.findElement(By.id("js_upFormBtn"));

		// 跳转到PP支付页面，获取pp的总价
		sleep(20);
		WebElement pricetotalpp = driver
				.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		// 获取PP的支付页面总价

		System.out.println("获取PP页面的总价为:");

		// 断言提交支付的总价与PP支付页面的总价

		// 切换iframe窗口，进入到PP支付页面，输入用户名和密码

	}

	public void sleep(int number) {
		try {
			Thread.sleep(number * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
*/