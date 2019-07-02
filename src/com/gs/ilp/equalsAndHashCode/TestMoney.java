package com.gs.ilp.equalsAndHashCode;

//
//class par {
//	int m1(int i) {
//		return 0;
//	}
//}
//
//class child extends par {
//	int m1(float j) {
//		return 0;
//	}
//}
class WrongMoney extends Money {

	private int amt;
	private String code;

	public WrongMoney(int amt, String code) {
		super(amt, code);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amt;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WrongMoney other = (WrongMoney) obj;
		if (amt != other.amt)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	

//	public boolean equals(Object obj1) {
//		if (obj1.getClass()== WrongMoney.class) {
//			WrongMoney obj = (WrongMoney) obj1;
//			if (this.amt == obj.amt && this.code.equals(obj.code)) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		return false;
//	}

}

class Money {
	private int amt;
	private String code;

	public Money(int amt, String code) {
		this.amt = amt;
		this.code = code;
	}

	public String toString() {
		return "Money[amt=" + amt + " , code=" + code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amt;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amt != other.amt)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

//	public boolean equals(Object obj1) {
//		if (obj1.getClass() ==  Money.class) {
//			Money obj = (Money) obj1;
//			if (this.amt == obj.amt && this.code.equals(obj.code)) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		return false;
//	}

}

public class TestMoney {

	public static void main(String[] args) {
		Money mon1 = new Money(23, "USD");
		Money mon2 = new Money(23, "USD");
		Money mon3 = new Money(25, "USD");
		Money[] moneys =  {mon1,mon2,mon3};
		int count = TestPen.findOccPen(moneys, mon1);
		System.out.println(count);

		System.out.println(mon1);
		System.out.println(mon2);
		System.out.println(mon1.hashCode());
		System.out.println(mon2.hashCode());

		WrongMoney money = new WrongMoney(23, "USD");

		if (mon1.equals(money)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}

		System.out.println("Vice vera");

		if (money.equals(mon1)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}

		System.out.println("equals of wrong money");

		if (mon1.equals(money)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}

		System.out.println("Vice vera");

		if (money.equals(mon1)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}
	}

}
