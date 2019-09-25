package study.java.code;

public class kakaotest02 {
	public static void main(String[] args) {
		String answer = "";
		int countOfOp = 0;
		int countOfCl = 0;

		String p = "()))((()";
		String[] userInputArray;
		userInputArray = p.split("");
		String q = "";

		for (int i = 0; i < userInputArray.length; i++) {

			if (userInputArray[i].equals("(")) {
				countOfOp++;
			} else {
				countOfCl++;
			}			
			if(countOfCl > countOfOp) {
				userInputArray[i] = "(";
			}
		    if(countOfOp==countOfCl) {
			answer += userInputArray[i];	
			}
			if (userInputArray.length == 2) {
				if (userInputArray[0].equals(")")) {
					userInputArray[0] = "(";
					userInputArray[1] = ")";
					answer = userInputArray[0] +userInputArray[1];
				}
			}
		}
		System.out.println(userInputArray.length);
		System.out.println(answer);
	}
}