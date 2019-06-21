package com.gs.ilp.generics;

public class ArrayLS {

	public static void main(String[] args) {

		String s1 = new String("mohit"); // s1-->12090
		String s2 = "mohit"; // s2 -->1230
		String s3 = "mohit";// s3--> 1230
		if (s1.equals(s2)) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}

		Integer[] array = { 323, 34, 63, 83, 5656, 232, 39, 23, 89 };
		String[] arr = { "mohit", "phohom", "pierre", "zzzzzzzz" };
		Double[] arrd = { 43.343, 34.4545, 878.545, 6676.878 };
		//
		// array, 63
		int index = linearSearch(arrd, 878.545);
		if (index > -1) {
			System.out.println("Its present at " + index);
		} else {
			System.out.println("Not present");
		}

		String max = getMax(arr);
		System.out.println("Max is " + max);

	}

	public static <T> int linearSearch(T[] array, T obj) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(obj)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static <T extends Comparable<T>> T getMax(T[] array) {
		T max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max.compareTo(array[i]) <0 ) {
				max = array[i];
			}
		}
		return max;

	}

}
