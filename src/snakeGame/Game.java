package snakeGame;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
	private Snake snake;
	private Timer timer;
	private final int DELAY = 150;
	private Cell food;
	final int SIZE = 30;
	private boolean gameOver;
	
	public Game() {
		addKeyListener(new CustomKeyListener());
		gameOver = false;
		setBackground(Color.black);
		setFocusable(true); // This NEEDS to happen, or else we can't implement KeyListener on a JPanel.
//		https://stackoverflow.com/questions/8498147/addkeylistener-doesnt-work-for-jpanel
		setBorder(BorderFactory.createLineBorder(Color.red, 5));
		snake = new Snake();
		generateFood(); // Random values for this.
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.yellow);
//		https://www.javatpoint.com/Graphics-in-applet
		g.fillOval(food.getRow(), food.getCol(), 15, 15);
		LinkedList<Cell> snakeList = snake.getSnake();
		for(Cell part : snakeList) {
			g.setColor(Color.red);
			if(part.equals(snake.getHead())) {
				g.setColor(Color.green);
			}
			g.fillRect(part.getRow(), part.getCol(), 15, 15);
		}
		Toolkit.getDefaultToolkit().sync(); // No idea what this does.
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(isGameOver()) {
			
			System.out.println("Game over.");
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
//		while(true) {
//		TODO : If random generation is inside the snake, try again.	
//		}
		int row = (int) (Math.random() * SIZE) * 20 + 5;
		int col = (int) (Math.random() * SIZE) * 20 + 5;
		food = new Cell(row, col);
	}
	
	class CustomKeyListener implements KeyListener {
//		Can implement KeyAdapter class too, if we do that, we won't have to make 
//		empty keyTyped and keyReleased methods.0
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_UP) snake.setDirection('U');
			if(key == KeyEvent.VK_RIGHT) snake.setDirection('R');
			if(key == KeyEvent.VK_DOWN) snake.setDirection('D');
			if(key == KeyEvent.VK_LEFT) snake.setDirection('L');
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}
}