package study.java.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class test04 {
	public static void main(String[] args) {
		userinput u = new userinput();
	}
}
class userinput extends JFrame {
	String name;
	private JLabel label1, label2, label3;
	static JButton Button1;
	static JButton Button2;
	private JTextPane tf;
	private JPanel panel;
	private JLabel label;
	private ArrayList<String> list = new ArrayList<String>();
	private ActionListener push = new push();
	public userinput() {
		
		this.setTitle("점수판");
		JFrame jframe = new JFrame();
		jframe.setSize(300, 300); // 전체 창 크기
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정
		
		label1 = new JLabel("이름 :");
		Button1 = new JButton("입력");
		Button2 = new JButton("출력");
		panel = new JPanel();

		tf.setText("");
		Button1.addActionListener(push);
		Button2.addActionListener(push);

		panel.add(label1);
		panel.add(tf);
		panel.add(Button1);
		panel.add(Button2);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
		
		/* JPanel jpanel = new JPanel(); */

	}

	class push implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == Button1) {
				name = String.valueOf(tf.getText());
				list.add(name);
			} else if (e.getSource() == Button2) {
				for (String c : list)
					label.setText(list.toString());
			}
		}
	}
}
