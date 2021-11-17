package snakeGame;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
//	Direction direction;
	private Snake snake;
	private Timer timer;
	private final int DELAY = 200;
	
	public Game() {
		addKeyListener(new MyKeyAdapter());
		setBackground(Color.black);
		snake = new Snake();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		LinkedList<Cell> snakeList = snake.getSnake();
		for(Cell part : snakeList) {
			g.setColor(Color.red);
			if(part.equals(snake.getHead())) {
				g.setColor(Color.green);
			}
			g.fillRect(part.getRow(), part.getCol(), 15, 15);
		}
		Toolkit.getDefaultToolkit().sync();
//		snake.move(new Cell(snake.getHead().getRow() + 1, snake.getHead().getCol()));
//		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		snake.move(new Cell(snake.getHead().getRow() + 20, snake.getHead().getCol()));
		repaint();
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
//			if(key == KeyEvent.VK_UP) direction.setDirection('U');
//			if(key == KeyEvent.VK_RIGHT) direction.setDirection('R');
//			if(key == KeyEvent.VK_DOWN) direction.setDirection('D');
//			if(key == KeyEvent.VK_LEFT) direction.setDirection('L');
		}
	}
}