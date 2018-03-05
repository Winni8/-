package com.com.demo;

import org.testng.annotations.Test;

public class Testddd {
	@Test	
	public void gg(){
		int i=8/4;
		System.out.println(i);
	}
	@Test	
	public void dd(){
		int i=8/0;
		System.out.println(i);
	}
}
