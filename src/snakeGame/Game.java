package snakeGame;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener {
	
	private Snake snake;
	private static Timer timer;
	private final int DELAY_MAX = 150;
	private final int DELAY_MIN = 25;
	private Cell food;
	final int SIZE = 30;
	private boolean gameOver;
	private Image foodIcon;
	private int score;
	
	public Game() {
		timer = new Timer(DELAY_MAX, this);
		timer.start();
		startNewGame();
	}
	
	public void startNewGame() {
		setBackground(Color.black);
		setBorder(BorderFactory.createLineBorder(Color.red, 3));
		gameOver = false;
		snake = new Snake();
		generateFood();
		score = 0;
	}
	
	public void setGameFocus() {
//		https://stackoverflow.com/questions/8498147/addkeylistener-doesnt-work-for-jpanel
		setFocusable(true);
		requestFocus();
		addKeyListener(new CustomKeyListener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(gameOver) {
			String gameOverMessage = "Game Over";
			String gameOverScore = "Your score is : " + score;
			String gameOverRestart = "Press SPACE to play again.";
			String gameOverExit = "Press ESC to exit the application.";
			Font big = new Font("Serif", Font.BOLD, 74);
			Font medium = new Font("Courier", Font.BOLD, 32);
			Font small = new Font("Arial", Font.BOLD, 22);
			g.setColor(Color.green);
			g.setFont(big);
			g.drawString(gameOverMessage, 120, 220);
			g.setFont(medium);
			g.drawString(gameOverScore, 140, 300);
			g.setFont(small);
			g.drawString(gameOverRestart, 145, 400);
			g.drawString(gameOverExit, 115, 440);
		}
		else {
			super.paintComponent(g);
			g.setColor(Color.yellow);
//			https://www.javatpoint.com/Graphics-in-applets
			g.drawImage(foodIcon, food.getRow(), food.getCol(), this);
			LinkedList<Cell> snakeList = snake.getSnake();
			for(Cell part : snakeList) {
				g.setColor(Color.green);
				if(part.equals(snake.getHead())) {
					g.setColor(Color.red);
				}
				g.fillOval(part.getRow(), part.getCol(), 17, 17);
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(DELAY_MIN < DELAY_MAX - 4 * snake.getSnake().size()) {
			timer.setDelay(DELAY_MAX - 4 * snake.getSnake().size());
		}
		else {
			timer.setDelay(DELAY_MIN);
		}
		if(gameOver) {
			return;
		}
		Cell next = snake.findNextCell();
		if(snake.isGoingToCrash(next)) {
			gameOver = true;
//			DataBase.updateHighScores(difficulty, score);
		}
		else {
			if(next.equals(food)) {
				score++;
				generateFood();
				snake.grow(next);
				System.out.println("Found Food");
			}
			else {
				snake.move(next);
			}
		}
		repaint();
	}
	
	private void generateFood() {
		while(true) {
			int row = (int) (Math.random() * SIZE) * 20 + 5;
			int col = (int) (Math.random() * SIZE) * 20 + 5;
			food = new Cell(row, col);
			boolean isPossible = true;
			for(Cell cell : snake.getSnake()) {
				if(food.equals(cell)) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				break;
			}
		}
		int imageSelector = (int) (Math.random() * 8);
		if(imageSelector < 1 || imageSelector > 8) {
			imageSelector = 2;
		}
		System.out.println(imageSelector);
		ImageIcon ii = new ImageIcon("src/resources/food" + imageSelector + ".png");
		foodIcon = ii.getImage();
//		foodIcon = foodIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	}
	
	private void mainMenu() {
		gameOver = false;
		Main.jf.remove(this);
		Main.mainMenu();
	}
	
	
	
	private class CustomKeyListener implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(key == KeyEvent.VK_UP) {
				snake.setDirection('U');
			}
			if(key == KeyEvent.VK_RIGHT) {
				snake.setDirection('R');
			}
			if(key == KeyEvent.VK_DOWN) {
				snake.setDirection('D');
			}
			if(key == KeyEvent.VK_LEFT) {
				snake.setDirection('L');
			}
			if(key == KeyEvent.VK_SPACE && gameOver) {
				startNewGame();
			}
			if(key == KeyEvent.VK_ESCAPE && gameOver) {
				mainMenu();
//				gameOver = false;
//				String args[] = new String[1];
//				Main.main(args);
			}
		}
		
		public void keyTyped(KeyEvent e) {}
		
		public void keyReleased(KeyEvent e) {}
	}
}