package imagePuzzle01;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import imagePuzzle01.test_Frame.OpenActionListener;

public class level extends JFrame implements ActionListener {

	int score = 0;
	long start = System.currentTimeMillis();
	JMenu fileMenu;
	JMenuItem openItem;
	JButton[] btn;
	int count = 0, game[], row = 0, col = 0;
	int clickCount, oldNum, curNum;
	static int levelDiv = 1;
	Image original;
	BufferedImage img[];
	boolean isShuffling = false;
	boolean isAutoSolving = false;

	public level(int size, String filepath, int levelchoose) {
		Container container;

//		System.out.println(size + "여긴사이즈");

//		System.out.println(score + " 2");
		levelDiv = levelchoose;
		row = size;
		col = size;
		score = size * size;
//
		System.out.println(score + " 3");
		String userImage = filepath;
		JMenuBar mb = new JMenuBar();
		fileMenu = new JMenu("힌트");
		openItem = new JMenuItem("정답보기");

		// Open 메뉴아이템에 Action 리스너를 등록한다.
		fileMenu.add(openItem);
		mb.add(fileMenu);

		this.setJMenuBar(mb);
		this.setSize(300, 300);
		this.setVisible(true);

		container = getContentPane();
		MediaTracker tracker = new MediaTracker(this);
		// 미디어 트래커를 이용해 이미지를 가지고오자.
		original = Toolkit.getDefaultToolkit().getImage(userImage);
		tracker.addImage(original, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			;
		}
		int width = original.getWidth(this) / col;
		// 넓이는 col로 나누어 주자
		int height = original.getHeight(this) / row;
		// 높이는 row로 나누어 주자.
		setSize(new Dimension(width * col, height * row));
		// 높이 넓이를 각각 정해주자.

		img = new BufferedImage[row * col];
		// 이미지 품질을 유지
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				img[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				g.drawImage(original, 0, 0, width, height, j * width, i * height, (j + 1) * width, (i + 1) * height,
						this);
				// 원본이미지에서 필요한 부분만 잘라낸 다음 사용하자.
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
		// 숫자 섞고 버튼에 이미지 입히기
		shuffle();
		// 나눴으면 섞어주자.
		setLayout(new GridLayout(row, col));

		setResizable(false);
		setVisible(true);
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {

					@Override
					public void run() {
						isAutoSolving = true;
						// TODO Auto-generated method stub

						while (!endGame()) {
							for (int i = 0; i < game.length; i++) {
//								System.out.print(game[i] + " ");
								if (i != game[i]) {
									int curNum = game[i];
									int oldNum = game[curNum];
									game[i] = oldNum;
									game[curNum] = curNum;
									btn[oldNum].setIcon(new ImageIcon(img[game[oldNum]]));
									btn[curNum].setIcon(new ImageIcon(img[game[curNum]]));

									try {
										Thread.sleep(10);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
						isAutoSolving = false;
					}
					
				}).start();

			}
		});
	}

	// 숫자 섞고 버튼에 이미지 입히기
	private void shuffle() {
		Random rnd = new Random();
		// 섞는 값은 매번 랜덤으로 돌려주자.
		
		int length = row * col;
//		do {
		for (int i = 0; i < row * col; i++)
			game[i] = i;
		int target = score / levelDiv;
		
//		System.out.println(levelDiv);
		for (int i = 0; i < game.length; i++) {
//			System.out.print(game[i] + " ");
		}

		for (int i = 0; i < row * col; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));
		}
		//System.out.println();
		new Thread(new Runnable() {

			@Override
			public void run() {
				isShuffling = true;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// TODO Auto-generated method stub
				while (score >= target) {
//					System.out.println(score + " 1");
					int before = 0;
					int after = 0;
					int a = rnd.nextInt(row * col);
					int b = rnd.nextInt(row * col);
					while (a == b) {
						b = rnd.nextInt(row * col);
					}
//					System.out.print(a + "여긴 a ");
//					System.out.println(b);
//						if(before == game[a] && game[a] == a+game[b] && b == a+game[b]) {
//							before = 0;
//						}else {
//							before = 1;
//						}
					if (game[a] == a) {
						before += 1;
					}
					if (game[b] == b) {
						before += 1;
					}
//					System.out.print(a + " ");
//					System.out.print(b);
//					System.out.println();
					int temp = game[b];
					game[b] = game[a];
					game[a] = temp;
					if (game[a] == a) {
						after += 1;
					}
					if (game[b] == b) {
						after += 1;
					}
					btn[a].setIcon(new ImageIcon(img[game[a]]));
					btn[b].setIcon(new ImageIcon(img[game[b]]));
//					System.out.print(score + "  ");
//					System.out.print(after + "  ");
//					System.out.print(before);
//						if(after == game[a] && game[a] ==b && game[b]== a) {
					score += after - before;
//						}
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				isShuffling = false;
			}
			
		}).start();
		for (int i = 0; i < game.length; i++) {
//			System.out.print(game[i] + " ");
		}
//		System.out.println();

		/*
		 * game[a] int target = score/2; while score >= target){ 10 * 10 = 100 그대로 쓴다 a
		 * = random . nextInt b = random.nextInt while a == b){ b= random.nextInt }
		 * before = temp a == a+temp b == b =ture =0;
		 * 
		 * temp b = a; temp a = b;
		 * 
		 * after = temp a == b temp b == a; score += after-before }
		 * 
		 */
//			for (int i = 0; i < row * col; i++) {
//				int temp = 0;
//				do {
//					temp = rnd.nextInt(row * col);
//				} while (game[temp] != 0);
//				game[temp] = i;
//			}
//		} while (endGame());

	}

	public void actionPerformed(ActionEvent e) {
		if(isShuffling || isAutoSolving) {
			clickCount = 0;
			return;
		}

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

					scoreBord c = null;
					try {
						c = new scoreBord();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					c.setSecDiffTime(secDiffTime);

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
