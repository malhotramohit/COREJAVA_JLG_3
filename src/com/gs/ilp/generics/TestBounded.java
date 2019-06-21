package com.gs.ilp.generics;

interface Gift {

	public abstract double getWeight();

}

interface MyComaparable {
	public int myCompareTo();
}

class Wallet implements Gift, MyComaparable {

	@Override
	public double getWeight() {
		return 34.43;
	}

	@Override
	public int myCompareTo() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Phone implements Gift {

	@Override
	public double getWeight() {
		return 3324.43;
	}
}

class Belt {

}

class MyParcel<T extends MyComaparable, Gift> {

	T obj;

	public MyParcel(T obj) {
		super();
		this.obj = obj;
	}

	public void checkWeightBeforShipping(T obj) {
		if (obj.myCompareTo() > 100) {
			System.out.println("shipping allowed");
		}
	}

}

public class TestBounded {

	public static void main(String[] args) {
		Gift gift = new Wallet();
		Gift gift2 = new Phone();
		Belt belt = new Belt();
		//MyParcel<Gift> myParcel = new MyParcel(gift);
		// MyParcel<Gift> myParcel1 = new MyParcel(belt);

	}

}
