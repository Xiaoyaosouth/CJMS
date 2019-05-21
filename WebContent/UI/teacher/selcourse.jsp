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
	</head>
	<body>
	
		<table align="center" border="1" style="margin-top: 120px;">
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
					<td><a href="selgrade?courseid=${courses.course_id}">录入此课程</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>