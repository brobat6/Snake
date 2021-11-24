package snakeGame;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main {
	
	static JFrame jf = new JFrame();
	
	static JPanel mainPagePanel = new JPanel();
	static JButton logInMain = new JButton("Log In");
	static JButton createAccount = new JButton("Create Account");
	
	static JPanel loginPagePanel = new JPanel();
	static JLabel userNameLogin = new JLabel("Enter Username");
	static JLabel passWordLogin = new JLabel("Enter Password");
	static JTextField fillUserNameLogin = new JTextField();
	static JPasswordField fillPassWordLogin = new JPasswordField();
	static JButton logIn = new JButton("Log In");
	
	static JPanel  createAccountPanel = new JPanel();
	static JLabel createUserName = new JLabel("Enter Username");
	static JLabel createPassWord = new JLabel("Enter Password");
	static JLabel rePassword = new JLabel("Re-Enter Password");
	static JTextField fillUserName = new JTextField();
	static JPasswordField fillPassWord = new JPasswordField();
	static JPasswordField fillRePassWord = new JPasswordField();
	static JButton submit = new JButton("Submit");
	
	static JPanel mainMenuPanel = new JPanel();
	static JButton play = new JButton("Play");
	static JButton viewHighscores = new JButton("View HighScores");
	static JButton logOut = new JButton("Logout");
	static JButton exit = new JButton("Exit");
	
	static JPanel setDifficultyPanel = new JPanel();
	static JLabel header = new JLabel("Set Difficulty");
	static JButton easy = new JButton("Easy");
	static JButton medium = new JButton("Medium");
	static JButton hard = new JButton("Hard");
	
	static JPanel highScoresPanel = new JPanel();
	
	static void mainPage() {
		
		mainPagePanel.setLayout(null);
		jf.add(mainPagePanel);
		
		logInMain.setBounds(230, 220, 160, 60);//295
//		logInMain.setFocusable(false);
		mainPagePanel.add(logInMain);
		logInMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPage();
				jf.remove(mainPagePanel);
				jf.revalidate();
			}
		});
		
		createAccount.setBounds(230, 310, 160, 60);
//		createAccount.setFocusable(false);
		mainPagePanel.add(createAccount);
		createAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createAccount();
				jf.remove(mainPagePanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void loginPage() {
		loginPagePanel.setVisible(true);
		loginPagePanel.setLayout(null);
		jf.add(loginPagePanel);
		
		userNameLogin.setBounds(100, 245, 100, 25);//295
		loginPagePanel.add(userNameLogin);
		
		
		passWordLogin.setBounds(100, 345, 100, 25);
		loginPagePanel.add(passWordLogin);
		
		fillUserNameLogin.setBounds(250, 245, 100, 25);//295
		loginPagePanel.add(fillUserNameLogin);
		
		
		fillPassWordLogin.setBounds(250, 345, 100, 25);
		loginPagePanel.add(fillPassWordLogin);
		
		logIn.setBounds(235, 400, 150, 50);//295
//		logIn.setFocusable(false);
		loginPagePanel.add(logIn);
		logIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu();
				jf.remove(loginPagePanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void createAccount() {
		
		createAccountPanel.setLayout(null);
		jf.add(createAccountPanel);
		
		createUserName.setBounds(100, 245, 100, 25);//295
		createAccountPanel.add(createUserName);
		
		createPassWord.setBounds(100, 345, 100, 25);
		createAccountPanel.add(createPassWord);
		
		rePassword.setBounds(100, 445, 100, 25);
		createAccountPanel.add(rePassword);
		
		
		fillUserName.setBounds(250, 245, 100, 25);//295
		createAccountPanel.add(fillUserName);
		
		fillPassWord.setBounds(250, 345, 100, 25);
		createAccountPanel.add(fillPassWord);
		
		
		fillRePassWord.setBounds(250, 445, 100, 25);
		createAccountPanel.add(fillRePassWord);
		
		
		submit.setBounds(235, 550, 150, 50);//295
//		submit.setFocusable(false);
		createAccountPanel.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu();
				jf.remove(createAccountPanel);
			}
		});
		////////////////////////////////////////////////
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void mainMenu() {
		
		mainMenuPanel.setLayout(null);
		jf.add(mainMenuPanel);
		
		play.setBounds(235, 245, 150, 50);//295
//		play.setFocusable(false);
		mainMenuPanel.add(play);
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = new Game();
				jf.remove(mainMenuPanel);
				jf.add(game);
				game.setGameFocus();
				jf.pack();
				jf.setSize(620, 640);
				jf.setVisible(true);
			}
		});
			
		viewHighscores.setBounds(235, 345, 150, 50);
//		viewHighscores.setFocusable(false);
		mainMenuPanel.add(viewHighscores);
		viewHighscores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				highScores();
				jf.remove(mainMenuPanel);
			}
		});
			
		logOut.setBounds(235, 445, 150, 50);//295
//		logOut.setFocusable(false);
		mainMenuPanel.add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.add(mainPagePanel);
				jf.remove(mainMenuPanel);
			}
		});
			
		exit.setBounds(235, 545, 150, 50);//295
//		exit.setFocusable(false);
		mainMenuPanel.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////////////////////////////
				jf.remove(mainMenuPanel);
			}
		});
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void setDifficulty() {
		
		setDifficultyPanel.setLayout(null);
		jf.add(setDifficultyPanel);
		
		header.setBounds(235, 145, 150, 50);//295
		setDifficultyPanel.add(header);
		
		easy.setBounds(235, 245, 150, 50);//295
		easy.setFocusable(false);
		setDifficultyPanel.add(easy);
		
		medium.setBounds(235, 345, 150, 50);
		medium.setFocusable(false);
		setDifficultyPanel.add(medium);
		
		hard.setBounds(235, 445, 150, 50);
		hard.setFocusable(false);
		setDifficultyPanel.add(hard);
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void highScores() {
		
		highScoresPanel.setLayout(null);
		jf.add(highScoresPanel);
		//ADD Snake Game at TOP
		//ADD our names at bottom
	}
	static void sql() throws Exception {
		String url = "jdbc:mysql://localhost:3306/__"; //database name
		String userName = "root";
		String passWord = "";
		String query = "";
		Class.forName("com.mysql.jbdc.driver");
		Connection connect = DriverManager.getConnection(url, userName, passWord);
		Statement state = connect.createStatement();
		ResultSet rs = state.executeQuery(query);
		
		rs.next();
		
		
		state.close();
		connect.close();
		
	}
	
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				jf.setVisible(true);
				jf.setLayout(new CardLayout());
				jf.setResizable(false);
		        jf.pack();
//		        jf.add(new Game());
		        jf.setTitle("Snake");
		        jf.setSize(620, 640);
		        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainPage();
			}
		});
	}

}