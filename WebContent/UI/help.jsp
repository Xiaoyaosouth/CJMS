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
	</head>
	<body>
	这是一个帮助页面哦~
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>版本：</td>
			</tr>
			<tr>
				<td>初始版：</td>
			</tr>
		</table>
	</body>
</html>