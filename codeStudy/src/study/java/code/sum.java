package study.java.code;

public class sum {
	public static void main(String[] args) {
	    int num = 626331;  
		int answer = 0;
	      for(int i = 1; i <=500; i++){
	      if(num % 2 == 0){
	        num =  num /2;

	          System.out.println(num);
	      }else{
	          num = num * 3 + 1;

	          System.out.println(num);
	      }
	      if (num == 1){
	          answer = i;
	          System.out.println(num);
	          break;
	      }
	      if(i == 500){
	          answer = -1;
	        }
	      }
		System.out.println(answer);
	}
}
