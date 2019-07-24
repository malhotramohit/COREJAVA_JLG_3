package com.gs.ilp.mycollections;


public class SimpleListIterator implements SimpleIterator {

	private Object[] array;
	private int position;

	public SimpleListIterator(Object[] array) {
		position = 0;
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		if (position < array.length) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		return array[position++];

	}

	@Override
	public Object currentElement() {
		if (position < array.length) {
			return array[position];
		}
		return null;
	}

	@Override
	public Object remove() {
		/*
		 * 1) Valid index 2) take a copy of object to return 3) Create a new array of
		 * one size less 4) { 23, 56, 12, 89 ,-90, 56, 13 } remove(3) 5) Copy 0: < index
		 * and copy index+1 : length
		 */
		Object objToReturn = null;
		if (position >= 0 && position < array.length) {
			objToReturn = array[position];
			Object[] newArray = new Object[array.length - 1];
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				if (i != position) {
					newArray[j++] = array[i];
				}
			}
			array = newArray;
		}

		return objToReturn;
	}

	@Override
	public void reset() {
		position = 0;
	}

}
