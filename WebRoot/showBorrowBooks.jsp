<%@ page language="java" import="java.util.*,shiyan.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showBorrowBooks.jsp' starting page</title>
    
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
    <table border=1>
    		<tr>
    			<td>用户名</td>
    			<td>借书名</td>
    			<td>书号</td>
    			<td>出版社</td>
    			<td>操作</td>
    		</tr>
    		<%
    			List list = (List)request.getAttribute("borrowlist");
    			Borrowlist borrowlist = new Borrowlist();
    			for (int i = 0; i<list.size(); i++){
    				borrowlist = (Borrowlist) list.get(i);
    		 %>
    		 <tr>
    		 	<td><%=borrowlist.getUsername()%></td>
    		 	<td><%=borrowlist.getBookname()%></td>
    		 	<td><%=borrowlist.getBookid()%></td>
    		 	<td><%=borrowlist.getBookconcern()%></td>
    		 	<td><a href="user.html?arg=5&&id=<%=borrowlist.getId()%>&&bookid=<%=borrowlist.getBookid()%>">还书</a></td>
   			</tr>
   			<% } %>
    	</table>
    	<a href="main.jsp">返回</a>
  </body>
</html>
