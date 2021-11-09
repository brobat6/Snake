package snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class Game extends JFrame {
//	public Game() {
//		super("Hungry Snake");
//		setSize(800, 600);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//}

public class Game extends Frame {
	
	public Game() {
		jf = new JFrame("Hungry Snake Game");
		jf.setSize(800, 600);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Board board = new Board(0, "default", 0, 0);
		jf.setVisible(true);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}
}
