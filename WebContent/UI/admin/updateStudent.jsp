<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>修改学生</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <a href="findAllStudent">返回学生列表</a><br>
	<form method="post" action="updateStudent">
		<table>
			<tr>
				<td>学号</td>
				<td><input type="text" name="student_id" value="04160908" required/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="student_name" value="逍遥" required/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="student_password" value="123456" required/></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="student_department" value="041609" required/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="student_gender" value="1" required/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="student_mail" value="626753724@qq.com" required/></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="text" name="student_tel" value="13750002413" required/></td>
			</tr>
		</table>
		<input type="submit" value="添加" />&nbsp;<input type="reset" value="重填" /><br>
	</form>
</body>
</html>