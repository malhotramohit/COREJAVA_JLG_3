package com.gs.ilp.basicds;

import com.gs.ilp.mycollections.SimpleArrayList;
import com.gs.ilp.mycollections.SimpleIterator;
import com.gs.ilp.mycollections.SimpleList;








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


		SimpleList simpleList1 = new SimpleArrayList(doubles);

		System.out.println("Calling get method at index 4 " + simpleList1.get(4));
		System.out.println("Calling get method at index 90 " + simpleList1.get(90));

		System.out.println("Before set() " + simpleList1);
		System.out.println("Calling set(4,100)");
		simpleList1.set(4, 100);
		System.out.println("After set() " + simpleList1);

		System.out.println("Before add(3,89) " + simpleList1);
		System.out.println("Calling add(3,89)");
		simpleList1.add(3, 89);
		System.out.println("After add(3,89) " + simpleList1);

		System.out.println("Before add(900) " + simpleList1);
		System.out.println("Calling add(900)");
		simpleList1.add(900);
		System.out.println("After add(900) " + simpleList1);

		System.out.println("Before remove(3) " + simpleList1);
		System.out.println("Calling  remove(3)");
		Object element = simpleList1.remove(3);
		System.out.println("After  remove(3)  element is " + element + " List is " + simpleList1);

		System.out.println("Before remove(-90) " + simpleList1);
		System.out.println("Calling  remove(-90)");
		Object element1 = simpleList1.remove(new Integer(-90));
		System.out.println("After  remove(-90)  element is " + element1 + " List is " + simpleList1);

		System.out.println("size of simple list is " + simpleList1.size());

		for (int i = 0; i < simpleList1.size(); i++) {
			if ((Integer) simpleList1.get(i) % 2 == 1) {
				System.out.println("num is odd " + simpleList1.get(i));
			}
		}
		
		
		System.out.println("Iterating through iterator");
		
		SimpleIterator simpleIterator1= simpleList1.iterator();
		while(simpleIterator1.hasNext()) {
			System.out.println(simpleIterator1.next());
		}
		
		
		
//		SimpleIterator simpleIterator12= simpleList1.listIterator(3); // 3 2 1 0
//		while(simpleIterator1.hasPrevious()) {
//			System.out.println(simpleIterator1.previous());
//		}

		simpleList1.clear();
		System.out.println(simpleList1);
		System.out.println("size of simple list after clear is " + simpleList1.size());
		

	}

}
