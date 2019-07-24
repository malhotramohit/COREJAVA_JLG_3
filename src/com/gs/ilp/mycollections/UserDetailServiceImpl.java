package com.gs.ilp.mycollections;

public class UserDetailServiceImpl {

	public void manipulateData(SimpleList numberList) {
		numberList.add(34);
		numberList.add(56);
		numberList.add(78);
		numberList.add(-90);
		numberList.add(56);
		numberList.add(1009);

		System.out.println(numberList);

		System.out.println("Calling get() " + numberList.get(4));
	}

}
