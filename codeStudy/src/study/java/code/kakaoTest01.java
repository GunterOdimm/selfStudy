package study.java.code;

public class kakaoTest01 {
	public static void main(String[] args) {
		int answer = 0;

		String s = "aabbaccc";
		String[] userInputArray;

		userInputArray = s.split("");

		for (int i = 0; i < userInputArray.length; i++) {

			int count = 0;
			for (int j = 0; j < userInputArray.length; j++) {
				/*
				 * System.out.println(i); System.out.println(j);
				 * System.out.println(userInputArray[j]);
				 */
				if (userInputArray[i].equals(userInputArray[j])) {
					count++;
					i+=count-1;
				}else {
					break;
				}
				answer += count;
				System.out.println(answer);
			}
		}
		System.out.println(answer);
	}
}
