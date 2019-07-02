package com.gs.ilp.equalsAndHashCode;

public class TestPatient {

	String fname;
	String lname;

	public TestPatient(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	@Override
	public int hashCode() {
		return fname.hashCode() + lname.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestPatient other = (TestPatient) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}

	public static void main(String[] args) {
		TestPatient patient1 = new TestPatient("Mohit", "Test");
		TestPatient patient2 = new TestPatient("Test", "Mohit");
		if (patient1.equals(patient2)) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		System.out.println(patient1.hashCode());
		System.out.println(patient2.hashCode());

	}

}
