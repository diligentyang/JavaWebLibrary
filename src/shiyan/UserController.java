package shiyan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
			this.userLogin(request,response);
			break;
		case 2:
			this.addUser(request,response);
			break;
		case 3:
			this.borrowBook(request,response);
			break;
		case 4:
			this.showUserBorrow(request,response);
			break;
		case 5:
			this.returnBook(request,response);
			break;
		}
	}
	
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String password = new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
		User user= new User();
		if(user.checkUser(username, password)){
			int power = user.getPower(username);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("power", power);
			RequestDispatcher rdt = request.getRequestDispatcher("main.jsp");
			rdt.forward(request,response);
		}else{
			request.setAttribute("error","用户名或密码错误");
			RequestDispatcher rdt = request.getRequestDispatcher("index.jsp");
			rdt.forward(request,response);
		}
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String password = new String(request.getParameter("password1").getBytes("iso-8859-1"),"utf-8");
		User user = new User();
		try {
			user.addUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("error","注册成功请登录!");
		RequestDispatcher rdt = request.getRequestDispatcher("index.jsp");
		rdt.forward(request,response);
	}
	
	public void borrowBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String username=session.getAttribute("username").toString();
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		try {
			user.borrowBook(username,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("error","借阅成功！");
		RequestDispatcher rdt = request.getRequestDispatcher("bookshop.html?arg=1");
		rdt.forward(request,response);
	}
	
	public void showUserBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		HttpSession session = request.getSession();
		String username=session.getAttribute("username").toString();
		List list =  bookDao.findUserBooks(username);
		request.setAttribute("borrowlist",list);
		RequestDispatcher rdt = request.getRequestDispatcher("showBorrowBooks.jsp");
		rdt.forward(request,response);
	}
	
	public void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		User user = new User();
		try {
			user.returnBook(bookid, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.showUserBorrow(request, response);
		
	}

}
