package snakeGame;

import java.sql.*;

public class DataBase{
	static Connection connect;
	static Statement state;
	static ResultSet rset;
	static String query;
	static String userNamePlayer;
	
	
	///////////////////////SPECIFY TYPE OF EXCEPTION
	
	public DataBase() {
		
	}
	static void buildConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/first"; //database name
		String userName = "root";
		String passWord = "utkarshmarker";//////////////////////////
		Class.forName("com.mysql.cj.jdbc.Driver"); //do we have to register everytime ?
		connect = DriverManager.getConnection(url, userName, passWord);
		state = connect.createStatement();
	}
	static Boolean checkUserNameAlreadyExists(String userNameCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT userNameUser "
				+ "  FROM dataBaseSnakeGame"
				+ "  WHERE userNameUser = '" + userNameCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	static Boolean verifyUserNamePassWord(String userNameCheck, String passWordCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT userNameUser"
				+ "  FROM dataBaseSnakeGame"
				+ "  WHERE userNameUser = '" + userNameCheck + "' AND"
				+ "  passWordUser = '" + passWordCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	static void addNewUserToDataBase(String userNameToAdd, String passWordToAdd) throws Exception {
		query = "INSERT INTO dataBaseSnakeGame(userNameUser, passWordUser) VALUES('" + userNameToAdd + "', '" + passWordToAdd + "');";
		state.executeUpdate(query);
	}
	static void makeQuery(String dataBaseQuery) throws Exception {
		rset = state.executeQuery(dataBaseQuery);
		rset.next();
		String name = rset.getString(1);
		
		System.out.println(name);
	}
	static void close() throws Exception{
		connect.close();
		state.close();
	}
}
