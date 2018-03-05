package com.com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Twinkle {
	private WebDriver driver;
	private String baseUrl;

	@BeforeSuite
	public void Start() {
		System.out.println("程序开始：");
	}

	@AfterSuite
	public void End() {
		System.out.println("程序结束：");
	}

	@BeforeClass
	public void Setup() {
		System.out.println("开始运行测试点：");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://twinkledeals.com.b.s1.egomsl.com/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void Over() {
		System.out.println("测试点结束：");
		// driver.quit();
	}

	/**
	 * @author chenjingjian 验证点：登陆
	 */
	@Test(priority = 1)
	public void TDlogin() {
		driver.get(baseUrl);
		String e_mail = "2694571567@qq.com";
		String password = "123456";
		Log_in.login(driver, e_mail, password);
	}

	/**
	 * 
	 * 验证点：分类商品排序,价格从低到高；
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(priority = 2)
	public void Sort() throws InterruptedException {
		driver.findElement(By.linkText("JEWELRY")).click();
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='js_cateTopBar']/div/div[3]/div/span"))).perform();
		action.click(driver.findElement(By.linkText("$ Low to High"))).perform();
		Thread.sleep(2000);

		WebElement first1 = driver.findElement(By.xpath("//*[@id='js_cateListUl']/li[1]/p[2]/span[2]"));
		String get_price1 = first1.getText().substring(1);
		double price1 = Double.parseDouble(get_price1);
		System.out.println(price1);

		WebElement first2 = driver.findElement(By.xpath("//*[@id='js_cateListUl']/li[2]/p[2]/span[2]"));
		String get_price2 = first2.getText().substring(1);
		double price2 = Double.parseDouble(get_price2);
		System.out.println(price2);

		WebElement first3 = driver.findElement(By.xpath("//*[@id='js_cateListUl']/li[3]/p[2]/span[2]"));
		String get_price3 = first3.getText().substring(1);
		double price3 = Double.parseDouble(get_price3);
		System.out.println(price3);

		if (price1 < price2 || price2 < price3) {
			System.out.println("价格是从地到高排列");
		} else {
			System.out.println("价格不是从地到高排列");
		}
	}

	/**
	 * 测试点：商品添加购物车； 验证购物车的总价格；
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	@Test(priority = 3)
	public void Addproduct() throws Exception {
		driver.findElement(By.xpath("//*[@id='js_cateListUl']/li[1]/p[1]/a")).click();
		driver.findElement(By.id("new_addcart")).click();
		Thread.sleep(3000);

		WebElement pro_price = driver.findElement(By.xpath("//*[@id='cart_list']/div[3]/div[2]/div[3]/strong/span[2]"));
		String product_price = pro_price.getText();
		System.out.println("购物车的总价" + product_price);
		driver.findElement(By.xpath("//*[@id='js-paypalBox']/a/span")).click();

	}

	/**
	 * @author chenjingjian 验证点：结算页编辑地址，结算页的价格；
	 * @param webElement
	 * @param webElements
	 * 
	 * 
	 */
	@Test(priority = 4, enabled = false)
	public void Addcountry() {
		WebElement DZaddress = driver.findElement(By.xpath("//*[@id='consignee']/h4/a"));
		DZaddress.click();
		Select select = new Select(driver.findElement(By.name("country")));
		// 2、getOptions()方法获得的是一个WebElement的集合
		List<WebElement> country = select.getOptions();
		// 3、新建一个List，用来存储每个选项的文本值
		List<String> downs = new ArrayList<>();
		// 4.历遍集合；
		for (WebElement webElement : country) {
			String List_country = webElement.getText();
			// System.out.println(List_country);
		}
		// 5.将每个选项的文本值添加到List集合,得到所有国家
		downs.add("List_country");

		// 6.获取下拉选项的数量
		int num = country.size();
		System.out.println("country：" + num);
		// 7.机选国家
		int random = (int) (1 + Math.random() * (num - 1));
		String s = random + "";
		System.out.println("国家对应的value值：" + s);
		select.selectByValue(s);
	}

	/**
	 * @author chenjingjian; 编辑省份； 验证点：机选省份
	 * 
	 */
	@Test(priority = 5, enabled = false)
	public void Addprovince() {
		Select select_province = new Select(driver.findElement(By.name("province")));
		/*
		 * List<WebElement> citys = select_province.getOptions(); List<String>
		 * downs_citys = new ArrayList<>(); for (WebElement webElement1 : citys)
		 * { String List_citys = webElement1.getText();
		 * downs_citys.add(List_citys); // System.out.println(downs_citys); }
		 * int num_city = citys.size(); System.out.println("city的数量：" +
		 * num_city); int random_city = (int) (1 + Math.random() * (num_city));
		 */
		select_province.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id='consignee0']/ul/li[8]/div/select/option[1]")).submit();
	}

	/**
	 * @author chenjingjian 测试地点：获取第三方的价格，对比结算页的价格； 中间需要求换窗口才能获取价格
	 * 
	 * 
	 */
	@Test(priority = 6, enabled = true)
	public void pricevs() {
		WebElement pricesv = driver.findElement(By.id("price_total"));
		String ck_price = pricesv.getText() + " USD";
		System.out.println("结算页价格：" + ck_price);
		driver.findElement(By.id("placeOrderBtn")).click();

		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(currentWindow);
		System.out.println("句柄的个数：" + handles.size());
		if (handles.size() > 0) {
			try {
				// 定位窗口
				driver.switchTo().window(handles.iterator().next());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String currentWindow1 = driver.getWindowHandle();
		System.out.println(currentWindow1);
		WebElement pricesv2 = driver.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		String ck_price2 = pricesv2.getText();
		System.out.println("第三方价格：" + ck_price2);

		if (ck_price.equals(ck_price2)) {
			System.out.println("结算页与第三方价格相等；");
		} else {
			System.out.println("获取的价格不相等；");
		}
	}

	@Test(priority = 7)
	public void Login_PP() throws InterruptedException {
		WebElement td_iframe = driver.findElement(By.name("injectedUl"));
		driver.switchTo().frame(td_iframe);

		WebElement input_pp_email = driver.findElement(By.id("email"));
		input_pp_email.clear();
		input_pp_email.sendKeys("441817_1310950685_per@qq.com");

		WebElement input_pp_password = driver.findElement(By.id("password"));
		input_pp_password.clear();
		input_pp_password.sendKeys("123123123");

		driver.findElement(By.id("btnLogin")).click();
		
		 driver.switchTo().defaultContent();
		
		driver.findElement(By.id("button")).click();
		Thread.sleep(3000);

		// System.out.println(handles1);
		// driver.switchTo().defaultContent();
	}

	@Test(priority = 8, enabled = false)
	public void GetNum() {
		WebElement number = driver.findElement(By.xpath("//*[@id='cartWrap']/div[2]/p[1]/strong"));
		String TD_number = number.getText();
		System.out.println("订单号：" + TD_number);
	}

}
