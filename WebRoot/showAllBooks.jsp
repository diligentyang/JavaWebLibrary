<%@ page language="java" import="java.util.*,shiyan.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示所有图书信息</title>
    
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
  <% String error =(String)request.getAttribute("error"); 
   if(error!=null){ %>
   		<script>alert("提示:"+"<%=error%>")</script>
  <% } %> 
  <% String power=session.getAttribute("power").toString();%>
    	<table border=1>
    		<tr>
    			<td>图书名称</td>
    			<td>图书价格</td>
    			<td>图书作者</td>
    			<td>出版社</td>
    			<td>存放数量</td>
    			<td>操作</td>
    		</tr>
    		<%
    			List list = (List)request.getAttribute("booklist");
    			Book book = new Book();
    			for (int i = 0; i<list.size(); i++){
    				book = (Book) list.get(i);
    		 %>
    		 <tr>
    		 	<td><%=book.getName()%></td>
    		 	<td><%=book.getPrice()%></td>
    		 	<td><%=book.getAuthor()%></td>
    		 	<td><%=book.getBookConcern()%></td>
    		 	<td><%=book.getCounts()%></td>
    		 	<%if(power.equals("1")){ %>
    		 	<td><a href="bookshop.html?arg=3&&id=<%=book.getId()%>">删除</a>|<a href="bookshop.html?arg=4&&id=<%=book.getId()%>">修改</a></td>
    		 	<% } else { %>
    		 	<td><a href="user.html?arg=3&&id=<%=book.getId()%>">借阅</a></td>
    		 	<% } %>
    		 </tr>
    		 <% } %>
    		 <%if(power.equals("1")){ %>
    		 <tr><td><a href="saveBook.jsp">添加图书信息</a></td></tr>
    		 <% } %>
    	</table>
    	<a href="main.jsp">返回</a>
  </body>
</html>
