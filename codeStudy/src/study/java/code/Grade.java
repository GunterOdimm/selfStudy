package study.java.code;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Grade {

    public static void main(String[] args) {
        //GUI 틀 만들기
        JFrame jframe = new JFrame();
        jframe.setBounds(50, 50, 500, 300); //전체 창 크기
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 버튼 누르면 꺼지게 설정
        jframe.setVisible(true);

        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jframe.add(jpanel);

        //입력 공간
        JTextField tf = new JTextField(); 
        tf.setSize(300, 30);
        tf.setLocation(5, 5);
        jpanel.add(tf);
        
        //입력한 글이 보이는 창
        JTextArea ta = new JTextArea(); 
        JScrollPane jsp = new JScrollPane(ta); //창 스크롤
        jsp.setSize(300, 200);
        jsp.setLocation(5, 50);
        jframe.add(jsp);

        //제일 처음에 보이는 글씨
        ta.setText("입력 : 이름 / 국어 / 영어 / 수학" + "\n" + "☆검색 / 수정 / 삭제 시 이름 입력☆" + "\n");

        //입력 버튼
        JButton btn1 = new JButton("입력");
        jpanel.add(btn1);
        btn1.setBounds(350, 20, 100, 30);

        //출력 버튼
        JButton btn2 = new JButton("출력");
        jpanel.add(btn2);
        btn2.setBounds(350, 60, 100, 30);

        //검색 버튼
        JButton btn3 = new JButton("검색");
        jpanel.add(btn3);
        btn3.setBounds(350, 100, 100, 30);

        //수정 버튼
        JButton btn4 = new JButton("수정");
        jpanel.add(btn4);
        btn4.setBounds(350, 140, 100, 30);

        //삭제 버튼
        JButton btn5 = new JButton("삭제");
        jpanel.add(btn5);
        btn5.setBounds(350, 180, 100, 30);

        //종료 버튼
        JButton btn6 = new JButton("종료");
        jpanel.add(btn6);
        btn6.setBounds(350, 220, 100, 30);

        ArrayList<Manager> list = new ArrayList<Manager>(); //ArrayList 선언

        //입력 버튼 이벤트
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //한명씩 입력
                //공백을 기준으로 내용을 나눔
                String[] temp = tf.getText().split(" ");
                //배열에 저장
                int kor = Integer.parseInt(temp[1]);
                int math = Integer.parseInt(temp[2]);
                int eng = Integer.parseInt(temp[3]);
                list.add(new Manager(temp[0], kor, math, eng));
                ta.append(tf.getText() + "\n");
            }
        });

        //출력 버튼 이벤트
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //전체 출력
                for (int i = 0; i < list.size(); i++) {
                    ta.append(list.get(i).toString() + "\n");
                }
            }
        });

        //검색 버튼 이벤트
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = tf.getText(); // TextField.getText()
                Iterator<Manager> it = list.iterator();
                while (it.hasNext()) {
                    Manager temp = it.next();
                    //이름으로 검색
                    if (temp.getName().equals(name)) {
                        ta.setText(temp.toString() + "\n"); //한명 출력 후 다음줄로 넘어감
                    }
                }
            }
        });

        //수정 버튼 이벤트
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String[] name1 = tf.getText().split(" ");
                int kor = Integer.parseInt(name1[1]);
                int math = Integer.parseInt(name1[2]);
                int eng = Integer.parseInt(name1[3]);
                Iterator<Manager> it1 = list.iterator();
                while (it1.hasNext()) {
                    Manager temp = it1.next();
                    //이름 검색하여 수정할 내용 입력
                    if (temp.getName().equals(name1[0])) {
                        temp.setKor(kor);
                        temp.setMath(math);
                        temp.setEng(eng);
                    }
                }

            }
        });

        //삭제 버튼 이벤트
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int num = 0;
                String name2 = tf.getText();
                Iterator<Manager> it2 = list.iterator();
                while (it2.hasNext()) {
                    Manager temp = it2.next();
                    //이름 검색해서 삭제
                    if (temp.getName().equals(name2)) {
                        list.remove(num);
                    }
                    num++;
                }
            }
        });

        //종료 버튼 이벤트
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }
}

