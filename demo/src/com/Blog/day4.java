package com.Blog;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day4 {
	private WebDriver Driver;

	@BeforeClass
	public void startFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		Driver = new FirefoxDriver();
		// 最大化
		// Driver.manage().window().maximize();
	}

	@AfterClass
	public void closeFirefox() {
		Driver.close();
		Driver.quit();
	}

	@Test(priority = 1)
	public void goTo() {
		// 文件路径；
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	/**
	 * @author chenjingjian 输入框定位
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void testInput() throws InterruptedException {
		// 对于文本框的操作，都使用sendkeys来操作
		Driver.findElement(By.xpath("//*[@id='user']")).clear();
		Driver.findElement(By.xpath("//*[@id='user']")).sendKeys("你好");
		Thread.sleep(3000);

	}

	/**
	 * @author chenjingjian 链接定位
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3, enabled = false)
	public void testLink() {
		Driver.findElement(By.xpath("//a[@class='baidu']")).click();
	}

	/**
	 * @author chenjingjian 下拉框定位
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void testOption() throws Exception {
		WebElement element = Driver.findElement(By.cssSelector("select[name='select']"));
		Select select = new Select(element);
		// select.selectByValue("audi");//根据value值选定；
		// select.selectByIndex(1);//根据索引值；
		// select.selectByVisibleText("Audi");//根据能看到的内容；
		System.out.println(select.getFirstSelectedOption().getText());
		List<WebElement> options = select.getOptions();
		int optionsSize = options.size();
		System.out.println("options一共有多少个：" + optionsSize);
		for (int i = 0; i < optionsSize; i++) {
			select.selectByIndex(i);
		}
		select.selectByIndex(2);
		Thread.sleep(3000);

	}

	/**
	 * @author chenjingjian 单选框定位
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void testRadio() throws InterruptedException {
		// name定位,不懂为什么用name定位；
		List<WebElement> elements = Driver.findElements(By.name("identity"));
		WebElement el = elements.get(2);
		el.click();
		boolean isSelect = el.isSelected();
		System.out.println(isSelect);
		System.out.println("是否被选中：" + elements.get(3).isSelected());
		Thread.sleep(3000);
	}

	/**
	 * @author chenjingjian 复选框定位
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void testCheckBox() throws InterruptedException {
		// xpath定位
		List<WebElement> elements = Driver.findElements(By.xpath(".//div[@id='checkbox']/input"));
		elements.get(2).click();
		elements.get(0).click();
		elements.get(3).click();
		Thread.sleep(3000);
		// 有什么作用？
		for (WebElement e : elements) {
			if (!e.isSelected()) {
				e.click();
			}
		}
	}

	/**
	 * @author chenjingjian
	 * @version 2.1
	 * @deprecated 提交
	 *
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void testButton() {
		WebElement element = Driver.findElement(By.xpath(".//div[@id='alert']/input"));
		element.click();
	}

}