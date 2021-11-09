package snakeGame;

import javax.swing.*;

//public class Board {
//	private Game game;
//	public Board(Game game) {
//		this.game = game;
//		game.setContentPane();
//	}
//}

public class Board extends Frame {
	private int difficulty;
	private String username;
	Snake snake;
	Food food;

	public Board(int difficulty, String username, int snakeID, int foodID) {
		this.difficulty = difficulty;
		this.username = username;
		snake = new Snake(snakeID);
		food = new Food(foodID);
		JLabel jl = new JLabel("Difficulty - " + difficulty);
		jf.add(jl);
		jf.setVisible(true);
	}
}
