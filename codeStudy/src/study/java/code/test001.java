package study.java.code;

import java.awt.*;
import java.awt.event.*;

public class test001 {
	/**
	 * 간단한 성적 처리의 폼 작성해봐라 FlowLayout , BorderLayout , GridLayout 을 사용해보자
	 */
	public static void main(String[] args) {
		Frame frame = new Frame("성적 처리");
		frame.setLayout(new BorderLayout());
		frame.setBackground(new Color(215, 252, 231));

		// p1(north)
		Panel panel1 = new Panel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(new Color(150, 200, 200));
		frame.add(panel1, "North");
		// p1 - label
		Label title1 = new Label(" 성  적  처  리 ");
		panel1.add(title1);

		// p2(center)
		Panel panel2 = new Panel();
		panel2.setLayout(new FlowLayout(5));
		frame.add(panel2, "Center");

		// p2- label - 1,2,3,4,5
		Label sub1 = new Label("     성  명  ");
		Label sub2 = new Label("     국  어  ");
		Label sub3 = new Label("     영  어  ");
		Label sub4 = new Label("     수  학  ");
		Label sub5 = new Label("     총  점  ");
		// p2 - textField - 1,2,3,4,5
		TextField tf1 = new TextField("", 10);
		TextField tf2 = new TextField("", 10);
		TextField tf3 = new TextField("", 10);
		TextField tf4 = new TextField("", 10);
		TextField tf5 = new TextField("", 10);
		panel2.add(sub1);
		panel2.add(tf1);
		panel2.add(sub2);
		panel2.add(tf2);
		panel2.add(sub3);
		panel2.add(tf3);
		panel2.add(sub4);
		panel2.add(tf4);
		panel2.add(sub5);
		panel2.add(tf5);

		// p3(south)
		Panel panel3 = new Panel();
		panel3.setLayout(new FlowLayout());
		frame.add(panel3, "South");
		// p3 - button
		Button b1 = new Button("계산하기");
		Button b2 = new Button("초기화");
		panel3.add(b1);
		panel3.add(b2);

		frame.setSize(200, 250); // 크기
		frame.setLocation(100, 200); // 위치
		frame.setVisible(true);

		// 윈도우 종료 이벤트 처리
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		b1.addActionListener(new ButtonEventHandler());
	}

}

// 버튼 이벤트 처리
class ButtonEventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");
	}
}
