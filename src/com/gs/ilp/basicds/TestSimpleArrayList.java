package com.gs.ilp.basicds;

import java.util.Arrays;

interface SimpleIterator<T> {
	public boolean hasNext();

	public T next();

	public T currentElement();

	public T remove();

	public void reset();
}

class SimpleListIterator<T> implements SimpleIterator<T> {

	private T[] array;
	private int position;

	public SimpleListIterator(T[] array) {
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
	public T next() {
		return array[position++];

	}

	@Override
	public T currentElement() {
		if (position < array.length) {
			return array[position];
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() {
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
			array = (T[]) newArray;
		}

		return (T) objToReturn;
	}

	@Override
	public void reset() {
		position = 0;
	}

}

interface SimpleList<T> {

	/**
	 * Get will return object present at the given index else will return null
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index);

	void clear();

	/**
	 * Set will be used to replace or update the value at the given index else do
	 * nothing
	 * 
	 * @param index
	 * @param element
	 */
	public void set(int index, T element);

	/**
	 * Add will be used to add the value at the given index and shift the rest of
	 * the values
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, T element);

	public void add(T element);

	public T remove(int index);

	public T remove(T element);

	public int contains(T element);

	public int size();

	public SimpleIterator<?> iterator();

}

class SimpleArrayList<T> implements SimpleList<T> {

	private T[] array;

	public SimpleArrayList(T[] recArray) {
		if (null != recArray) {
			array = (T[]) new Object[recArray.length];
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
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index >= 0 && index < array.length) {
			return (T) array[index];
		}
		return null;
	}

	@Override
	public void set(int index, T element) {
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
	public void add(int index, T element) {
		/*
		 * 0) Valid index 1) Resize : increase by one : new array 2) Copy old values to
		 * new array Create a vacancy by shifting to right after the index { 23, 56, 12,
		 * -90, 56, 13 }; add(3,89) {null,null,null,null,null,null} { 23, 56, 12, 89
		 * ,-90, 56, 13 };
		 */
		if (index >= 0 && index <= array.length) {
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

			array = (T[]) newArray;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	@Override
	public void add(T element) {
		add(array.length, element);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
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
			array = (T[]) newArray;
		}

		return (T) objToReturn;
	}

	@Override
	public T remove(Object element) {
		@SuppressWarnings("unchecked")
		int index = contains((T) element);
		return remove(index);
	}

	@Override
	public int contains(T element) {
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
		array = (T[]) new Object[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public SimpleIterator iterator() {
		return new SimpleListIterator(array);
	}

}

/**
 * This class will test the SimpleArrayList class
 * 
 * @author mohitmalhotra
 *
 */
public class TestSimpleArrayList {

	public static void main(String[] args) {
		Integer[] integers = { 23, 56, 12, -90, 56, 13 }; // 6

		Double[] doubles = { 23.9, 56.34, 12.55, -90.67, 56.56, 13.0 }; // 6

		SimpleList<Double> simpleList1 = new SimpleArrayList<Double>(doubles);

		System.out.println("Calling get method at index 4 " + simpleList1.get(4));
		System.out.println("Calling get method at index 90 " + simpleList1.get(90));

		System.out.println("Before set() " + simpleList1);
		System.out.println("Calling set(4,100)");
		simpleList1.set(4, 100.9);
		System.out.println("After set() " + simpleList1);

		System.out.println("Before add(3,89) " + simpleList1);
		System.out.println("Calling add(3,89)");
		simpleList1.add(3, 89.89);
		System.out.println("After add(3,89) " + simpleList1);

		System.out.println("Before add(900) " + simpleList1);
		System.out.println("Calling add(900)");
		simpleList1.add(900.67);
		System.out.println("After add(900) " + simpleList1);

		System.out.println("Before remove(3) " + simpleList1);
		System.out.println("Calling  remove(3)");
		Object element = simpleList1.remove(3);
		System.out.println("After  remove(3)  element is " + element + " List is " + simpleList1);

		System.out.println("Before remove(-90) " + simpleList1);
		System.out.println("Calling  remove(-90)");
		Object element1 = simpleList1.remove(new Double(-90.67));
		System.out.println("After  remove(-90)  element is " + element1 + " List is " + simpleList1);

		System.out.println("size of simple list is " + simpleList1.size());

		for (int i = 0; i < simpleList1.size(); i++) {
			if (simpleList1.get(i) % 2 == 1) {
				System.out.println("num is odd " + simpleList1.get(i));
			}
		}

		System.out.println("Iterating through iterator");

		SimpleIterator<Integer> simpleIterator1 = (SimpleIterator<Integer>) simpleList1.iterator();
		while (simpleIterator1.hasNext()) {
			System.out.println(simpleIterator1.next());
		}

		// SimpleIterator simpleIterator12= simpleList1.listIterator(3); // 3 2 1 0
		// while(simpleIterator1.hasPrevious()) {
		// System.out.println(simpleIterator1.previous());
		// }

		simpleList1.clear();
		System.out.println(simpleList1);
		System.out.println("size of simple list after clear is " + simpleList1.size());

	}

}
