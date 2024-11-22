package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
	public static void main(String[] args) {
		try {
			String filename = "beemoviescript.exe";
			byte[] inputBytes = { 0 };
			long startTime, endTime;
			
			inputBytes = Files.readAllBytes(Paths.get(filename));
			startTime = System.currentTimeMillis();
			String outputString = "";
			for (byte b: inputBytes) {
				outputString += (char) b;
			}
			endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			System.out.println("bad.");
		}
	}
}
