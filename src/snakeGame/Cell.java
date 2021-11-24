package snakeGame;

public class Cell {
	private int row, col;
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean equals(Cell c) {
		return this.row==c.row && this.col == c.col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
