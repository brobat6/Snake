package snakeGame;

import java.util.*;

public class Snake {
	private LinkedList<Cell> list;
	private Cell head;
	private Direction direction;
	
	public Snake() {
		list = new LinkedList<Cell>();
		initSnake();
		direction = new Direction();
	}
	private void initSnake() {
		head = new Cell(205, 165);
		list.add(head);
		list.add(new Cell(185, 165));
		list.add(new Cell(165, 165));
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
//		THE ROW AND COL ARE CURRENTLY OPPOSITE!! Don't try to change, the code breaks if you do it.
		if(c=='U') return new Cell(head.getRow(), head.getCol() - 20);
		if(c=='R') return new Cell(head.getRow() + 20, head.getCol());
		if(c=='D') return new Cell(head.getRow(), head.getCol() + 20);
		if(c=='L') return new Cell(head.getRow() - 20, head.getCol());
		return new Cell(0, 0); // Throw an exception for better code documentation.
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
