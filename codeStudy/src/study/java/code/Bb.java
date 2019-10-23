package study.java.code;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Bb extends JFrame implements ActionListener {

	Panel p1, p2, p3, p4, p5, p6;	
	TextField tf, tf1, tf2, tf3, tf4;	//학생 정보입력 필드
	TextArea ta;						//학생 정보 출력 필드
	Button b1, b2, b3, b4, b5, b6; 		//입력,출력,수정,삭제,검색,종료 버튼
										//Key값 : 학번 , Value : 학생 1명의 성적,총점,평균
	HashMap<Integer, STU> hm;
	public Bb() {
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();

		tf = new TextField(15);
		tf1 = new TextField(5);
		tf2 = new TextField(5);
		tf3 = new TextField(5);
		tf4 = new TextField(5);

		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

		ta = new TextArea(20, 55);
		b1 = new Button("Input");
		b2 = new Button("Output");
		b3 = new Button("Modify");
		b4 = new Button("Delete");
		b5 = new Button("Search");
		b6 = new Button("Exit");
		setBounds(300, 200, 500, 800);

		p1.add(tf);
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(tf4);

		p2.add(ta);

		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);

		add("North", p1);
		add("Center", p2);
		add("South", p3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);

		hm = new HashMap<Integer, STU>();

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();

		// 입력
		if (str.equals("Input")) {
			hm.put(Integer.parseInt(tf.getText()), new STU(tf1.getText(), Integer.parseInt(tf2.getText()),
					Integer.parseInt(tf3.getText()), Integer.parseInt(tf4.getText())));
			tf.setText("");
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
//출력 
		else if (str.equals("Output"))
		{

			int stunum;
			Set<Integer> s = hm.keySet();
			Iterator<Integer> it = s.iterator();
			ta.setText("");
			while (it.hasNext())

			{
				stunum = it.next();
				ta.append(hm.get(stunum).toString() + "\n");
			}
		}
//수정 
		else if (str.equals("Modify"))

		{
			int stunum = 0;
			stunum = Integer.parseInt(tf.getText());

			if (hm.containsKey(stunum)) {
				hm.get(stunum).setName(tf1.getText());
				hm.get(stunum).setKor((Integer.parseInt(tf2.getText())));
				hm.get(stunum).setEng((Integer.parseInt(tf3.getText())));
				hm.get(stunum).setMath((Integer.parseInt(tf4.getText())));
			}

			else {
				ta.setText("그런학생이 존재하지 않습니다.");
			}
			tf.setText("");
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
//삭제
		else if (str.equals("Delete"))
		{
			int stunum = 0;
			stunum = Integer.parseInt(tf.getText());
			if (hm.containsKey(stunum))
			{
				hm.remove(stunum);
			}
			else {
				ta.setText("그런학생이 존재하지 않습니다.");
			}
		}
//검
		else if (str.equals("Search"))
		{
			ta.setText("");
			int stunum = 0;
			stunum = Integer.parseInt(tf.getText());
			if (hm.containsKey(stunum))
			{
				ta.append(hm.get(stunum).toString() + "\n");
			} else
			{
				ta.setText("그런학생이 존재하지 않습니다.");
			}
		}
//종
		else if (str.equals("Exit"))
			System.exit(0);
	}
	public static void main(String[] args) {
		Bb go = new Bb();
	}
}