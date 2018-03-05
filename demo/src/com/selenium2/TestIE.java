package com.selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestIE {
	public static void main(String[] args) {

		WebDriver Driver;
		// ie启动成功,files是启动ie驱动
		System.setProperty("webdriver.ie.driver", 
				"C:\\Users\\chenjingjian\\Desktop\\驱动\\demo\\driver\\IEDriverServer.exe");
		// 代码关闭IE一些配置
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		ieCapabilities.setCapability
				(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
		 Driver = new InternetExplorerDriver(ieCapabilities); 
		// 全屏
		Driver.manage().window().setSize(null);
		// 打开本地网站
		Driver.get("https://www.dezzal.com");
	}
}
