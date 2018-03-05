package com.selenium2;
/**
 * 
 * 通过打印结果可以看出，cookie 是以字典的形式进行存放的，知道了 cookie 的存放形式，那么我们就
可以按照这种形式向浏览器中写入 cookie 信息。
 */
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookie1 {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.youdao.com");
		Cookie c1 = new Cookie("name", "key-aaaaaaa");
		Cookie c2 = new Cookie("value", "value-bbbbbb");
		
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		//删除所有 cookie
		//driver.manage().deleteAllCookies();
		//获得 cookie
		Set<Cookie> coo = driver.manage().getCookies();
		//打印 cookie
		System.out.println(coo);
		driver.quit();
		}
}
