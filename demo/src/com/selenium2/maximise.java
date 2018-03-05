package com.selenium2;

import java.awt.Toolkit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class maximise {
	public maximise(WebDriver driver) {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		driver.close();
		driver.switchTo().window("testwindow");
		js.executeScript("window.moveTo(0,0);");
		/*
		 * 1280��1024�ֱ�Ϊ���ڵĿ�͸ߣ�����������Ĵ���õ� screenDims =
		 * Toolkit.getDefaultToolkit().getScreenSize(); width = (int)
		 * screenDims.getWidth(); height = (int) screenDims.getHeight();
		 */
		js.executeScript("window.resizeTo(1280,1024);");
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	}
}
