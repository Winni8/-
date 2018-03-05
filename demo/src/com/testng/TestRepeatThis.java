package com.testng;

import org.testng.annotations.Test;

public class TestRepeatThis {
	@Test(invocationCount = 5)
    public void repeatThis() {
        System.out.println("repeatThis " );
    }
}
