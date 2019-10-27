package imagePuzzle01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

class scoreBord extends JFrame {
	private long secDiffTime;
	private JTextField field;
	private JLabel label;
	private JPanel panel;
	private JButton button, button2;
	private ArrayList<String> list = new ArrayList<String>();
	private ActionListener ml = new ml();
	String name;
	JViewport vp; 
	score sc = new score(name, secDiffTime);

	private JTextArea jta;

	char[] nameList = new char[10];
	scoreArray scoreList = new scoreArray();

	public long getSecDiffTime() {
		return secDiffTime;
	}

	public void setSecDiffTime(long secDiffTime2) {
		this.secDiffTime = secDiffTime2;
	}

	public scoreBord() throws IOException, ClassNotFoundException {
		vp=new JViewport();
		this.setTitle("점수판");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field = new JTextField(5);
		label = new JLabel("이름과 시간이며 1등부터 출력됩니다");

		panel = new JPanel();
		button = new JButton("입력");
		button2 = new JButton("출력");
		jta = new JTextArea(40, 20);
		jta.setLineWrap(true); // 자동줄바꿈
		field.setText("");

		button.addActionListener(ml);
		button2.addActionListener(ml);

		panel.add(field);
		panel.add(button);
		panel.add(button2);
		panel.add(label);
		panel.add(jta);
		
		this.add(panel);
		this.setVisible(true);

		try {
			// 역직렬화 코드

			FileInputStream fsIn = new FileInputStream("ScoreBord.txt");
			ObjectInputStream osIn = new ObjectInputStream(fsIn);
			// osOut.writeObject(array);
			// ((ObjectOutput) osIn).writeObject(array);
			// 기존에 있는 코드를 복사로 가지고오는법
			scoreList = (scoreArray) osIn.readObject();
			// 오브젝트로 불러와서 형식이 오브잭트다. 그러니 형식으로 맞춰주자 캐스팅
			osIn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	class ml implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button) {
				name = String.valueOf(field.getText());
				list.add(name);

				sc.setName(name);
				sc.setTime(secDiffTime);
				System.out.println(sc.getName() + "\t" + sc.getTime());

				ArrayList<score> list = scoreList.getList();
				list.add(sc);

				Collections.sort(list, new Comparator<score>() {
					@Override
					public int compare(score o1, score o2) {
						return ((Long) o1.getTime()).compareTo(o2.getTime());
					}
				});
				scoreList.setList(list);

				System.out.println(scoreList.toString());

				FileOutputStream fsOut = null;

				try {
					fsOut = new FileOutputStream("ScoreBord.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 예외처리 해주자 (던지는게 편함)
				// 파일경로 안적고 이름만 선택하면 자바 경로안에 있는 파일을 선택해 준다.

				ObjectOutputStream osOut = null;
				try {
					osOut = new ObjectOutputStream(fsOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					osOut.writeObject(scoreList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 경고뜰텐데 이러고 닫아주지를 않아서 그렇다. 메모리 누수
				// 여기까지 하면 에러 직렬화 하지 못하는 클래스가 된다. 위로 가자
				try {
					osOut.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (e.getSource() == button2) {
				jta.setText(scoreList.toString());
				
			}

		}

	}

}
