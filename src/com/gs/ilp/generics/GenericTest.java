package com.gs.ilp.generics;

class MyNode<V> {

	private V data;

	public MyNode(V data) {
		super();
		this.data = data;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}

}

public class GenericTest {

	public static void main(String[] args) {
		MyNode<Integer> myNode1 = new MyNode<Integer>(23);
		MyNode<String> myNode2 = new MyNode<String>("Mohit");

		MyNode<Double> myNode = new MyNode<Double>(345.3454);
	}

}
