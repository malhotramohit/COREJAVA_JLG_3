package com.gs.ilp.innerclasses;

public class Outer1 {

	int outerVar;
	static int outerStaticVar;
	int someVar = 10;
	// way 1
	Inner1 inner1 = new Inner1();

	class Inner1 {

		int someVar = 120;
		int num = Outer1.this.someVar;

		int inneVar;
		final static int innerStaticVar = 0;

		public void someMethod(int someVar) {
			System.out.println(Outer1.this.someVar);
		}

	}

	public void add() {
		// way2
		Inner1 inner2 = new Inner1();
	}

	public static void notAdding() {
		// way3
		Outer1 outer1 = new Outer1();
		Inner1 inner2 = outer1.new Inner1();
	}

}
