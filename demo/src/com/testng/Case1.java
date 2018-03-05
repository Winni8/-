package com.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Case1 {

	@DataProvider
	public Object[][] testData1() {
		return new Object[][] { { 1, 2, 3 }, { 1, 3, 4 }, { 1, 3, 4 }, { -1, 3, 2 } };
	}

	@DataProvider
	public Object[][] testData2() {
		return new Object[][] { { 5, 2, 3 }, { 1, 2, 4 }, { 1, -3, 4 }, { 6, 3, 2 } };
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}

	@BeforeClass
	public void beforeClass() {
		int i=1;
		System.out.println("This is Before Class	"+i);
	}

	@Test(groups = { "add" }, dataProvider = "testData1")
	public void addTest(int a, int b, int c) {
		int i=3;
		System.out.println("This is test add method.  " + a + " + " + b + " = " + c+"   3 ");
		Assert.assertEquals(add(a, b), c);
	}

	@Test(groups = { "minus" }, dataProvider = "testData2")
	public void minusTest(int a, int b, int c) {
		int i=5;
		System.out.println("This is test minus method.  " + a + " - " + b + " = " + c+"   5");
		Assert.assertEquals(minus(a, b), c);
	}

	@BeforeMethod
	public void beforeMethod() {
		int i=2;
		System.out.println("This is Before Method  	"+i);
	}

	@AfterMethod
	public void afterMethod() {
		int i=4;
		System.out.println("This is After Method	"+i);
	}

	@AfterClass
	public void afterClass() {
		int i=6;
		System.out.println("This is After Class	  "+i);
	}
}