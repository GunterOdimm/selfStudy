package study.java.code;

public class forEx {
	public static void main(String[] args) {
		int[] items = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int tmp : items) {
			System.out.println(tmp);
		}
		/*
		 * 위 반복문은 최신 트랜드 반복문인데
		 * 기존의 반복문보다 빠르다 
		 * 단 인덱스가 없는것을 가정했을때 
		 * 더 빠르다는 기준이다
		 */
	}
}
