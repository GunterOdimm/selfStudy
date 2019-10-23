package study.java.code;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[] arr = new int[3];
		arr[0] += array[1]+array[0];
		System.out.println(arr[0]);
	}
}
