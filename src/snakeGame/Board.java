package snakeGame;

public class Board {
	private int difficulty;
	private String username;
	Snake snake;
	Food food;
	
	Board() {
//		The constructor for a "Quick Play" option, without log-in.
		difficulty = 0;
		username = "defaultUser";
		snake = new Snake();
		food = new Food();
	}
	Board(int difficulty, String username, int snakeID, int foodID) {
//		Full-featured constructor. snakeID and foodID decide the type/skin.
		this.difficulty = difficulty;
		this.username = username;
		snake = new Snake(snakeID);
		food = new Food(foodID);
	}
}
