package com.gs.ilp.dsalgo;


import java.util.Arrays;

//mohit once u said that selection of pivot is very important..how can it help in unsorted array
// merge sort : Inplace :no extra array : outplace : extra array : stable
// best case worst avg : O(nlogn) : its only used for large arrays

// medium
// unsorted array : quick sort : inplace : unstable relative order of will change (nlogn)

// sorted : insertion sort : O(n)

// 

// Best case qs : Comple : unsorted array : O(n*logn) : stack lots :logn
// Worst case qs : almost sorted array : O(n2) : stack slot :O(n)
// bubble , insertion: O(n) almost sorted array  , compl sorted
//  bubble , insertion: O(n2) unsorted array
// avergage : best : O(nlogn)
public class TestQu {

	public static void main(String[] args) {
		int[] array = { 15,11,4,2,5,11,8,3,11,8,4,0,12,2,4,6,89,12};
		// 1a , , , , 1b, , , ,1c
		// 1b, , , 1a , 
			//{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
			//{ 23, 10, 2, 34, 12, 45, 56 };
		// int i = partition(array, 0, array.length - 1);
		// System.out.println("pivot is " + i);
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));

	}

	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}

	/**
	 * 
	 * arr = {23,10,2,34,12,45,56}
	 * 
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public static int partition(int[] array, int start, int end) {
		int pivot = array[start];
		int i = start;
		for (int j = start + 1; j < array.length; j++) {
			if (pivot > array[j]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[start];
		array[start] = array[i];
		array[i] = temp;
		return i;

	}
}
