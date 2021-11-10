package snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
	private Snake snake;
	private Board board;
	
	public Game(Snake snake, Board board) {
		
	}
}

//public class Game extends Frame {
//	
//	public Game() {
//		jf = new JFrame("Hungry Snake Game");
//		jf.setSize(600, 600);
//		jf.setLayout(new FlowLayout());
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Board board = new Board(0, "default");
//		jf.setVisible(true);
//	}
//	
//	public static void main(String args[]) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new Game();
//			}
//		});
//	}
//}