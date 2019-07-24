package com.gs.ilp.mycollections;


public class TestSimpleLinkedList {
	public static void main(String[] args) {

		SimpleList simpleList = new SimpleLinkedList();
		simpleList.add(45);
		simpleList.add(67);
		simpleList.add(90);
		simpleList.add(89);

		System.out.println(simpleList);

		System.out.println("before add(2,100)");
		System.out.println(simpleList);
		simpleList.add(2, 100); // addition middle
		System.out.println("after add(2,100)");
		System.out.println(simpleList);

		System.out.println("Calling get(2) " + simpleList.get(2));

	}

}
