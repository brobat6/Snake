package snakeGame;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	
	public Main() {
		Game game = new Game(0);
		setVisible(true);
		add(game);
		setResizable(false);
		game.setGameFocus();
		pack();
		setSize(625, 650);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}