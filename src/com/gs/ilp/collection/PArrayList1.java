package com.gs.ilp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * Hashtable:
 * 
 * ArrayList : dyanmic array
 * Linked List 
 * Stack
 * Queue
 * 
 * 
 * set :
 *  : HashSet
 *  : Tree Set
 *  : LinkedHashSet
 *  
 * Map : 
 * 	 : HashMap
 * 	 : TreeMap
 *   : LinkedHashMap
 *   
 *   
 *   Concurrency api (Thread safe)
 *   1) Concurent hash map 
 *   2) Synchronized collections :
 *   3) Interview wale hashmap
 *   4) CopyOnWriteArraylist
 * 
 * 
 * */

class Bag implements Comparable<Bag> {
	private int id;
	private String name;
	private String color;
	private double price;

	public Bag(int id, String name, String color, double price) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}

	public Bag(int id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bag [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bag other = (Bag) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public int compareTo(Bag o) {
		return Integer.valueOf(this.id).compareTo(o.getId());
	}

}

class PriceComparator implements Comparator<Bag> {

	@Override
	public int compare(Bag o1, Bag o2) {
		return Double.valueOf(o1.getPrice()).compareTo(o2.getPrice());
	}

}

class ColorComapartor implements Comparator<Bag> {

	@Override
	public int compare(Bag o1, Bag o2) {
		// TODO Auto-generated method stub
		return o1.getColor().compareTo(o2.getColor());
	}

}

public class PArrayList1 {

	public static void main(String[] args) {

		Bag bag1 = new Bag(12, "bag1", "red", 455.35345);
		Bag bag2 = new Bag(122, "bag23", "green", 323.35345);
		Bag bag3 = new Bag(9, "pff3", "blue", 22323.35345);
		Bag bag4 = new Bag(19, "somebag1", "black", 5656.35345);
		Bag bag5 = new Bag(8, "blackbag", "white", 4454545.35345);

		List<Bag> bags = new ArrayList<Bag>();

		bags.add(bag1);
		bags.add(bag2);
		bags.add(bag3);
		bags.add(bag4);
		bags.add(bag5);

		// java 8 for each
		displayArrayListJava8(bags);

		// remove by index
		bags.remove(3);
		System.out.println("after remove by index");
		displayArrayListJava8(bags);

		// data base read values
		// 8, "blackbag", "white", 4454545.35345
		Bag bagFromDB = new Bag(8, "blackbag", "white", 4454545.35345);
		// remove by obj
		System.out.println("after remove by obj");
		// ?? equals ?

		bags.remove(bagFromDB);
		displayArrayListJava8(bags);

		// java 7
		// interview
		// comparable and comparator

		// 1) Bag type : you have not singned a contract with Comparable
		bags.add(new Bag(23, "sfsfs", "reddd", 242.43434));
		bags.add(new Bag(23, "fdfd", "hehe", 24223.43434));
		bags.add(new Bag(2, "dfdf", "baba", 12.43434));

		Collections.sort(bags);
		System.out.println("after sorting on id");
		displayArrayListJava8(bags);

		// java 7 comparator
		Collections.sort(bags, new PriceComparator());
		System.out.println("after sorting on price");
		displayArrayListJava8(bags);

		Collections.sort(bags, new ColorComapartor());
		System.out.println("after sorting on color");
		displayArrayListJava8(bags);

		Collections.sort(bags, new Comparator<Bag>() {

			@Override
			public int compare(Bag o1, Bag o2) {

				return o1.getName().compareTo(o2.getName());
			}

		});

		// java 8
		Collections.sort(bags, Comparator.comparing(Bag::getId).reversed().thenComparing(Bag::getPrice));
		System.out.println("after sorting on id with java 8");
		displayArrayListJava8(bags);

	}

	private static void displayArrayListJava8(List<Bag> bags) {
		bags.forEach(bag -> {
			System.out.println(bag);
		});
	}

}
