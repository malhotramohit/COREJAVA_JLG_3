package com.gs.ilp.strimgs;

public class Divisor {
	public static void main(String[] args) {
		int num = 6;
		// 1 2 3 6
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			if (num % i == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}

}
