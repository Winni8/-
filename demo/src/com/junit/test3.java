package com.junit;

import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class test3 {
	@BeforeClass // �����з�������֮ǰ���С�
	public static void beforeClass() {
		System.out.println("-------------------beforeClass");
	}

	@AfterClass // �����з�������֮������
	public static void afterClass() {
		System.out.println("-------------------afterClass");
	}

	@Before // ÿ�����Է�������֮ǰ����
	public void before() {
		System.out.println("=====before");
	}

	@After // ÿ�����Է�������֮������
	public void after() {
		System.out.println("=====after");
	}

	@Test
	public void testAdd() {
		int z = new count().add(5, 3);
		assertEquals(8, z);
		System.out.println("test Run through");
	}

	@Test()
	public void testdivision() {
		System.out.println("in Test Division");
	}

	@Ignore // ��ʾ��������ǲ������е�
	@Test(expected = java.lang.ArithmeticException.class, timeout = 100) // timeout
																			// ��ʾҪ�󷽷���
																			// 100
																			// ������������ɣ����򱨴�
	public void testDivide() {
		int z = new count().divide(8, 2);
	}
}
