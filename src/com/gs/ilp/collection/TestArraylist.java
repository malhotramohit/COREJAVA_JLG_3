package com.gs.ilp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

//comparable
// comparator

class Computer implements Comparable<Computer> {
	private int id;
	private String name;
	private int ramSize;

	public Computer(int id, String name, int ramSize) {
		this.id = id;
		this.name = name;
		this.ramSize = ramSize;
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

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", ramSize=" + ramSize + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ramSize != other.ramSize)
			return false;
		return true;
	}

	@Override
	public int compareTo(Computer o) {

		return this.ramSize - o.ramSize == 0 ? this.id - o.id : this.ramSize - o.ramSize;

		// if (this.ramSize > o.ramSize) {
		// return 78;
		// } else if (this.ramSize == o.ramSize) {
		// if (this.id < o.id) {
		// return 1;
		// } else if (this.id == o.id) {
		// return 0;
		// } else {
		// return -1;
		//
		// }
		// } else {
		// return -1;
		// }

	}

}

class RamSizeComparator implements Comparator<Computer> {

	@Override
	public int compare(Computer o1, Computer o2) {
		return o1.getRamSize() - o2.getRamSize();
	}

}

public class TestArraylist {
	public static void main(String[] args) {
		Computer computer1 = new Computer(1, "tretre", 46);
		Computer computer2 = new Computer(3, "abcb", 2340);
		Computer computer3 = new Computer(2, "etrt", 2340);
		Computer computer4 = new Computer(4, "abcb", 865);

		List<Computer> computers = new ArrayList<>(4);

		computers.add(computer1);
		computers.add(computer2);
		computers.add(computer3);
		computers.add(computer4);

		System.out.println("Normal java 7 ");
		for (int i = 0; i < computers.size(); i++) {
			System.out.println(computers.get(i));
		}
		System.out.println("For each java 7 ");
		for (Computer com : computers) {
			System.out.println(com);
		}
		System.out.println("Iterator  java 7 ");
		Iterator<Computer> iterator = computers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("For each 8 ");
		computers.forEach(com -> System.out.println(com));

		Computer computer44 = new Computer(4, "pc4", 43533);
		System.out.println("after removal");
		computers.remove(computer44);
		computers.forEach(com -> System.out.println(com));

		// comparable
		Collections.sort(computers, new RamSizeComparator());
		System.out.println("after sorting");
		computers.forEach(com -> System.out.println(com));

		Collections.sort(computers, new Comparator<Computer>() {

			@Override
			public int compare(Computer o1, Computer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("after sorting on name");

		computers.forEach(com -> System.out.println(com));
		
		
		//computers.sort(Comparator.comparing(Computer::getId));
		Collections.sort(computers,Comparator.comparing(Computer::getName).reversed().thenComparing(Computer::getRamSize));
		System.out.println("after sorting on name reverse 8");

		computers.forEach(com -> System.out.println(com));

	}
}
