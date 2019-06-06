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
		<title>修改教师密码</title>
		<base href="<%=basePath%>">
		 <!-- Bootstrap -->
	      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<form action="changeteacherpwd" method="post">
			<table align="center" style="margin-top: 120px;">
				<tr>
					<td>新密码：</td>
					<td><input type="password" name="newpwd"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="confirmpwd"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<span>${msg}</span>
					</td>
				</tr>
				<tr align="center" style="margin-top: 10px;">
					<td colspan="2">
						<input type="submit" value="确认" class="btn btn-warning">
						&nbsp;&nbsp;
					  <input type="button" value="返回" class="btn btn-default" 
  			                 onclick="window.location.href='UI/teacher/person.jsp'"/>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>