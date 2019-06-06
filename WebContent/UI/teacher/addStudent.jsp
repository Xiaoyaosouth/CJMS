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
		<title>选择班级</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
	      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<form action="addstudent" method="post">
			<input type="hidden" name="courseid" value="${courseid}">
			<table align="center" border="1" style="margin-top: 120px;">
				<tr>
					<td align="left">
					学生名单：
					</td>
				</tr>
				<tr>
					<td>
					<input type="text" name="strdentStr"/>
					</td>
				</tr>
				<tr>
					<td>
					格式要求：<br/> 1.学号，学号，学号<br/> 2.使用英文逗号
					</td>
				</tr>
				<tr>
					<td align="center">
					<input type="submit" value="提交" class="btn btn-warning"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>