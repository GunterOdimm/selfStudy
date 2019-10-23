package study.java.code;

public class codeTest {
	public static void main(String[] args) {

		int[] answer = { 0, 0 };
		int[] numbers = { 100, 101, 102, 103, 104 };
		int[] start = { 1, 2 };
		int[] finish = { 2, 4 };
		int ArLenF = start.length;
		int ArLenS = finish.length;

		for (int i = 0; i < numbers.length; i++) {
			int testF = numbers[i] % 100;
			int testS = numbers[i] % 10;
			for (int j = 0; j < start.length; j++) {
				if (testF >= start[j] && testF <= finish[j]) {
					answer[j] += numbers[i];
					
				}
				else if (testS >= start[j] && testS <= finish[j]) {
					answer[j] += numbers[i];
				}
			}
		}
		
		System.out.println("첫번째 값은: "+answer[0]);
		System.out.println("두번째 값은: "+answer[1]);
	}
}
