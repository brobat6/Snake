package snakeGame;

import java.util.*;

public class Snake {
	private LinkedList<Cell> list;
	private Cell head;
	
	public Snake() {
		list = new LinkedList<Cell>();
		head = new Cell(100, 100);
		list.add(head);
		list.add(new Cell(80, 100));
		list.add(new Cell(60, 100));
	}
	public void grow() {
		list.add(head);
	}
	public void move(Cell next) {
		list.removeLast();
		head = next;
		list.addFirst(head);
	}
//	public Cell getNext() {
//		
//	}
	public boolean isGoingToCrash(Cell next) {
		if(next.getCol() < 0 || next.getCol() >= 600 || next.getRow() < 0 || next.getRow() >= 600) return true;
		for(Cell cell : list) {
			if(cell == list.getLast()) continue;
			if(cell == next) return true;
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
