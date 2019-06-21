package com.gs.ilp.composition;

import java.util.Arrays;

//pojo bean model
class Author {
	private String name;
	private String email;
	private char gender;

	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String toString() {
		return "Author[name =" + name + ",email= " + email + ",gender =" + gender + "]";
	}

}

class Book {
	private String name;
	private Author[] authors;
	private double price;
	private int qty;

	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
	}

	public Book(String name, Author[] authors, double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", authors=" + Arrays.toString(authors) + ", price=" + price + ", qty=" + qty
				+ "]";
	}

	public String getAuthorNames() {
		// mohit, rohit, neeti
		String names = authors[0].getName().toUpperCase();// mohit, rohit , neeti
		for (int i = 1; i < authors.length; i++) {
			names = names + "," + authors[i].getName().toUpperCase();
		}
		return names;
	}

	// public String toString() {
	// String authorStr = authors[0].toString(); //Author[name =Mohit,email=
	// mma@gmail.cm,gender =M] , Author[name =Mohit,email= mma@gmail.cm,gender =M]
	// for (int i = 1; i < authors.length; i++) {
	// authorStr = authorStr+" , "+authors[i].toString();
	// }
	// return "Book[name = " + name + ", authors = " + authorStr + " , price= " +
	// price + ", qty = " + qty + "]";
	// }

}

public class TestBookApp {
	public static void main(String[] args) {

		Author author0 = new Author("Mohit", "mma@gmail.cm", 'M');
		Author author1 = new Author("Mohit", "mma@ssfgmafdsfdsil.cm", 'M');
		Author author2 = new Author("Neeti", "mma@gfsmail.cm", 'F');

		System.out.println(author0);// implicit

		Author[] authors = { author0, author1, author2 };

		Book book = new Book("Java", authors, 4234.24, 3);
		System.out.println(book);
		System.out.println(book.getAuthorNames());

		// book, "Rohit" --> index= 1, -1
		String authorName = "Neeti";
		int index = checkIfBookIsWrittenByAuthor(book, authorName);
		if (index > -1) {
			System.out.println("Present at " + index);
		} else {
			System.out.println("Not Present");
		}

		boolean isPresent = checkIfBookIsWrittenByAuthorByBool(book, "Mohit");
		if (isPresent) {
			System.out.println("is Present");
		} else {
			System.out.println("Not Present");
		}

		Author[] authors2 = getAllAuthorsContainingSubStr(book.getAuthors(), "hit");
		Arrays.stream(authors2).forEach(System.out::println);
		System.out.println("array without duplicate names ");
		Arrays.stream(removeDuplicateByName(book.getAuthors())).forEach(System.out::println);
	}

	private static int checkIfBookIsWrittenByAuthor(Book book, String authorName) {
		Author[] authors = book.getAuthors();
		int index = -1;
		for (int i = 0; i < authors.length; i++) {
			if (authors[i].getName().equals(authorName)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static boolean checkIfBookIsWrittenByAuthorByBool(Book book, String authorName) {
		Author[] authors = book.getAuthors();
		boolean isPresent = false;
		for (int i = 0; i < authors.length; i++) {
			if (authors[i].getName().equals(authorName)) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}

	public static Author[] getAllAuthorsContainingSubStr(Author[] authors, String subStr) {
		// substr : "hit"
		//
		// Author author0 = new Author("Mohit", "mma@gmail.cm", 'M');
		// Author author1 = new Author("Rohit", "mma@ssfgmail.cm", 'M');
		// Author author2 = new Author("Neeti", "mma@gfsmail.cm", 'F');
		int size = 0;
		Author[] filteredAuthor = new Author[size]; // 0 size
		int index = -1;
		for (int i = 0; i < authors.length; i++) {
			if (authors[i].getName().contains(subStr)) {
				index++; // 1
				size++; // 2
				filteredAuthor = resize(filteredAuthor, size);
				filteredAuthor[index] = authors[i];
			}
		}

		return filteredAuthor;
	}

	private static Author[] resize(Author[] filteredAuthor, int size) {
		Author[] reSizedArray = new Author[size];// [Mohit,null] , [ Mohit ]
		for (int i = 0; i < filteredAuthor.length; i++) {
			reSizedArray[i] = filteredAuthor[i];
		}
		return reSizedArray;
	}

	// duplicate remove based on name
	private static Author[] removeDuplicateByName(Author[] authors) {
		//
		// Author author0 = new Author("Mohit", "mma@gmail.cm", 'M');
		// Author author1 = new Author("Mohit", "mma@ssfgmail.cm", 'M');
		// Author author2 = new Author("Neeti", "mma@gfsmail.cm", 'F');
		// new array without duplicates
		int size = 1;
		Author[] arrayWithoutDupliactes = new Author[size]; // 0 size
		arrayWithoutDupliactes[0] = authors[0];
		int index = 0;
		for (int i = 1; i < authors.length; i++) {
			boolean isPresent = checkIfPresent(arrayWithoutDupliactes, authors[i]);
			if (!isPresent) {
				index++;
				size++;
				arrayWithoutDupliactes = resize(arrayWithoutDupliactes, size);
				arrayWithoutDupliactes[index] = authors[i];
			}
		}

		return arrayWithoutDupliactes;
	}

	private static boolean checkIfPresent(Author[] arrayWithoutDupliactes, Author author) {
		boolean isPresent = false;
		for (int i = 0; i < arrayWithoutDupliactes.length; i++) {
			if (arrayWithoutDupliactes[i].getName().equals(author.getName())) {
				if (arrayWithoutDupliactes[i].getEmail().compareTo(author.getName()) > 1) {
					Author temp = arrayWithoutDupliactes[i];
					arrayWithoutDupliactes[i] = author;
					author = temp;
				}
				isPresent = true;
			}
		}
		return isPresent;
	}

}
