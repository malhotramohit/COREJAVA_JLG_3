package com.gs.ilp.equalsAndHashCode;

import java.util.Arrays;

class Pen {
	private int id;
	private String name;
	private String brand;

	public Pen(int id, String name, String brand) {
		this.id = id;
		this.name = name;
		this.brand = brand;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", name=" + name + ", brand=" + brand + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Pen other = (Pen) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}

public class TestPen {

	public static void main(String[] args) {
		Pen pen1 = new Pen(1, "pen", "Montex");
		Pen pen2 = new Pen(2, "renua", "Cat gel");
		Pen pen3 = new Pen(1, "pen", "Montex");

		Pen[] pens = { pen1, pen2, pen3 };

		Arrays.stream(pens).forEach(System.out::println);

		int count = findOccPen(pens, pen1);
		System.out.println(count);
	}

	public static <T> int findOccPen(T[] pens, T pen) {
		int count = 0;
		for (T p : pens) {
			if (p.equals(pen)) {
				count++;
			}
		}
		return count;
	}

}
