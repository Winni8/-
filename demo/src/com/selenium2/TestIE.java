package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestIE {
	public static void main(String[] args) {

		WebDriver Driver;
		// ie�����ɹ�,files������ie����
		System.setProperty("webdriver.ie.driver", 
				"C:\\Users\\chenjingjian\\Desktop\\����\\demo\\driver\\IEDriverServer.exe");
		// ����ر�IEһЩ����
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		ieCapabilities.setCapability
				(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
		 Driver = new InternetExplorerDriver(ieCapabilities); 
		// ȫ��
		Driver.manage().window().setSize(null);
		// �򿪱�����վ
		Driver.get("https://www.dezzal.com");
	}
}
