package com.testng;

import org.testng.annotations.Test;

public class TestOrder {
	@Test(priority = 1,groups = { "orderBo", "save" })
	public void testMakeOrder() {
		System.out.println("testMakeOrder");
	}

	@Test(priority = 4,groups = { "orderBo", "save" })
	public void testMakeEmptyOrder() {
		System.out.println("testMakeEmptyOrder");
	}

	@Test(priority = 3,groups = "orderBo")
	public void testUpdateOrder() {
		System.out.println("testUpdateOrder");
	}

	@Test(priority = 2,groups = "orderBo")
	public void testFindOrder() {
		System.out.println("testFindOrder");
	}
}
