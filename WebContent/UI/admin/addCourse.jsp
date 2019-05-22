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
    <title>添加课程</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <h3>${msg }</h3>
  <h2>请输入课程信息!</h2><a href="findAllCourse?semester=null">返回课程列表</a><br>
	<form method="post" action="addCourse">
		<table>
			<tr>
				<td>课程编号</td>
				<td><input type="text" name="course_id" value="${courseListSize +1 }" required/></td>
			</tr>
			<tr>
				<td>课程名称</td>
				<td><input type="text" name="course_name" value="测试课程名" required/></td>
			</tr>
			<tr>
				<td>任课教师ID</td>
				<td><input type="text" name="course_teacher" value="06160422" required/></td>
			</tr>
			<tr>
				<td>学分</td>
				<td><input type="text" name="course_credit" value="2" required/></td>
			</tr>
			<tr>
				<td>学期</td>
				<td><input type="text" name="course_semester" value="20192"
				           placeholder="格式：如20192,前4位表示学年,第5位表示学期" required/></td>
			</tr>
		</table>
		<input type="submit" value="确认添加" />&nbsp;&nbsp;<input type="reset" value="重填" /><br>
	</form>
</body>
</html>