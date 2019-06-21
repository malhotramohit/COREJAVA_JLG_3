
public class GenericArray {

	public static void main(String[] args) {

		Integer[] array = { 1, 2, 3, 4, 5 };
		int index = LS(array, new Integer(3));
		System.out.println(index);

	}

	public static <T> int LS(T[] array, T obj) {
		int index = -1;

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(obj)) {
				index=i;
				break;
			}
		}

		return index;
	}

}
