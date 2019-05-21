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
		<title>个人信息</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>账号：</td>
				<td>${admin.admin_id}</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>${admin.admin_name}(管理员)</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>${admin.admin_gender eq 1?"男":"女"}</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td>${admin.admin_mail}</td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>${admin.admin_tel}</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<a href="UI/admin/changePassword.jsp?admId=${admin.admin_id}" target="_context">修改密码</a>
				</td>
			</tr>
		</table>
	</body>
</html>
