package shiyan;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int arg = Integer.parseInt(request.getParameter("arg"));
		switch(arg){
		case 1:
			this.findAllBooks(request,response);
			break;
		case 2:
			this.saveBooks(request,response);
			break;
		case 3:
			this.delBooks(request,response);
			break;
		case 4:
			this.showBookDetails(request,response);
			break;
		case 5:
			this.updateOneBook(request,response);
			break;
		}
	}
	
	public void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		List list =  bookDao.findAllBooks();
		request.setAttribute("booklist",list);
		RequestDispatcher rdt = request.getRequestDispatcher("showAllBooks.jsp");
		rdt.forward(request,response);
	}
	
	public void saveBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		double price = 0.0;
		if(!request.getParameter("price").equals("")&&request.getParameter("price")!=null)
			price = Double.parseDouble(request.getParameter("price"));
		String author =  new String( request.getParameter("author").getBytes("iso-8859-1"),"utf-8");
		String bookConcern = new String( request.getParameter("concern").getBytes("iso-8859-1"),"utf-8");
		int counts = 0;
		if(!request.getParameter("counts").equals("")&&request.getParameter("counts")!=null)
			counts = Integer.parseInt(request.getParameter("counts"));
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setBookConcern(bookConcern);
		book.setPrice(price);
		book.setCounts(counts);
		BookDao bookDao = new BookDao();
		try{
			bookDao.saveuser(book);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.findAllBooks(request, response);
	}
	
	public void delBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookDao book =new BookDao();
		if(book.delBook(id)){
			this.findAllBooks(request, response);
		}
	}
	
	public void showBookDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookDao bookDao = new BookDao();
		List list =  bookDao.findOneBook(id);
		request.setAttribute("booklist",list);
		RequestDispatcher rdt = request.getRequestDispatcher("showOneBook.jsp");
		rdt.forward(request,response);
	}
	
	public void updateOneBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		double price = 0.0;
		if(!request.getParameter("price").equals("")&&request.getParameter("price")!=null)
			price = Double.parseDouble(request.getParameter("price"));
		String author =  new String( request.getParameter("author").getBytes("iso-8859-1"),"utf-8");
		String bookConcern = new String( request.getParameter("concern").getBytes("iso-8859-1"),"utf-8");
		int counts = 0;
		if(!request.getParameter("counts").equals("")&&request.getParameter("counts")!=null)
			counts = Integer.parseInt(request.getParameter("counts"));
		long id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setBookConcern(bookConcern);
		book.setPrice(price);
		book.setCounts(counts);
		book.setId(id);
		BookDao bookDao = new BookDao();
		try{
			bookDao.updateOneBook(book);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.findAllBooks(request, response);
	}

}
