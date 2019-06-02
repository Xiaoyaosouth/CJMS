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
		<form action="changeAdminPassword" method="post" id="myChangePwdForm">
			<table align="center" border="1" style="margin-top: 120px;">
				<tr>
					<td>ID：</td>
					<td><input type="text" name="admin_id" value="${param.admId }" readonly /></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input type="password" name="newpwd" required/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="confirmpwd" required/></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="修改"/>
						&nbsp;&nbsp;<a href="UI/admin/person.jsp">返回</a>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<span id="mySpan">${msg}</span>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>