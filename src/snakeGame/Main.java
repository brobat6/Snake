package snakeGame;

import javax.swing.*;

public class Main extends JFrame {
	public Main() {
        add(new Game());
        setResizable(false);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jf = new Main();
				jf.setVisible(true);
			}
		});
	}
}
