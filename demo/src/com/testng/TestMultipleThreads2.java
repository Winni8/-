package com.testng;

import org.testng.annotations.Test;

public class TestMultipleThreads2 {
	 @Test(invocationCount = 5, threadPoolSize = 5)//运行次数+线程池数；
	    public void testThreadPools() {

	        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

	    }
}
