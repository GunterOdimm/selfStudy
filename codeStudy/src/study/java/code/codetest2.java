package study.java.code;

public class codetest2 {
	public static void main(String[] args) {
		int V = 6;
		
		int[][] bridge = {{1,2},{2,3},{4,5},{1,6}};
		int townLongF = bridge.length-1;
        int townLongS = bridge[0].length-1;
		int answer = 0;
		if(bridge[townLongF][townLongS] != V) {
			answer++;
		}
		for(int i=0; i<bridge.length-1; i++) {
			if(bridge[i][1] - bridge[i+1][0] !=1 && bridge[i][1] - bridge[i+1][0] != 0) {
				answer++;
			}
		}System.out.println(answer);
	}
}
