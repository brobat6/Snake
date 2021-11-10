package snakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Snake {
	private LinkedList<Cell> snake;
	private Cell head;
	
	public Snake() {
		snake = new LinkedList<Cell>();
		head = new Cell(100, 100); // Put random values instead of 100, 100.
		snake.add(head);
	}
	public void grow() {
		snake.add(head);
	}
	public void move(Cell next) {
		snake.removeLast();
		head = next;
		snake.add(head);
	}
	public boolean isGoingToCrash(Cell next) {
		for(Cell cell : snake) {
			if(cell == next) return true;
		}
		return false;
	}
	public Cell getHead() {
		return head;
	}
	public LinkedList<Cell> getSnake() {
		return snake;
	}
}

//public class Snake extends Frame {
//	private Image head;
//	private Image body;
//	
//	public Snake() {
//		ImageIcon temp_h = new ImageIcon("src/resources/head.png");
//		ImageIcon temp_b = new ImageIcon("src/resources/body.png");
//		head = temp_h.getImage();
//		body = temp_b.getImage();
//		JLabel jl = new JLabel("", temp_h, JLabel.CENTER);
//		jf.add(jl);
//		for(int i = 0; i < 3; i ++) {
//			jl = new JLabel("", temp_b, JLabel.CENTER);
//			jf.add(jl);
//		}
//	}
//}
