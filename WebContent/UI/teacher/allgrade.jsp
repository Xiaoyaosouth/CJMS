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
		<title>录入成绩</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<form action="insgrade" method="post">
			<table align="center" border="1" style="margin-top: 120px;">
				<tr>
					<td>学号</td>
					<td>姓名</td>
					<td>分数</td>
				</tr>
				<c:forEach  items="${listGrade}" var="grades">
					<tr>
						<td>${grades.grade_student}</td>
						<td>${grades.student.student_name}</td>
						<td>
							<input type="hidden" name="gradeid" value="${grades.grade_id}"/>
							<input type="text" name="fraction"/>
						</td>
					</tr>
				</c:forEach>
				<tr align="center" >
					<td colspan="3">
						<input type="submit"value="确认"/>
					</td>
				</tr>
				<tr align="center" >
					<td colspan="3">${msg}</td>
				</tr>
			</table>
		</form>
	</body>
</html>