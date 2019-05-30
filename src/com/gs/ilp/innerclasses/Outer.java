package com.gs.ilp.innerclasses;

public class Outer {

	static int staticOuterVar = 10;
	int normalOuterVar = 20;

	private StaticNested nested = new StaticNested();

	private static class StaticNested {
		// Outer$StaticNested.class

		static int staticInnerVar = 100;
		int normalInnerVar = 1000;
		static int accessOuterStaticVar = staticOuterVar;

	}

}
