package imagePuzzle01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test {
	public static void main(String[] args) {
		test_Frame tf = new test_Frame();
	}
}

class test_Frame extends JFrame implements ActionListener {
	JButton jbt1 = new JButton("쉬움");
	JButton jbt2 = new JButton("보통");
	JButton jbt3 = new JButton("어려움");
	test_Frame0 tf2;
	test_Frame1 tf3;
	test_Frame2 tf4;

	public test_Frame() {
		this.setLayout(new GridLayout(0, 2));
		getContentPane().add(jbt1);
		getContentPane().add(jbt2);
		getContentPane().add(jbt3);

		this.setSize(300, 300);
		this.setVisible(true);

		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jbt1) {
			tf2 = new test_Frame0();
			}
		if (arg0.getSource() == jbt2) {
			tf3 = new test_Frame1();
			}
		if (arg0.getSource() == jbt3) {
			tf4 = new test_Frame2();
			}
		
	}

	public static void main(String[] args) {
		new test_Frame0();
	}
}

