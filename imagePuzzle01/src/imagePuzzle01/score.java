package imagePuzzle01;

import java.io.Serializable;

public class score implements Serializable{ // 이 참조는 직렬화 가능하게 만들어준다.
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 직렬화 예시 프로그램
	private String name;
	private long time;

	public score(String name, long time){
		this.name = name;
		this.time = time;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getName(){
		return name;	
	}

	public long getTime(){
		return time;
	}

	@Override
	public String toString() {
		return "score [name=" + name + ", time=" + time + "]\n";
	}

}