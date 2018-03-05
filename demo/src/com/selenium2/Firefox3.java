package com.selenium2;

/**
 * 
 * 
 *  1.浏览器窗口最大化    2.浏览器前进	3.浏览器后退	4.浏览器刷新	5.浏览器切换窗口(失败)
 * 
 */
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox3 {
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.baidu.com");
		dr.navigate().to("https://www.twinkledeals.com/");

		dr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);// 页面元素全部加载出来；
		dr.navigate().refresh();
	}

	// 切换窗口：
	public boolean switchToWindow(String windowTitle, WebDriver dr) {
		boolean flag = false;
		try {
			// 将页面上所有的windowshandle放在入set集合当中
			String currentHandle = dr.getWindowHandle();
			Set<String> handles = dr.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					dr.switchTo().window(s);
					// 和当前的窗口进行比较如果相同就切换到windowhandle
					// 判断title是否和handles当前的窗口相同
					if (dr.getTitle().contains(windowTitle)) {
						flag = true;
						System.out.println("Switch to window: " + windowTitle + " successfully!");
						break;
					} else
						continue;
				}
			}
		} catch (Exception e) {
			System.out.printf("Window: " + windowTitle + " cound not found!", e.fillInStackTrace());
			flag = false;
		}
		return flag;
	}

	/*
	 * dr.navigate().back(); Thread.sleep(2000);
	 * 
	 * dr.navigate().forward();
	 */
}
