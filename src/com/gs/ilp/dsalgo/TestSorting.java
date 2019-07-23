package com.gs.ilp.dsalgo;

import java.util.Arrays;
import java.util.Random;

public class TestSorting {

	public static void main(String[] args) {

		// bubbleAndBinaryTesting();

		int[] array = { 8, 6, 7, 1, 5, 9, 2, 10, 11, -1 };// { 23, 45, 12, 89, 25, 9, 90, 17 }; // 12 9 17 (23) 45 89 25
															// 90
		System.out.println("before sorting");
		System.out.println(Arrays.toString(array));
		// Sortings.partition(array);
		// Sortings.quickSort(array);
		Sortings.insertionSortShohom(array);
		System.out.println("after sorting");
		System.out.println(Arrays.toString(array));

	}

	private static void bubbleAndBinaryTesting() {
		Random random = new Random();
		int[] arr = new int[32]; // 5+1
		for (int i = 31; i > 0; i--) {
			arr[i] = i;
		}
		// System.out.println("---Before sorting---");
		// // printArrayValues(arr);
		// // System.out.println("time: start " + System.currentTimeMillis());
		// long s = System.currentTimeMillis();
		// performBubbleSort(arr);
		// long e = System.currentTimeMillis();
		// // System.out.println("time: end " + System.currentTimeMillis());
		// long r = e - s;
		// System.out.println("Time taken " + r);
		// System.out.println("---After sorting---");
		// // printArrayValues(arr);
		//
		// System.out.println("Testing bsbinarySearch");
		// int[] array = { 23, 56, -90, -23, 89, 12, 9, 90 };// odd
		// performBubbleSort(array);

		// int index = binarySearch(array, 0, array.length - 1, 129);
		performBubbleSort(arr);

		long st = System.currentTimeMillis();
		// int index = linearSearch(arr, 54656565);
		int index = binarySearch(arr, 0, arr.length - 1, 54656565);
		long et = System.currentTimeMillis();
		long res = et - st;
		System.out.println("Time taken by ls " + res);
		// System.out.println(Arrays.toString(arr));
		if (index > -1) {
			System.out.println("ele present at " + index);
		} else {
			System.out.println("Not found");
		}

	}

	private static int linearSearch(int[] arr, int x) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				index = i;
				break;
			}

		}
		return index;

	}

	private static int binarySearch(int[] arr, int start, int end, int x) {
		// DAC
		// smallest
		int mid = (start + end) / 2;

		if (arr[mid] == x) {
			return mid;
		} else if (start == end) {
			return -1;
		} else if (x > arr[mid]) { // RHS
			return binarySearch(arr, mid + 1, end, x);
		} else { // LHS
			return binarySearch(arr, start, mid - 1, x);
		}

	}

	private static void performBubbleSort(int[] arr) {

		// 23, 12, 45, 1, 80, 24
		// 12 23 45 1 80 24 - i =1
		// 12 23 45 1 80 24 - i=2
		// 12 23 1 45 80 24 - i=3
		// 12 23 1 45 80 24 - i=4
		// 12 23 1 45 24 80 - i=5

		// 12 23 1 45 24-- 12 23 1
		// 1 : 4
		// 2 :3
		// 3 : 2
		// 4: 1
		/// n : 1+2+3...n
		// O(n2)
		// Worst case :
		/// 8 7 6 5 4 3 2 1
		// T(n) = comp + swaps
		// Best case
		// 1 2 3 4 5 6 7 8
		// T(n) = comp +swap =0 =
		// Omega(n2)
		// Theta(O(n2))
		for (int j = 0; j < arr.length; j++) {
			boolean isSwapped = false;
			for (int i = 0; i < arr.length - j - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// swap:
					arr[i] = arr[i] + arr[i + 1]; // a=a+b , a= 3, b=4, a=7
					arr[i + 1] = arr[i] - arr[i + 1]; // b = a-b ,7-4, b=3
					arr[i] = arr[i] - arr[i + 1]; // a=a-b
					isSwapped = true;
				}

			}
			if (!isSwapped) {
				break;
			}
		}

	}

	private static void printArrayValues(int[] arr) {
		Arrays.stream(arr).forEach(o -> {
			System.out.println(o);
		});
	}

}
