package com.gs.ilp.strimgs;

public class StringTest {

	public static void main(String[] args) {

		// way 1 char[] = {m,o,h,i,t} // 0 1 2 3 4
		String fname = "mohit";// 1020
		String fname2 = "mohit";// 1020
		String lname = "malhotra";
		// concat
		System.out.println(fname + " " + lname);

		// way 2
		String fname1 = new String("mohit");
		System.out.println(fname1);

		if (fname1 == fname) {
			System.out.println("They are same");
		} else {
			System.out.println("They are not same");
		}

		// way1 for both
		if (fname == fname2) {
			System.out.println("They are same");
		} else {
			System.out.println("They are not same");
		}

		// way 1 char[] = {m,o,h,i,t} // 0 1 2 3 4
		// charAt(3)
		char c = fname.charAt(3);
		System.out.println(c);
		// homework :
		// f1 = "mohit" and f2 ="mohit" checkEquals(f1,f2)
		// len
		int size = fname.length();
		System.out.println("len is " + size);

		// indexOf('h')
		fname = "mohitmalhotra";
		int index = fname.indexOf("ma", 3);
		System.out.println("Index of ma is " + index);

		// replace('M','R')// faname1 = 1020
		fname = fname.replace('m', 'R');// fnam1 =1020 // 1290
		System.out.println("after replace is " + fname);
		// substring
		fname = fname.substring(2, 5);
		System.out.println("Ans after sub id " + fname);

		//
		String username = "   mmalhot  tra   ";
		username = username.trim();
		System.out.println("hello" + username + "bye");

		//
		fname1 = new String("  mohit  ");// 0 1 2 3 4 5 6 7 8 
										 //	s s r o h i t s s
		fname2 = new String("mohit");

		if (fname1.equals(fname2)) {
			System.out.println("They are same");
		}

		// startsWith and endsWith
		if (fname1.startsWith("mo")) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

		fname1 = fname1.replace('m', 'r').substring(1, 5).trim();
		System.out.println("ans is " + fname1);
	}
}
