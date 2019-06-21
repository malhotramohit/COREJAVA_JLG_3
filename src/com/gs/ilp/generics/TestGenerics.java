package com.gs.ilp.generics;

class Test<T, U> {

	T obj1;
	U obj2;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public U getObj2() {
		return obj2;
	}

	public void setObj2(U obj2) {
		this.obj2 = obj2;
	}

	public Test(T obj1, U obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void print() {
		System.out.println(obj1);
		System.out.println(obj2);

	}

}

class ChildTest extends Test<String, Integer> {

}

class Customer {

}

public class TestGenerics {
	public static void main(String[] args) {
		Test<String, Integer> test = new Test<String, Integer>("Mohi", 23);

		Test<String, String> test2 = new Test("mohit", "malhotra");

		Customer customer = new Customer();

		Test<String, Customer> test3 = new Test<String, Customer>("mohit", customer);

	}

}
