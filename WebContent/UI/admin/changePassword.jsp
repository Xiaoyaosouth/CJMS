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
		<title>修改密码</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<form action="changeAdminPassword" method="post">
			<table align="center" border="1" style="margin-top: 120px;">
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
						<input type="submit" value="确认">
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<span>${msg}</span>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>