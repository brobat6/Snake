package snakeGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	public Main() {
        add(new Game());
        setResizable(false);
        pack();
        setTitle("Snake");
        setSize(620, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jf = new Main();
				jf.setVisible(true);
			}
		});
	}
}

//public class Main extends JFrame {
//	
//	Container cPane;
//	CardLayout card;
//	Game game;
//	GameOver gameOver;
//	
//	public Main() {
//        game = new Game();
//        gameOver = new GameOver();
//        cPane = getContentPane();
//        card = new CardLayout();
//        cPane.setLayout(card);
//        cPane.add("game", game);
//        cPane.add("gameOver", gameOver);
//        
//        setResizable(false);
//        pack();
//        setTitle("Snake");
//        setSize(620, 640);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//	}
//	public void actionPerformed(ActionEvent ae) {
//		if(game.isGameOver()) {
//			System.out.println("hfwoifhwioefhw");
//			card.show(cPane, "gameOver");
//		}
//	}
//	
//	public static void main(String args[]) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				JFrame jf = new Main();
//				jf.setVisible(true);
//			}
//		});
//	}
//}