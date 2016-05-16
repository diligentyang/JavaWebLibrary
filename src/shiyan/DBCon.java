package shiyan;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBCon {
	public static Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/book_shop";
		String user="root";
		String pwd="905407339";
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			conn = (Connection) DriverManager.getConnection(url,user,pwd);
			conn.setAutoCommit(false);
			return conn;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
