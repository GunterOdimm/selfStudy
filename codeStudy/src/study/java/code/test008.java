package study.java.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test008 {
	static String[] test1 = new String[10];
	static String[] test3 = new String[10];
	static String[][] test2 = new String[2][10];

	public static void main(String[] args) {
		try {
			// 파일 객체 생성
			File file1 = new File("D:/workspace-java/imagePuzzle01/Name.txt");
			File file2 = new File("D:/workspace-java/imagePuzzle01/Time.txt");
			// 입력 스트림 생성
			FileReader filereader1 = new FileReader(file1);
			FileReader filereader2 = new FileReader(file2);
			// 입력 버퍼 생성
			BufferedReader bufReader1 = new BufferedReader(filereader1);
			BufferedReader bufReader2 = new BufferedReader(filereader2);
			String line = "";
			String time = "";

			for (int i = 0; i < 11; i++) {
				while ((line = bufReader1.readLine()) != null && (time = bufReader2.readLine()) != null) {
					test1[i] = line;
					test3[i] = time;
	//				test2[1][i] = test1[i];
					test2[2][i] = test3[i];
					System.out.println(test2[1][i]);
				}
			}
			filereader1.close();
			filereader2.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
