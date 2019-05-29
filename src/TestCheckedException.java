import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestCheckedException {

	public static void main(String[] args) {

		startOpertaion();

	}

	private static void startOpertaion() {
		readFile();
	}

	private static void readFile() {

		try {
			FileInputStream fileInputStream = new FileInputStream("D:/test/file.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
