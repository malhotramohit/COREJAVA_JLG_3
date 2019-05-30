package com.gs.ilp.innerclasses;

public class TestMySinglyLL {

	public static void main(String[] args) {
		MySinglyLinkedList list = new MySinglyLinkedList();

		list.add(67);
		list.add(-89);
		list.add(13);
		list.add(76);

		int[] array = list.toArray();

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
