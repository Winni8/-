package com.Blog;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day5 {
	private WebDriver Driver;

	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeFirefox() {
		// Driver.close();
		// Driver.quit();
	}

	@Test(priority = 1)
	public void goTo() {
		// 文件路径；
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	// 模拟点击弹出窗alert的确定。
	@Test(priority = 2)
	public void testAlert() throws InterruptedException {
		WebElement element = Driver.findElement(By.className("alert"));
		// element.click();
		Actions action = new Actions(Driver);
		action.click(element).perform();
		// 获取当前弹出的alert窗
		Alert alert = Driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		/// 模拟点击alert确认按钮
		alert.accept();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testAction() throws InterruptedException {
		WebElement element = Driver.findElement(By.className("over"));
		Actions action = new Actions(Driver);
		// 将鼠标移动到Action的按钮上面
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		// 输出鼠标移动到action按钮上面后显示的文字。
		System.out.println(Driver.findElement(By.id("over")).getText());

	}

	// 上传
	@Test(priority = 4)
	public void testUpload() throws InterruptedException {
		WebElement element = Driver.findElement(By.id("load"));
		element.sendKeys("C:\\Users\\chenjingjian\\Deskto\\TD-ALL-物流限制后台配置功能测试用例");
		Thread.sleep(3000);
	}

	// 运行一段js
	public void testJs() {
		JavascriptExecutor javascript = (JavascriptExecutor) Driver;
		javascript.executeScript("alert('你好！')");

	}

	// 对iframe中元素的操作,注意还没有回到默认的iframe；
	@Test(priority = 5)
	public void testIframe() throws InterruptedException {
		Driver.findElement(By.id("user")).sendKeys("my test");
		// 切换ifame
		WebElement element = Driver.findElement(By.name("aa"));
		Driver.switchTo().frame(element);

		Driver.findElement(By.id("user")).sendKeys("iframe test");
		//*************************************
		//返回默认的iframe；
	    Driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver.findElement(By.id("user")).sendKeys("my end test");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回默认的iframe；
		//Driver.switchTo().defaultContent();
		// 对多个窗口进行切换操作

		WebElement element2 = Driver.findElement(By.className("open"));
		element2.click();
		Set<String> handles = Driver.getWindowHandles();
		System.out.println("总句柄个数："+handles.size());
		
		String handle = Driver.getWindowHandle(); // 得到默认最初窗体句柄	
		System.out.println("默认窗口句柄:"+handle);
		
		handles.remove(handle);
		if(handles.size()>0){
			try{
				Driver.switchTo().window(handles.iterator().next());
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String handle2= Driver.getWindowHandle();
		System.out.println("切换窗口之后的句柄："+handle2);
		
		// 跳到百度，輸入myString
		Driver.findElement(By.id("kw")).sendKeys("myString");
		Thread.sleep(3000);

		// 回到最开始的窗口
		Driver.switchTo().window(handle);
		
		String handle1 = Driver.getWindowHandle();
		System.out.println("返回默认窗口之后的句柄："+handle1);
		//我都没有返回默认iframe，怎么就跑到默认iframe里操作了？？？
		
		if(handle.equals(handle1)){
			System.out.println("说明在同一窗口；");
		}else{
			System.out.println("false");
		}
		
		Driver.findElement(By.id("user")).sendKeys("new test");

	}

	// 获取延时信息，常用于操作ajax请求返回的信息
	@Test(priority = 7)
	public void testWait() {
		WebElement element = Driver.findElement(By.className("wait"));
		element.click();
		// 方法1 用Thread.sleep，设置了10秒，只能10秒后才能获取数据。
		// try {
		// Thread.sleep(6000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		// 方法2 用WebDriverWait，设置了10秒 如果数据5秒就返回的话，5秒就能获取到数据
		boolean wait = new WebDriverWait(Driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.className("red")).isDisplayed();
			}
		});

		print(String.valueOf(wait));
		WebElement elementRed = Driver.findElement(By.className("red"));
		String str = elementRed.getText();
		print(str);

	}

	public void print(String str) {
		System.out.println(str);

	}
}