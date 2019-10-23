package imagePuzzle;


import javax.swing.JFrame;

class SlidePuzzle {
 public static void main(String[] args) {
     JFrame window = new JFrame("그림퍼즐");
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setContentPane(new SlidePuzzleGUI());
     window.pack();  
     window.show();  
     window.setResizable(false);
 }
}
