package com.gs.ilp.innerclasses;

public class TestMethodLocalInner {

	int t = 34;

	public static void main(String[] args) {

	}

	void m1() {

		System.out.println("t is " + t);


		class inner {
			int i = 23;
			int j = t;

			void m2() {
				System.out.println("t is " + t);

			}
		}

		inner in = new inner();

		System.out.println(in.i);

	}

}
