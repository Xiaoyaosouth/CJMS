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
		<table align="center" class="table table-striped table-bordered">
			<tr align="center">
				<td>团队协作：辉、铠</td>
			</tr>
			<tr align="center">
				<td>数据库设计：辉</td>
			</tr>
			<tr align="center">
				<td>SSM框架搭建：辉</td>
			</tr>
			<tr align="center">
				<td>版本：3.1(2019-07-11 16:24)</td>
			</tr>
		</table>
	</body>
</html>