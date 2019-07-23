package com.gs.ilp.innerclasses;

/**
 * 
 * Singleton
 * 
 * @author mohitmalhotra
 *
 */
public class StudentUpdateDAOImpl {

	private static volatile StudentUpdateDAOImpl _instance;

	public static StudentUpdateDAOImpl getInstance() {
		if (_instance == null) {
			synchronized (StudentUpdateDAOImpl.class) {
				
					_instance = new StudentUpdateDAOImpl();
				
			}
		}
		return _instance;
	}

	private StudentUpdateDAOImpl() {

	}

	// instance variable

	public void saveStudent() {
		// making save DB
	}

	public int getTotalStudentCount() {
		return 12;
	}

}
