
public class WrapperTest1 {

	public static void main(String[] args) {
		// int : Integer
		// float : Float
		// double : Double
		// boolean : Boolean
		// long : Long
		// char :Char
		// byte :Byte
		// short :Short

		// way 1
		Integer num = 90;
		Integer num1 = 99;
		System.out.println(num.MAX_VALUE);
		// way 2 : passing values in the constructor
		Integer num3 = new Integer("989798");
		System.out.println(num3);

		// way 3: valueOf() static method
		Integer num4 = Integer.valueOf("25");
		System.out.println(num4);

		Character gender = new Character('A');
		Character gender1 = Character.valueOf('A');

		Long mobileNum = new Long("4435435345");
		Long long1 = Long.valueOf(454353455);

		Double double1 = 34545.355;
		Double double2 = new Double(245.35345);
		Double double3 = new Double("455.35435");
		Double double4 = Double.valueOf(4.35435);
		Double double5 = Double.valueOf("24.445");

		Boolean boolean1 = new Boolean(true);

		// 1)CTE 2)RTE 3) true 4) false
		Boolean boolean2 = new Boolean("gjg");
		System.out.println(boolean2);

		String mobile = " 5545435435 ";

		Long mobNum = Long.parseLong(mobile.trim());
		System.out.println(mobile);

		
		//-128==127
		Integer i1 = 128;
		Integer i2 = 128;
		if (i1.intValue()==i2.intValue()) {
			System.out.println("They are same");
		} else {
			System.out.println("They are not same");
		}
		
		
		int ii =89; //primitive 
		Integer var= ii;// wrapper AutoBoxing
		
		int k = var.intValue(); // wrappr to prim : UnBoxing
		
	}

}
