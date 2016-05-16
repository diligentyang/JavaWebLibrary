<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userAdd.jsp' starting page</title>
    
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
    <form action="user.html?arg=2" method="post" name="fm" onsubmit="return check(this);">
    	<table>
    		<tr>
    			<td style="text-align:right;">用户名:</td><td><input type="text" name="username"/></td>
    		</tr>
    		<tr>
    			<td style="text-align:right;">密码:</td><td><input type="password" name="password1"/></td>
    		</tr>
    		<tr>
    			<td style="text-align:right;">确认密码:</td><td><input type="password" name="password2"/></td>
    		</tr>
    		<tr><td><input type="submit" name="submit" value="提交"/></td></tr>
    	</table>
    </form>
    <script>
    	function check(fm){
    		if(fm.username.value == "")   { 
				alert("请输入用户名!"); 
				fm.name.focus(); 
				return (false); 
			}
			if(fm.password1.value == "")   { 
				alert("请输入密码!"); 
				fm.password1.focus(); 
				return (false); 
			} 
			if(fm.password2.value == "")   { 
				alert("请再次输入密码!"); 
				fm.password2.focus(); 
				return (false); 
			} 
			if(fm.password1.value != fm.password2.value)   { 
				alert("两次密码输入不一致"); 
				fm.password2.focus(); 
				return (false); 
			}     
    	}
    </script>
  </body>
</html>
