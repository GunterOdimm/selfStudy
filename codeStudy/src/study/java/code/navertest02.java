package study.java.code;
import java.util.*;
public class navertest02 {
	public static void main(String[] args) {
		String[] record = {"RECEIVE abcd@naver.com","SAVE"};
		String[] answer = new String[10];
		String[] dratf = new String[10];
		int idx = 0;
		String emailADR = "123";
		for (int i = 0; i <= record.length; i++) {
			if (record[i] != "DELET" && record[i] != "SAVE") {
				idx = record[i].indexOf(" ");
				emailADR = record[i].substring(idx + 1);
				dratf[i] = emailADR;
				System.out.println(dratf[i]);
			}if(record[i] == "SAVE") {
				answer[i] = dratf[i];
			}if(record[i] == "DELETE") {
				dratf[]
				  
			}

		}
	}
}