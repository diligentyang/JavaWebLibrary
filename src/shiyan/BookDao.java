package shiyan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.resource.cci.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BookDao {
	private Connection conn;
	
	public List findAllBooks(){
		conn = DBCon.getConnection();
		String listSQL = "select * from books";
		List list = new ArrayList();
		try{
			PreparedStatement psmt =  (PreparedStatement) conn.prepareStatement(listSQL);
			java.sql.ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getLong(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getDouble(3));
				book.setAuthor(rs.getString(4));
				book.setBookConcern(rs.getString(5));
				book.setCounts(rs.getInt(6));
				list.add(book);
			}
			conn.commit();
			return list;
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
		return list;
	}
	
	//保存图书信息
	public boolean saveuser(Book book) throws Exception{
		conn = DBCon.getConnection();
		String listSQL = "insert into books(name,price,author,bookConcern,counts) values(?,?,?,?,?)";
		java.sql.PreparedStatement pstmt =  conn.prepareStatement(listSQL);
		try{
			pstmt.setString(1, book.getName());
			pstmt.setDouble(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getBookConcern());
			pstmt.setInt(5, book.getCounts());
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
	
	public boolean delBook(int id){
		conn = DBCon.getConnection();
		String listSQL = "delete from books where id=?";
		
		try{
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement(listSQL);
			psmt.setInt(1,id);
			int num=psmt.executeUpdate();
			if(num!=0){
				conn.commit();
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
	
	public List findOneBook(int id){
		conn = DBCon.getConnection();
		String listSQL = "select * from books where id='"+id+"'";
		List list = new ArrayList();
		try{
			PreparedStatement psmt =  (PreparedStatement) conn.prepareStatement(listSQL);
			java.sql.ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getLong(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getDouble(3));
				book.setAuthor(rs.getString(4));
				book.setBookConcern(rs.getString(5));
				book.setCounts(rs.getInt(6));
				list.add(book);
			}
			conn.commit();
			return list;
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
		return list;
	}
	
	public boolean updateOneBook(Book book) throws Exception{
		conn = DBCon.getConnection();
		String listSQL = "update books set name=?,price=?,author=?,bookConcern=?,counts=? where id='"+book.getId()+"'";
		java.sql.PreparedStatement pstmt =  conn.prepareStatement(listSQL);
		try{
			pstmt.setString(1, book.getName());
			pstmt.setDouble(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getBookConcern());
			pstmt.setInt(5, book.getCounts());
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
	
	public List findUserBooks(String username){
		conn = DBCon.getConnection();
		String listSQL = "select borrow.*,books.name,books.bookConcern from borrow,books where borrow.username='"+username+"' and borrow.bookid=books.id order by borrow.id asc";
		List list = new ArrayList();
		try{
			PreparedStatement psmt =  (PreparedStatement) conn.prepareStatement(listSQL);
			java.sql.ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Borrowlist borrow = new Borrowlist();
				borrow.setId(rs.getInt(1));
				borrow.setUsername(rs.getString(2));
				borrow.setBookid(rs.getInt(3));
				borrow.setBookname(rs.getString(4));
				borrow.setBookconcern(rs.getString(5));
				list.add(borrow);
			}
			conn.commit();
			return list;
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
		return list;
	}
	
}
