package imagePuzzle01;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test_Frame1 extends JFrame implements ActionListener {

	private int num;

	public void setNum(int num) {
		this.num = num;
	}
	
	long start = System.currentTimeMillis();
	JButton[] btn;
	int count = 0, game[], row = 4, col = 4;
	int clickCount, oldNum, curNum;
	Image original;
	BufferedImage img[];

	public test_Frame1() {

		MediaTracker tracker = new MediaTracker(this);
		original = Toolkit.getDefaultToolkit().getImage("1.jpg");
		tracker.addImage(original, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			;
		}
		int width = original.getWidth(this) / col;
		int height = original.getHeight(this) / row;
		setSize(new Dimension(width * col, height * row));

		img = new BufferedImage[row * col];
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				img[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				g.drawImage(original, 0, 0, width, height, j * width, i * height, (j + 1) * width, (i + 1) * height,
						this);
				cnt++;
			}
		}

		// 게임배열
		game = new int[row * col];

		// 버튼을 만들기
		btn = new JButton[row * col];

		for (int i = 0; i < row * col; i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			add(btn[i]);
		}

		shuffle();
		setLayout(new GridLayout(row, col));

		setResizable(false);
		setVisible(true);

	}

	private void shuffle() {
		Random rnd = new Random();

		do {
			for (int i = 0; i < row * col; i++)
				game[i] = 0;

			for (int i = 0; i < row * col; i++) {
				int temp = 0;
				do {
					temp = rnd.nextInt(row * col);
				} while (game[temp] != 0);
				game[temp] = i;
			}
		} while (endGame());

		for (int i = 0; i < row * col; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));
		}

	}

	public void actionPerformed(ActionEvent e) {

		JButton curBtn = (JButton) e.getSource();

		for (int i = 0; i < btn.length; i++) {
			if (curBtn.getIcon().equals(btn[i].getIcon())) {
				curNum = i;
				break;
			}
		}

		if (clickCount == 0) {

			clickCount++;
			oldNum = curNum;

		} else {

			if (oldNum != curNum) {

				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));

				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;

				if (endGame()) {
					int[][] scorebord = new int[10][3];
					long end = System.currentTimeMillis();
					long secDiffTime = (end - start) / 1000;
					JOptionPane.showMessageDialog(this, "성공했습니다!" + secDiffTime + "초 만큼걸렸습니다");
					JFrame jframe = new JFrame();
					jframe.setBounds(50, 50, 500, 300); // 전체 창 크기
					jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정
					jframe.setVisible(true);
					
					JPanel jpanel = new JPanel();

					/*
					 * int reStart = JOptionPane.showConfirmDialog(this, "재시작할까요?", "종료할까요?",
					 * JOptionPane.YES_NO_OPTION); if (reStart == JOptionPane.YES_OPTION) {
					 * shuffle(); repaint();
					 * 
					 * } else { System.exit(0); }
					 */
				}
			}
			clickCount = 0;

		}
	}

	private boolean endGame() {
		boolean endGame = true;

		for (int i = 0; i < game.length; i++) {
			if (i != game[i]) {
				endGame = false;
			}
		}

		return endGame;

	}
}
