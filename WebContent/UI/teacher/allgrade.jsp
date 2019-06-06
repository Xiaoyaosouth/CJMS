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
		 <!-- Bootstrap -->
	      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<form action="insgrade" method="post">
			<table align="center" style="margin-top: 10px;"class="table table-striped table-bordered">
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
						<input type="submit"value="确认"  class="btn btn-warning" />
					</td>
				</tr>
				<tr align="center" >
					<td colspan="3">${msg}</td>
				</tr>
			</table>
		</form>
	</body>
</html>