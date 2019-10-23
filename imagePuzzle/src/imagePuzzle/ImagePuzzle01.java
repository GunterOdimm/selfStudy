package imagePuzzle;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//사용법 : 바꾸고 싶은 퍼즐 조각 두개를 연달아 클릭하면, 두개의 퍼즐이 맞바뀐다
//   단, 같은 퍼즐조각을 실수로 한번 잘못 눌렀을 때, 잘못 누른 퍼즐조각을 한번 더 클릭하면 바뀌지 않는다


public class ImagePuzzle01 extends JFrame implements ActionListener {

	
	JButton[] btn;
	int count = 0, game[], row = 3, col = 3;
	int clickCount, oldNum, curNum;
	Image original;
	BufferedImage img[];

	public ImagePuzzle01() {
        
		// 원본 그림 읽기
		MediaTracker tracker = new MediaTracker(this);
		original = Toolkit.getDefaultToolkit().getImage("1.jpg"); // 1.jpg라는 이미지를 프로젝트 안에 넣어야함
		tracker.addImage(original, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			;
		}
		int width = original.getWidth(this) / col;
		int height = original.getHeight(this) / row;
		setSize(new Dimension(width * col, height * row));

		// 이미지를 잘라 넣자
		img = new BufferedImage[row * col];
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				img[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				// 원본이미지에서 필요한 부분만 잘라서 그리기
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

		shuffle(); // 숫자 섞고 버튼에 이미지 입히기
		setLayout(new GridLayout(row, col));

		setResizable(false);
		setVisible(true);

	}

	// 숫자 섞고 버튼에 이미지 입히기
	private void shuffle() {
		Random rnd = new Random();

		do {
			for (int i = 0; i < row * col; i++)
				game[i] = 0;

			// 배열의 중복값없이 넣기
			for (int i = 0; i < row * col; i++) {
				int temp = 0;
				do {
					temp = rnd.nextInt(row * col);
				} while (game[temp] != 0);
				game[temp] = i;
			}
		} while (endGame()); // 섞이지 않았을떄 다시 섞어라!!!

		// 배열값으로 이미지를 선택해서 버튼에 부여
		for (int i = 0; i < row * col; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));
		}

	}

	public static void main(String[] args) {
		
		new ImagePuzzle01();
	}

	public void actionPerformed(ActionEvent e) {

		JButton curBtn = (JButton) e.getSource();

		for (int i = 0; i < btn.length; i++) {
			if (curBtn.getIcon().equals(btn[i].getIcon())) {
				// System.out.println(i + ":" + game[i]);
				curNum = i;
				break;
			}
		}

		if (clickCount == 0) { // 첫번째 클릭이면

			clickCount++;
			oldNum = curNum;

		} else {

			// 두번째 클릭이면
			if (oldNum != curNum) { // 이전 것과 같지 않다면

				// 이미지 변경
				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));

				// 배열값 변경
				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;

				// 여기서 게임 종료확인
				if (endGame()) {
					JOptionPane.showMessageDialog(this, "성공했습니다!");
					// 게임 재시작을 확인
					int reStart = JOptionPane.showConfirmDialog(this, "재시작할까요?", "종료할까요?", JOptionPane.YES_NO_OPTION);
					if (reStart == JOptionPane.YES_OPTION) {
						// 배열을 다시 섞고 다시 그리기를 한다.
						shuffle(); // 섞기
						repaint(); // 다시 그리기
					} else {
						System.exit(0);
					}
				}
			}
			clickCount = 0;
		}
	}

	// 게임 종료를 확인 하는 메소드
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