<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>帮助信息</title>
		<base href="<%=basePath%>">
		 <!-- Bootstrap -->
	      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	这是一个帮助页面哦~
		<table align="center" class="table table-striped table-bordered">
			<tr align="center">
				<td>版本：123456</td>
			</tr>
			<tr align="center">
				<td>初始版：123456</td>
			</tr>
		</table>
	</body>
</html>