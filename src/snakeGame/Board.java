package snakeGame;

import javax.swing.*;

public class Board {
	final int ROWS = 30;
	final int COLS = 30;
	
	public void generateFood() {
//		This method COULD generate food inside the current location of snake.
		int row = (int) (Math.random() * ROWS);
		int col = (int) (Math.random() * COLS);
		Food f = new Food(new Cell(row, col));
	}
}

//public class Board extends Frame {
//	private int difficulty;
//	private String username;
//	Snake snake;
//	Food food;
//
//	public Board(int difficulty, String username) {
//		this.difficulty = difficulty;
//		this.username = username;
//		snake = new Snake();
//		food = new Food();
//		jf.setVisible(true);
//	}
//}
