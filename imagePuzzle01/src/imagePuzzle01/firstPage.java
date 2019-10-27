package imagePuzzle01;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class firstPage {
	public static void main(String[] args) {
		test_Frame tf = new test_Frame();
	}
}

class test_Frame extends JFrame implements ActionListener {

	int levelIs = 2;

	public int getLevelIs() {
		return levelIs;
	}

	public void setLevelIs(int levelIs) {
		this.levelIs = levelIs;
	}

	static String filePath = "1.jpg";
	// 기본 이미지 설정

	boolean open = false;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	Container contentPane;
	JLabel imageLabel = new JLabel();
	JButton jbt1 = new JButton("쉬움");
	JButton jbt2 = new JButton("보통");
	JButton jbt3 = new JButton("어려움");
//	JButton jbt4 = new JButton("매우어려움");
	// 버튼설정
	level tf2;
	level tf3;
	level tf4;

	// 호출할 class미리 호출

	static int sizeNumber = 1;

	public int getSizeNumber() {
		return sizeNumber;
	}

	public void setSizeNumber(int sizeNumber) {
		this.sizeNumber = sizeNumber;
	}

	JTextField tf;

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}

	Container container;
	JLabel label;

	public test_Frame() {
		this.setLayout(new GridLayout(0, 2));
		getContentPane().add(jbt1);
		getContentPane().add(jbt2);
		getContentPane().add(jbt3);

		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("설정");
		JMenuItem openItem = new JMenuItem("그림선택");

		// Open 메뉴아이템에 Action 리스너를 등록한다.
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);

		this.setJMenuBar(mb);
		this.setSize(300, 300);
		this.setVisible(true);

		container = getContentPane();
		tf = new JTextField(25);

		setLayout(new FlowLayout());

		container.add(new JLabel("Enter the number"));
		container.add(tf);
		container.add(label = new JLabel());

		jbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				System.out.println(arg0);
				if (arg0.getSource() == jbt1) {
					setLevelIs(2);
					tf2 = new level(Integer.parseInt(tf.getText()), getFilePath(), getLevelIs());

				}

			}
		});
		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == jbt2) {
					setLevelIs(3);
					tf3 = new level(Integer.parseInt(tf.getText()), getFilePath(), getLevelIs());

				}

			}
		});
		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == jbt3) {
					setLevelIs(4);
					tf4 = new level(Integer.parseInt(tf.getText()), getFilePath(), getLevelIs());

				}

			}
		});

		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = tf.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					tf.setEditable(true);
					label.setText("");
				} else {
					tf.setEditable(false);
					label.setText("* Enter only numeric digits(0-9)");
				}

			}
		});

	}

	class OpenActionListener implements ActionListener {
		JFileChooser chooser;

		OpenActionListener() {
			chooser = new JFileChooser(); // 파일 다이얼로그 생성
		}

		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
			// 파일 필터로 사용되는 확장자.jpg.gif만 나열됨
			chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정

			// 파일 다이얼로그 출력
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) { // 사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
