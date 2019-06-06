<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生个人信息</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
	    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	    <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<table align="center" class="table table-striped table-bordered" style="margin-top: 10px;">
			<tr>
				<td>账号：</td>
				<td>${student.student_id}</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>${student.student_name}</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>${student.student_gender eq 1?"男":"女"}</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td>${student.student_mail}</td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>${student.student_tel}</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<a href="UI/student/changePassword.jsp" target="_context" class="btn btn-warning" >修改密码</a>
				</td>
			</tr>
		</table>
		<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
      <script src="lib/jquery-3.3.1/jquery-3.3.1.js"></script>
      <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	</body>
</html>
