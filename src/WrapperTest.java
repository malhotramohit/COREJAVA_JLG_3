
public class WrapperTest {

	public static void main(String[] args) {

		int i = 13; // primitive
		Integer num = i; //
		Integer num1 = new Integer(34);
		Integer num2 = Integer.valueOf(45);
		Integer num4 = new Integer("8978");

		System.out.println(num);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num4);

		Boolean boolean1 = new Boolean("tRue12");
		System.out.println(boolean1);

		Character character = new Character('a');

		int res = num1.intValue(); //

		Double double1 = 3.14;
		System.out.println(double1.doubleValue());

		String yEO = "5.7sd";

		Double double2 = Double.parseDouble(yEO);
		System.out.println(double2);
		
		

	}

}
