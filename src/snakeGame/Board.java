package snakeGame;

import javax.swing.JFrame;

public class Board extends Game {
	private int difficulty;
	private String username;
	Snake snake;
	Food food;

	Board(int difficulty, String username, int snakeID, int foodID) {
		this.difficulty = difficulty;
		this.username = username;
		snake = new Snake(snakeID);
		food = new Food(foodID);
		createGUI();
	}
	
	void createGUI() {
		jf = new JFrame("Hungry Snake Game");
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
