package study.java.code;

import java.util.Arrays;

public class whoIsFinish {
	public static void main(String[] args) {
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = { "josipa", "filipa", "marina", "nikola"};

		String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i =0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){

            }   
        }
		System.out.println(participant[i]);

    }
}