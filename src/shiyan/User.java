package shiyan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class User {
private Connection conn;
	
	public boolean checkUser(String username,String password){
		conn = DBCon.getConnection();
		String listSQL = "select * from user where username='"+username+"' and password= '"+password+"'";
		
		try{
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement(listSQL);
			java.sql.ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				return true;
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public int getPower(String username){
		conn = DBCon.getConnection();
		int power = 0;
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from user where username='" + username + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				power = rs.getInt("power");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return power;
	}
	
	public boolean addUser(String username,String password) throws SQLException{
		conn = DBCon.getConnection();
		String listSQL = "insert into user(username,password) values(?,?)";
		java.sql.PreparedStatement pstmt =  conn.prepareStatement(listSQL);
		try{
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
			conn.commit();
		}catch (SQLException e){
			conn.rollback();
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return false;
	}
	
	public boolean borrowBook(String username,int id) throws SQLException{
		conn = DBCon.getConnection();
		String listSQL = "insert into borrow(username,bookid) values(?,?)";
		java.sql.PreparedStatement pstmt =  conn.prepareStatement(listSQL);
		try{
			pstmt.setString(1, username);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			conn.commit();
		}catch (SQLException e){
			conn.rollback();
			e.printStackTrace();
		}
		String sql = "update books set counts = counts-1  where id='" + id + "'";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
		return false;
	}
	
	public boolean returnBook(int bookid,int id) throws SQLException{
		conn = DBCon.getConnection();
		String listSQL = "update books set counts=counts+1 where id=?";
		
		try{
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement(listSQL);
			psmt.setInt(1,bookid);
			int num=psmt.executeUpdate();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		String listSQL1 = "delete from borrow where id=?";
		try{
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement(listSQL1);
			psmt.setInt(1,id);
			int num=psmt.executeUpdate();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
