package com.gs.ilp.innerclasses;

public class MySinglyLinkedList {

	private MyNode start;
	private int size = 0;

	MySinglyLinkedList() {
		start = new MyNode();
		start.next = null;
	}

	public void add(int data) {
		MyNode myNode = new MyNode(data);
		MyNode pprev = start;
		MyNode prev = start;
		while (prev != null) {
			pprev = prev;
			prev = prev.next;
		}
		pprev.next = myNode;
		size++;
	}

	public int[] toArray() {
		int[] array = new int[size];
		MyNode prev = start.next;
		int k = 0;
		while (prev != null) {
			array[k] = prev.data;
			prev = prev.next;
			k++;
		}

		return array;

	}

	private static class MyNode {
		int data;
		MyNode next;

		public MyNode() {
			super();
		}

		public MyNode(int data) {
			this.data = data;
		}

	}

}
