package imagePuzzle01;

import java.io.Serializable;
import java.util.ArrayList;

public class scoreArray implements Serializable {
	@Override
	public String toString() {
		return list.toString();
	}
	private ArrayList<score>list = new ArrayList<score>();

	public ArrayList<score> getList() {
		return list;
	}

	public void setList(ArrayList<score> list) {
		this.list = list;
	}
}
