package shiyan;

public class Borrowlist {
	private int id;
	private String username;
	private int bookid;
	private String bookname;
	private String bookconcern;
	public Borrowlist(){}
	public int getId()
	{
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String name){
		this.username=name;
	}
	
	public void setBookid(int bookid){
		this.bookid=bookid;
	}
	
	public int getBookid(){
		return bookid;
	}
	
	public void setBookname(String bookname){
		this.bookname=bookname;
	}
	
	public String getBookname(){
		return bookname;
	}
	
	public void setBookconcern(String bookconcern){
		this.bookconcern=bookconcern;
	}
	
	public String getBookconcern(){
		return bookconcern;
	}
	
}
