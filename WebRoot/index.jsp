<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
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
  
  	<form action="user.html?arg=1" method="post" style="display:inline-block;">
  		用户名:<input type="text" name="username" />
  		密码　:<input type="password" name="password"/>
  		<input type="submit" name="submit" value="登录"/>
  	</form>
    <a href="userAdd.jsp" style="text-decoration:none;display:inline-block;color:#000;background:#ccc;margin-left:10px;border:1px solid #000;padding:2px 5px;">注册</a>
  </body>
</html>
