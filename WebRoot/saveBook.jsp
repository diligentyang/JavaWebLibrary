<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <form action="bookshop.html?arg=2" method="post">
    	<table>
    		<tr>
    			<td>图书名称</td><td><input type="text" name="name"/></td>
    		</tr>
    		<tr>
    			<td>图书价格</td><td><input type="text" name="price"/></td>
    		</tr>
    		<tr>
    			<td>图书作者</td><td><input type="text" name="author"/></td>
    		</tr>
    		<tr>
    			<td>出版社：</td><td><input type="text" name="concern"/></td>
    		</tr>
    		<tr>
    			<td>存放数量</td><td><input type="text" name="counts"/></td>
    		</tr>
    		<tr><td><input type="submit" name="submit" value="提交"/></td></tr>
    	</table>
    </form>
  </body>
</html>
