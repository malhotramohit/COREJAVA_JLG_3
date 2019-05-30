package com.gs.ilp.innerclasses;

import com.gs.ilp.innerclasses.Outer1.Inner1;

public class TestNonStaticInner {
	public static void main(String[] args) {
		Outer1 outer1 = new Outer1();
		Inner1 inner1 = outer1.new Inner1();

		Outer1.Inner1 inner12 = new Outer1().new Inner1();

	}

}
