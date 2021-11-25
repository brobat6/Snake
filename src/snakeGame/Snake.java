package snakeGame;

import java.util.*;

public class Snake {
	private LinkedList<Cell> list;
	private Cell head;
	private Direction direction;
	private int difficulty;
	private int size;
	private final int SHIFT = 5;
	
	public Snake(int difficulty) {
		list = new LinkedList<Cell>();
		this.difficulty = difficulty;
		switch(difficulty) {
			case 0 : size = 20; break;
			case 1 : size = 30; break;
			case 2 : size = 50; break;
		}
		initSnake();
		direction = new Direction();
	}
	
	private void initSnake() {
		head = new Cell(size * 6 + SHIFT, size * 3 + SHIFT);
		list.add(head);
		list.add(new Cell(size * 5 + SHIFT, size * 3 + SHIFT));
		list.add(new Cell(size * 4 + SHIFT, size * 3 + SHIFT));
	}
	
	public void grow(Cell next) {
		head = next;
		list.addFirst(head);
	}
	
	public void move(Cell next) {
		list.removeLast();
		head = next;
		list.addFirst(head);
	}
	
	public void setDirection(char c) {
		direction.setDirection(c);
	}
	
	public char getDirection() {
		return direction.getDirection();
	}
	
	public Cell findNextCell() {
		char c = direction.getDirection();
		if(c=='U') return new Cell(head.getRow(), head.getCol() - size);
		if(c=='R') return new Cell(head.getRow() + size, head.getCol());
		if(c=='D') return new Cell(head.getRow(), head.getCol() + size);
		if(c=='L') return new Cell(head.getRow() - size, head.getCol());
		return new Cell(0, 0);
	}
	
	public boolean isGoingToCrash(Cell next) {
		if(next.getCol() < 5 || next.getCol() >= 600 || next.getRow() < 5 || next.getRow() >= 600) return true;
		for(Cell cell : list) {
			if(cell == list.getLast()) continue;
			if(cell.equals(next)) return true;
		}
		return false;
	}
	
	public Cell getHead() {
		return head;
	}
	
	public LinkedList<Cell> getSnake() {
		return list;
	}
}
