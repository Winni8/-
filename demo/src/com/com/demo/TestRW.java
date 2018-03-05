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
		// ����ȴ���
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1) // ��½
	public void testcase() throws Exception {
		// String url =
		// "http://user.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-order_list.htm";
		driver.get(baseUrl);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		List<WebElement> getsize = driver.findElements(By.tagName("input"));
		System.out.println("����Ϊ:" + getsize.size());
		driver.findElement(By.id("js_signInBtn")).click();
		Thread.sleep(3000);
		/*
		 * String geturl = driver.getCurrentUrl(); Assert.assertEquals(geturl,
		 * url); String getname =
		 * driver.findElement(By.partialLinkText("Hi")).getText();
		 */
	}

	@Test(priority = 2) // ��Ʒ��ӵ����ﳵ��
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
		//�༭��ַ��
		WebElement addressedit = driver.findElement(By.id("js_address_edit"));
		addressedit.click();
		
		//ѡ�����
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.id("address_edit_country")));
		select.selectByValue("11");
		
		//ѡ�����
		Thread.sleep(3000);
		Select select2 = new Select(driver.findElement(By.id("states_0_0")));
		select2.selectByVisibleText("New South Wales");
		
		WebElement name = driver.findElement(By.name("city"));
		name.clear();
		name.sendKeys("tesRW");
		
		//�ύ�༭�ĵ�ַ��
		driver.findElement(By.id("address_edit_submit")).click();
	
		// ��ѯ��ַ�Ƿ���ĳɹ�
		WebElement jsconsign = driver.findElement(By.xpath("//*[@id='jsconsigneeList']/li[3]"));
		String s= jsconsign.getText();
		System.out.println("��ַ��"+s);

/*		if(   ){
			System.out.println("���ĳɹ���");
		}else{
			System.out.println("�༭ʧ��");
		}*/
		
	}
	
	@Test(priority = 4)
	 
	public void pricecomparison() throws Exception{
		// ��ȡҳ����ܼۣ���Ҫ����$�ķ��ŵ���������
		WebElement pricetotal = driver.findElement(By.id("price_total"));
		String price=pricetotal.getText();
		String prices=price+" USD";
		System.out.println("��ȡҳ����ܼ�Ϊ:"+prices);
		
		//ѡ��֧����ʽ
		driver.findElement(By.xpath("//*[@id='paymentlistPayPal']")).click();
				
		WebElement upfrom = driver.findElement(By.id("js_upFormBtn"));
		upfrom.click();
		Thread.sleep(3000);
		
		WebElement pricetotal1=
			driver.findElement(By.xpath("//*[@id='transactionCart']/span[2]/format-currency/span"));
		String price1=pricetotal1.getText();
		System.out.println("��ȡPPҳ����ܼ�Ϊ:"+price1);
		
		if(prices.equals(price1)){
			System.out.println("�۸����");
		}else{
			System.out.println("�۸����");
		}
	}
		

	@AfterClass
	public void qiutcase() {
		driver.quit();
		System.out.println("���гɹ�");
	}
}
