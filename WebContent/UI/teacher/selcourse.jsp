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
		<title>选择班级录入成绩</title>
		<base href="<%=basePath%>">
		 <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	
		<table align="center" class="table table-striped table-bordered" style="margin-top: 10px;">
			<tr>
				<td colspan="3">${msg}</td>
			</tr>
			<tr>
				<td>课程ID</td>
				<td>课程名</td>
				<td>选择</td>
			</tr>
			<c:forEach  items="${listcourse}" var="courses">
				<tr>
					<td>${courses.course_id}</td>
					<td>${courses.course_name}</td>
					<td><a href="selgrade?courseid=${courses.course_id}" class="btn btn-warning" >录入此课程</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>