package com.gs.ilp.filehandling;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class File1 {
	public static void main(String[] args) throws IOException {

		FileInputStream fileInputStream2 = new FileInputStream("/Users/mohitmalhotra/JDFiles/test1/thinker.jpg");

		BufferedImage img = ImageIO.read(new File("/Users/mohitmalhotra/JDFiles/test1/thinker.jpg"));

		// get width and height of the image
		int width = img.getWidth();
		int height = img.getHeight();

		// convert to sepia
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int p = img.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int R = (p >> 16) & 0xff;
				int G = (p >> 8) & 0xff;
				int B = p & 0xff;

				// calculate newRed, newGreen, newBlue
				int newRed = (int) (0.393 * R + 0.769 * G + 0.189 * B);
				int newGreen = (int) (0.349 * R + 0.686 * G + 0.168 * B);
				int newBlue = (int) (0.272 * R + 0.534 * G + 0.131 * B);

				// check condition
				if (newRed > 255)
					R = 255;
				else
					R = newRed;

				if (newGreen > 255)
					G = 255;
				else
					G = newGreen;

				if (newBlue > 255)
					B = 255;
				else
					B = newBlue;

				// set new RGB value
				p = (a << 24) | (R << 16) | (G << 8) | B;

				img.setRGB(x, y, p);
			}

			ImageIO.write(img, "jpg", new File("/Users/mohitmalhotra/JDFiles/test1/thinker_sepia.jpg"));
		}
	}

	static void m1() throws IOException {
		File file = new File(
				"/Users/mohitmalhotra/Core_java_JLG3/CoreJava_JLG3/src/com/gs/ilp/filehandling/File1.java");
		System.out.println(file.getAbsolutePath());
		// file.mkdirs();
		// file.renameTo(new File("/Users/mohitmalhotra/JDFiles/test4/test332"));

		// file 1) filereader
		// fileinputstream bufferrinputstream

		FileInputStream fileInputStream = new FileInputStream(file);

		// char cc = (char) fileInputStream.read();
		// System.out.println("first char from stream is " + cc);
		int data = 0;
		String dataToWrite = new String();
		while (data != -1) {
			data = fileInputStream.read();
			if (data % 2 == 0) {
				continue;
			}
			// System.out.print((char) data);
			dataToWrite = dataToWrite.concat(String.valueOf((char) data));
		}

		FileOutputStream fileOutputStream = new FileOutputStream("/Users/mohitmalhotra/JDFiles/test4/hello.java");
		fileOutputStream.write(dataToWrite.getBytes());
		fileOutputStream.close();
		fileInputStream.close();

		fileInputStream = new FileInputStream("/Users/mohitmalhotra/JDFiles/test4/hello.java");
		data = 0;
		while (data != -1) {
			data = fileInputStream.read();

			System.out.print((char) data);
			// dataToWrite = dataToWrite.concat(String.valueOf(data));
		}
	}

}
