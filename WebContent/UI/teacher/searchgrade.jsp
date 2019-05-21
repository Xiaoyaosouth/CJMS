<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form action="searchgrade" method="post">
			<table align="center" border="1" style="margin-top: 120px;">
				<tr>
					<td>
						<input type="text" name="key"/>
					</td>
					<td>
						<input type="submit" name="搜索"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						${msg}
					</td>
				</tr>
			</table>
		</form>
		
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>成绩</td>
			</tr>
			<c:forEach  items="${listGrade}" var="grades">
				<tr>
					<td>${grades.grade_student}</td>
					<td>${grades.student.student_name}</td>
					<td>${grades.grade_fraction}</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>