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
		System.out.println("����Ϊ:" + getsize.size());
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
		// ��һ������ȡ��Ʒ�۸�
		String A = driver.findElement(By.id("unit_price2")).getText();
		System.out.println("��Ʒ�۸�Ϊ:" + A);
		// �ڶ�������������Ʒ��ť
		driver.findElement(By.id("new_addcart")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ���������Ա���Ʒ����
		String B = driver.findElement(By.xpath("//*[@id='js_floatBox']/section/div/div[3]/ul[2]/li[2]/span[2]"))
				.getText();
		System.out.println("��Ʒ�۸�Ϊ:" + B);
		// Assert.assertEquals(A, B);
		driver.findElement(By.id("js_checkoutBtn")).click();
	}

	*//**
	 * 
	 * @���Ե�: ��Ʒ���н��� 1.�����Ʒ���޸���Ʒ��ַ���޸ĵ������ 2.�ύ��֧��ҳ�棬
	 * @��֤��: ֧��ҳ����Ʒ�۸���֧��ҳ��۸�һ��
	 * @param @��ע��
	 *            void
	 * @author zhangjun
	 * @date 2018��1��9��
	 * @�޸�˵��
	 *//*
	@Test(priority = 2)
	public void ClearingGoods() {
		String actuals = "Algeria";

		// �༭��ť�Ķ���
		WebElement addressedit = driver.findElement(By.id("js_address_edit"));
		addressedit.click();

		// ��ȡselect Ԫ��
		sleep(3);
		Select select = new Select(driver.findElement(By.id("address_edit_country")));
		select.selectByValue("46");

		// �޸�state,���ò�ͬ��ֵ
		sleep(3);
		Select select2 = new Select(driver.findElement(By.id("states_0_0")));
		select2.selectByVisibleText("Delvine");
		//
		// ���city��Ԫ�أ��ڴν�������----��ʵ��
		WebElement name = driver.findElement(By.name("city"));

		// ���ʹ�ø����µ�ַ��Ҳ����ȷ��
		WebElement editsubmit = driver.findElement(By.id("address_edit_submit"));

		// ��ѯ��ַ�Ƿ���ĳɹ�
		WebElement jsconsign = driver.findElement(By.xpath("//*[@id='jsconsigneeList']/li[4]"));
		// ��ȡҳ���ı��������������Ƿ����Լ���Ҫ������

		System.out.println("��ȡҳ���Ԫ��Ϊ:");

		// ��ȡҳ����ܼۣ���Ҫ����$�ķ��ŵ���������
		WebElement pricetotal = driver.findElement(By.id("price_total"));
		System.out.println("��ȡҳ����ܼ�Ϊ:");

		// ������ﰴť��ת��PP֧��ҳ��
		WebElement upfrom = driver.findElement(By.id("js_upFormBtn"));

		// ��ת��PP֧��ҳ�棬��ȡpp���ܼ�
		sleep(20);
		WebElement pricetotalpp = driver
				.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		// ��ȡPP��֧��ҳ���ܼ�

		System.out.println("��ȡPPҳ����ܼ�Ϊ:");

		// �����ύ֧�����ܼ���PP֧��ҳ����ܼ�

		// �л�iframe���ڣ����뵽PP֧��ҳ�棬�����û���������

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