package study.java.code;

public class forbaby {
	public static void main(String[] args) {
		
		int arr[][] = new int[5][];
		arr[0] = new int[6];
		arr[1] = new int[9];
		arr[2] = new int[4];
		arr[3] = new int[11];
		arr[4] = new int[3];
		
		int count =1;
		int a;
		int b;
		
		for(b=0;;b++) {
			int test = count;
			System.out.println(test);
			for(a = 0;a<arr.length; a++) {
				if(b < arr[a].length) {
					arr[a][b] = count++;
				}
			}
			if(test == count) {
				break;
			}
		}
		for(a = 0; a<arr.length; a++) {
			for(b= 0; b<arr[a].length; b++) {
				System.out.printf("%d(%d,%d) ", arr[a][b],a,b);
			}
			System.out.println();
		}
	}
}