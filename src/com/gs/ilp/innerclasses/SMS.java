package com.gs.ilp.innerclasses;

public class SMS {
	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				StudentUpdateDAOImpl daoImpl = StudentUpdateDAOImpl.getInstance();
				daoImpl.getTotalStudentCount();
				daoImpl.saveStudent();
				System.out.println(daoImpl);

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				StudentUpdateDAOImpl daoImpl1 = StudentUpdateDAOImpl.getInstance();
				daoImpl1.getTotalStudentCount();
				daoImpl1.saveStudent();

				System.out.println(daoImpl1);
			}
		}).start();

	}

}
