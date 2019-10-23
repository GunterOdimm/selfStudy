package study.java.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Car {

	public static void main(String[] args) {

		Custom c = new Custom();

	}

}



class Custom extends JFrame {



	private JTextField field;
	private JLabel label;
	private JPanel panel;
	private JButton button, button2;
	private ArrayList<String> list = new ArrayList<String>();
	private ActionListener ml = new ml();
	String name;

	public Custom() {

		this.setTitle("점수판");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field = new JTextField(5);
		label = new JLabel("이름 시간 등수 출력");

		panel = new JPanel();
		button = new JButton("입력");
		button2 = new JButton("출력");
		field.setText("");

		button.addActionListener(ml);
		button2.addActionListener(ml);

		panel.add(field);
		panel.add(button);
		panel.add(button2);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
	
	class ml implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button) {
				name = String.valueOf(field.getText());
				list.add(name);
			} else if (e.getSource() == button2) {
				for (String c : list)
					label.setText(list.toString());
			}

		}

	}

}