package com.gs.ilp.mycollections;

public class TestMyCollections {
	public static void main(String[] args) {
		UserDetailServiceImpl detailServiceImpl = new UserDetailServiceImpl();
		SimpleList numberList =  new SimpleArrayList(4);
				//new SimpleLinkedList();
				
		detailServiceImpl.manipulateData(numberList);
		
	}

}
