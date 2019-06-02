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
    <title>添加学生</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <h2>请输入学生信息!</h2><a href="findAllStudent">返回学生列表</a><br>
	<form method="post" action="addStudent">
		<table>
			<tr>
				<td>学号</td>
				<td><input type="text" name="student_id" required/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="student_name" required/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="student_password" required/></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="student_department" required/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
				  <input type="radio" name="student_gender" value="1" checked="checked">男
				  &nbsp;&nbsp;
				  <input type="radio" name="student_gender" value="0" >女
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="student_mail" /></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="text" name="student_tel" required/></td>
			</tr>
		</table>
		<input type="submit" value="添加" />&nbsp;<input type="reset" value="重填" /><br>
	</form>
</body>
</html>