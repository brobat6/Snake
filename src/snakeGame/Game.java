package snakeGame;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	
	private Snake snake;
	private Timer timer;
	private final int DELAY_MAX = 150;
	private final int DELAY_MIN = 25;
	private Cell food;
	final int SIZE = 30;
	private boolean gameOver;
//	private Image foodIcon;
	
	public Game() {
		setBackground(Color.black);
		setBorder(BorderFactory.createLineBorder(Color.red, 3));
		timer = new Timer(DELAY_MAX, this);
		timer.start();
//		ImageIcon ii = new ImageIcon("src/resources/Food.png");
//		foodIcon = ii.getImage();
		startNewGame();
	}
	
	private void startNewGame() {
		gameOver = false;
		snake = new Snake();
		generateFood();
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
			String gameOverScore = "Your score is : " + snake.getSnake().size();
			String gameOverRestart = "Press SPACE to play again.";
			Font big = new Font("Serif", Font.BOLD, 74);
			Font medium = new Font("Courier", Font.BOLD, 32);
			Font small = new Font("Arial", Font.BOLD, 26);
			g.setColor(Color.green);
			g.setFont(big);
			g.drawString(gameOverMessage, 120, 220);
			g.setFont(medium);
			g.drawString(gameOverScore, 140, 300);
			g.setFont(small);
			g.drawString(gameOverRestart, 130, 380);
		}
		else {
			super.paintComponent(g);
			g.setColor(Color.yellow);
//			https://www.javatpoint.com/Graphics-in-applet
			g.fillOval(food.getRow(), food.getCol(), 15, 15);
			LinkedList<Cell> snakeList = snake.getSnake();
			for(Cell part : snakeList) {
				g.setColor(Color.green);
				if(part.equals(snake.getHead())) {
					g.setColor(Color.red);
				}
//				g.fillRect(part.getRow(), part.getCol(), 15, 15);
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
		}
		else {
			if(next.equals(food)) {
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
		}
		
		public void keyTyped(KeyEvent e) {}
		
		public void keyReleased(KeyEvent e) {}
	}
}