package com.selenium2;

/**
 * 
 * 
 *  1.������������    2.�����ǰ��	3.���������	4.�����ˢ��	5.������л�����(ʧ��)
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

		dr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);// ҳ��Ԫ��ȫ�����س�����
		dr.navigate().refresh();
	}

	// �л����ڣ�
	public boolean switchToWindow(String windowTitle, WebDriver dr) {
		boolean flag = false;
		try {
			// ��ҳ�������е�windowshandle������set���ϵ���
			String currentHandle = dr.getWindowHandle();
			Set<String> handles = dr.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					dr.switchTo().window(s);
					// �͵�ǰ�Ĵ��ڽ��бȽ������ͬ���л���windowhandle
					// �ж�title�Ƿ��handles��ǰ�Ĵ�����ͬ
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
