<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>选择班级</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<h4>教师课程管理功能说明：
		学生选修该教师的课程后，教师需要在这里将学生添加到课程中，才能录入成绩。</h4>
		<table align="center" class="table table-striped table-bordered">
			<tr>
				<td colspan="3">${msg}</td>
			</tr>
			<tr>
				<td>课程ID</td>
				<td>课程名</td>
				<td>选择</td>
			</tr>
			<c:forEach  items="${listCourse}" var="courses">
				<tr>
					<td>${courses.course_id}</td>
					<td>${courses.course_name}</td>
					<td><a href="addstudentfirst?courseid=${courses.course_id}" class="btn btn-warning" >添加学生</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>