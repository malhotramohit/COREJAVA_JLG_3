package com.gs.ilp.dsalgo;

public class TestSortALgo {
	public static void main(String[] args) {
		int[] arr1 = Sortings.prepareRandomArray(10);
		Sortings.displayArrayDetails(arr1, "Before Merge Sort");
		Sortings.mergeSort(arr1, 0, arr1.length-1);
		Sortings.displayArrayDetails(arr1, "After Merge Sort");

		// int[] arr2 = Sortings.prepareRandomArray(15);
		// Sortings.bubbleSort(arr1);
		// Sortings.displayArrayDetails(arr1, "After bubble arr1");
		// Sortings.bubbleSort(arr2);
		// Sortings.displayArrayDetails(arr2, "After bubble arr2");
		// int[] resArray = Sortings.merge(arr1, arr2);
		// Sortings.displayArrayDetails(resArray, "After merge algo");

	}

}
