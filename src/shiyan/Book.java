package shiyan;

public class Book {
	private Long id;
	private String name;
	private double price;
	private String author;
	private String bookConcern;
	private int counts;
	public Book(){}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author=author;
	}
	
	public String getBookConcern(){
		return bookConcern;
	}
	
	public void setBookConcern(String bookConcern){
		this.bookConcern=bookConcern;
	}
	
	public int getCounts(){
		return counts;
	}
	public void setCounts(int counts){
		this.counts=counts;
	}
	

}
