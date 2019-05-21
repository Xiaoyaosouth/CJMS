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
    <title>添加教师</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <h2>请输入教师信息!</h2><a href="findAllTeacher">返回教师列表</a><br>
	<form method="post" action="addTeacher">
		<table>
			<tr>
				<td>工号</td>
				<td><input type="text" name="teacher_id" value="04160908" required/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="teacher_name" value="逍遥" required/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="teacher_password" value="123456" required/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="teacher_gender" value="1" required/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="teacher_mail" value="626753724@qq.com" required/></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="text" name="teacher_tel" value="13750002413" required/></td>
			</tr>
		</table>
		<input type="submit" value="添加" />&nbsp;<input type="reset" value="重填" /><br>
	</form>
</body>
</html>