package com.gs.ilp.strimgs;

import java.util.Scanner;

class Rectangle {
	int width;
	int height;

	void display() {
		System.out.println(width + " " + height);
	}
}

class RectangleArea extends Rectangle {

	void read_input() {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
	}

	void display() {
		super.display();
		System.out.print(width * height);
	}
}

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		RectangleArea area = new RectangleArea();
		area.read_input();
		area.display();
	}
}
