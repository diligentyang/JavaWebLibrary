<%@ page language="java" import="java.util.*,shiyan.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'saveBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="bookshop.html?arg=5" method="post">
    <%
    			List list = (List)request.getAttribute("booklist");
    			Book book = new Book();
    			for (int i = 0; i<list.size(); i++){
    				book = (Book) list.get(i);
    		 %>
    	<table>
    		<tr>
    			<td>图书名称</td><td><input type="text" name="name" value="<%=book.getName()%>"/></td>
    		</tr>
    		<tr>
    			<td>图书价格</td><td><input type="text" name="price" value="<%=book.getPrice()%>"/></td>
    		</tr>
    		<tr>
    			<td>图书作者</td><td><input type="text" name="author" value="<%=book.getAuthor()%>"/></td>
    		</tr>
    		<tr>
    			<td>出版社：</td><td><input type="text" name="concern" value="<%=book.getBookConcern()%>"/></td>
    		</tr>
    		<tr>
    			<td>存放数量</td><td><input type="text" name="counts" value="<%=book.getCounts()%>"/></td>
    		</tr>
    		<input type="hidden" name="id" value="<%=book.getId()%>">
    		<tr><td><input type="submit" name="submit" value="提交"/></td></tr>
    	</table>
    	 <% } %>
    </form>
  </body>
</html>
