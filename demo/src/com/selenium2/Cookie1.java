package com.selenium2;
/**
 * 
 * ͨ����ӡ������Կ�����cookie �����ֵ����ʽ���д�ŵģ�֪���� cookie �Ĵ����ʽ����ô���Ǿ�
���԰���������ʽ���������д�� cookie ��Ϣ��
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
		//ɾ������ cookie
		//driver.manage().deleteAllCookies();
		//��� cookie
		Set<Cookie> coo = driver.manage().getCookies();
		//��ӡ cookie
		System.out.println(coo);
		driver.quit();
		}
}
