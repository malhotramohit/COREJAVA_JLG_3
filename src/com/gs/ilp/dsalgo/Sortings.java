package com.gs.ilp.dsalgo;

import java.util.Arrays;
import java.util.Random;

public class Sortings {

	public static void displayArrayDetails(int[] arr, String msg) {
		System.out.println(msg);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] prepareCustomArray() {
		int[] array = { 10, 20, 30, 11, 22, 33, 40, 50 };
		return array;
	}

	public static int[] prepareRandomArray(int size) {
		Random random = new Random();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(25);
		}
		return array;
	}

	public static int[] prepareAscArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		return array;
	}

	public static int[] prepareDescArray(int size) {
		int[] array = new int[size];
		int k = 0;
		for (int i = size - 1; i > 0; i--) {
			array[k] = i;
			k++;
		}
		return array;
	}

	public static void mergeSort(int[] arr, int start, int end) {
		// 1) Divide by 2
		// 2) Divide and reach till smallest problem : array with one ele
		// 3) merge
		// 40 10 50 20 11 31 21 30
		if (end - start > 0) {
			int mid = (end - start) / 2; // 4: 11

			mergeSort(arr, start, mid);
			mergeSort(arr, mid, end);
			merge(arr, start, mid, end);
		}

	}

	public static int[] merge(int[] arr, int start, int mid, int end) {
		// ar1 : 10 20 30 40 50 , i = 5 , size = 5
		// ar2 : 11 21 31 , j = 3 , size = 3
		// narr : 8 , k = 8 , : 10 11 20 21 30 31 40 50
		// res :

		int[] lArray = new int[mid];
		int[] rArray = new int[arr.length - mid];

		for (int i = 0; i < lArray.length; i++) {
			lArray[i] = arr[i];
		}
		int m = 0;
		for (int i = mid; i < arr.length; i++) {
			rArray[m] = arr[i];
			m++;
		}

		int i = 0;
		int j = 0;
		int k = 0;

		int[] resArray = new int[lArray.length + rArray.length];

		while (i < lArray.length && j < rArray.length) {
			if (lArray[i] < rArray[j]) {
				resArray[k] = lArray[i];
				i++;
			} else {
				resArray[k] = rArray[j];
				j++;
			}
			k++;
		}
		while (i < lArray.length) {
			resArray[k] = lArray[i];
			i++;
			k++;
		}
		while (j < rArray.length) {
			resArray[k] = rArray[j];
			j++;
			k++;
		}

		return resArray;
	}

	public static void bubbleSort(int[] arr) {

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
		System.out.println("-----Bubble Sort Start----");
		long startTime = System.currentTimeMillis();

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

		long endTime = System.currentTimeMillis();
		System.out.println("-----Bubble Sort End----");
		long duration = endTime - startTime;
		System.out
				.println("-----Time Taken by Bubble Sort on array of size " + arr.length + " is " + duration + "-----");

	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}

	// Partition :
	// pivot = 23 , pivotIndex=0
	// i = 3
	// j = 7
	// i/p : 17 12 9 23 25 45 90 89
	// sort : 9 12 17 23 25 45 89 90
	// o/p : 12 9 17 23 45 89 25 90

	public static int partition(int[] array, int start, int end) {
		int pivot = array[start];// 23
		int i = start;
		for (int j = 1; j < array.length; j++) {
			if (pivot > array[j]) {
				// increment i
				// swap i and j
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i];
		array[i] = array[start];
		array[start] = temp;
		return i;
	}

	public static void insertionSort(int[] array) {
		// 8 6 7 1 5 9 2 10 11 -1
		// 6 8 7 1 5 9 2 10 11 -1
		// 6 7 8 1 5 9 2 10 11 -1
		// 6 7 1 8 9 2 10 11 -1
		// 6 1 7 8 9 2 10 11 -1
		//
		// 1 6 7 8 5 9 2 10 11 -1
		//
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	public static void insertionSortShohom(int array[]) {
		// 8 6 7 1 5 9 2 10 11 -1
		// 8 8 7 1 5 9 2 10 11 -1
		// 8 8 8 
 		int n = array.length;

		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}

			array[i + 1] = key;
		}
	}

}
