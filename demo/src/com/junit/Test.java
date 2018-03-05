package com.junit;

import com.junit.count;

public class Test {
	public static void main(String[] args) {
		int z = new count().add(3, 6);
		if (z == 8) {
			System.out.println("pass");
		} else {
			System.out.println("failed");
		}

	}
}
