package com.gs.ilp.innerclasses;

interface Walkable {
	void walk(int steps);
}

class Human implements Walkable {

	@Override
	public void walk(int steps) {
		System.out.println("I can walk " + steps);
	}

}

public class Lecture {

	public static void main(String[] args) {

		Pen pen1 = new Pen();
		Pen pen2 = new Pen() {
		};
		System.out.println(pen1);
		System.out.println(pen2);

		Pen montex = new Pen() {
			public void write() {
				System.out.println("I am montex 2 without name");
			}

		};

		montex.write();

		Pen addGel = new Pen() {
			public void write() {
				System.out.println("I am addgel 2 without name");
			}

			public void price() {
				System.out.println("I am never called");
			}

		};

		addGel.write();

		Pen catgel = new Pen() {
			public void write() {
				System.out.println("I am addgel 2 without name");
			}

			public void price() {
				System.out.println("I am never called");
			}

		};

		// Pen pen1 = new Pen();

		Pen pen = new Montex();

		takeNotes(new Pen() {
			public void write() {
				System.out.println("I am special pen whose instance is passed as method args");
			}

			public void price() {

			}
		});

		// ***********************************
		Walkable human = new Human();
		checkHumanWalking((s) -> {
			System.out.println("Human lambda " + s);
		});

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am from thread");
			}
		});

		t1.start();

		// using lambda expression
		Thread t2 = new Thread(() -> {
			System.out.println("I am thread 2");
		});

		t2.start();

		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main is waiting");

	}

	public static void checkHumanWalking(Walkable ref) {
		ref.walk(23);

	}

	public static void takeNotes(Pen pen) {
		pen.write();
	}

}
