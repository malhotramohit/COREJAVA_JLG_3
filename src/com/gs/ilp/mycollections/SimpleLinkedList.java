package com.gs.ilp.mycollections;

public class SimpleLinkedList implements SimpleList {

	class Node {
		private Object data;
		private Node previous;
		private Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	private Node start;

	public SimpleLinkedList() {

	}

	@Override
	public Object get(int index) {
		int counter = 0;
		Node ptr = start;
		for (; counter < index; ptr = ptr.next) {
			counter++;
		}
		return ptr.data;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int index, Object element) {
		// [45,67,90,89]
		// 45 67 100 90 89
		/*
		 * add(2,100)
		 * 
		 */
		int counter = 0;
		Node ptr = start;
		for (; counter < index - 1; ptr = ptr.next) {
			counter++;
		}
		Node newNode = new Node(element);

		ptr.next.previous = newNode; // 100 < - 90
		newNode.next = ptr.next; // 100 ->90
		ptr.next = newNode; // 67 - > 100
		newNode.previous = ptr;// 67 < - 100

	}

	// 45
	@Override
	public void add(Object element) {
		if (start == null) {
			start = new Node(element);
		} else {
			// traverse
			Node ptr = start;
			for (; ptr.next != null; ptr = ptr.next) {

			}
			ptr.next = new Node(element);
			ptr.next.previous = ptr;
		}

	}

	@Override
	public Object remove(int index) {

		return null;
	}

	@Override
	public Object remove(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		String values = "[";
		for (Node ptr = start; ptr != null; ptr = ptr.next) {
			values = values.concat(ptr.data.toString()).concat(",");
		}
		values = values.substring(0, values.length() - 1).concat("]");
		return values;
	}

	@Override
	public int contains(Object element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SimpleIterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
