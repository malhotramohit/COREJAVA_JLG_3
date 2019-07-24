package com.gs.ilp.mycollections;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

	private Object[] array;

	private int size = 10;

	private int modCount = 0;

	public SimpleArrayList() {
		array = new Object[size];
	}

	public SimpleArrayList(int size) {
		this.size = size;
		array = new Object[size];
	}

	public SimpleArrayList(Object[] recArray) {
		if (null != recArray) {
			array = new Object[recArray.length];
			for (int i = 0; i < recArray.length; i++) {
				array[i] = recArray[i];
			}
		}
	}

	/**
	 * Get will return object present at the given index else will return null
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public Object get(int index) {
		if (index >= 0 && index < array.length) {
			return array[index];
		}
		return null;
	}

	@Override
	public void set(int index, Object element) {
		if (index >= 0 && index < array.length) {
			array[index] = element;
		}
	}

	/**
	 * Add will be used to add the value at the given index and shift the rest of
	 * the values
	 * 
	 * @param index
	 * @param element
	 */
	@Override
	public void add(int index, Object element) {
		/*
		 * 0) Valid index 1) Resize : increase by one : new array 2) Copy old values to
		 * new array Create a vacancy by shifting to right after the index { 23, 56, 12,
		 * -90, 56, 13 }; add(3,89) {null,null,null,null,null,null} { 23, 56, 12, 89
		 * ,-90, 56, 13 };
		 */
		if (index >= 0 && index <= array.length) {
			

			if (modCount <this.size) {
				array[modCount] = element;
			}

			else {
				int size = array.length;
				Object[] newArray = new Object[size + 1];
				for (int i = 0; i < index; i++) {
					newArray[i] = array[i];
				}
				newArray[index] = element;
				int j = index + 1;
				for (int i = index; i < array.length; i++) {
					newArray[j++] = array[i];
				}
				array = newArray;
			}

			modCount++;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	@Override
	public void add(Object element) {
		add(array.length, element);

	}

	@Override
	public Object remove(int index) {
		/*
		 * 1) Valid index 2) take a copy of object to return 3) Create a new array of
		 * one size less 4) { 23, 56, 12, 89 ,-90, 56, 13 } remove(3) 5) Copy 0: < index
		 * and copy index+1 : length
		 */
		Object objToReturn = null;
		if (index >= 0 && index < array.length) {
			objToReturn = array[index];
			Object[] newArray = new Object[array.length - 1];
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				if (i != index) {
					newArray[j++] = array[i];
				}
			}
			array = newArray;
		}

		return objToReturn;
	}

	@Override
	public Object remove(Object element) {
		int index = contains(element);
		return remove(index);
	}

	@Override
	public int contains(Object element) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element || array[i].equals(element)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public void clear() {
		array = new Object[0];
	}

	@Override
	public SimpleIterator iterator() {
		return new SimpleListIterator(array);
	}

}
