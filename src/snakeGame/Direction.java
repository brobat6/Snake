package snakeGame;

public class Direction {
	private int right, left, up, down;
	Direction() {
		update(0, 0, 0, 0);
	}
	private void update(int up, int right, int down, int left) {
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}
	public void setDirection(char c) {
		if(c=='U' && up != -1) {
			update(1, 0, -1, 0);
		}
		if(c=='D' && down != -1) {
			update(-1, 0, 1, 0);
		}
		if(c=='R' && right != -1) {
			update(0, 1, 0, -1);
		}
		if(c=='L' && left != -1) {
			update(0, -1, 0, 1);
		}
	}
	public char getDirection() {
		if(up == 1) return 'U';
		if(down == 1) return 'D';
		if(right == 1) return 'R';
		if(left == 1) return 'L';
		return '0';
	}
}
