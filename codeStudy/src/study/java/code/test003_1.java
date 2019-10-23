package study.java.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test003_1 {
	//버튼 이벤트 처리 
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼 눌림");
		}
	}
}
