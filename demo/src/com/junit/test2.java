package com.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class test2 {
	@Test
	public void testAdd(){
		int z= new count().add(3, 5);
		assertEquals(z, 10);
		//int a=8/0;
		System.out.println("ok");
	}
	
}
