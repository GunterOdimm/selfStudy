package study.java.code;

public class forbaybe {
	public static void main(String[] args) {

		int userInput = 5;
		int userStar = (userInput * 2) - 1; // 입력된 값이 항상 홀수가 되게 하는 함수

		for (int i = 1; i <= userStar; i++) {
			int c = i; // 두번째 for문에서 반복 시킬 횟수
			for (int j = 0; j < c; j++) {

				if (c > userInput) {
					// 사용자가 입력한 값보다 크면
					c = userInput * 2 - i;
					// c값을 이렇게 초기화한다
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

}