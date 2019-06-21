package com.gs.ilp.generics;

class Parcel<T> {
	private T obj;

	public Parcel(T obj) {
		super();
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}

class Book extends Object {
	private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}

class Pen extends Object {

}

public class ProblemWithoutGenerics {

	public static void main(String[] args) {
		Book book = new Book();
		Pen pen = new Pen();
		
		Parcel<Book> parcel = new Parcel<Book>(book);
		
		Parcel<Pen> parcel1 = new Parcel<Pen>(pen);

		// if(parcel1.getObj() instanceof Book) {
		//
		// Book book1 = (Book) parcel1.getObj();
		// }
		
		// Book book1 = (Book) parcel1.getObj();

	}

}
