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
		<title>学生成绩统计信息</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>平均成绩</td>
				<td>平均绩点</td>
				<td>已修学分</td>
				<td>已修课程</td>
				<td>挂科数</td>
			</tr>
			<tr>
				<td>${avg}</td>
				<td>${avgpot}</td>
				<td>${cridit}</td>
				<td>${courseNum}</td>
				<td>${fileNum}</td>
			</tr>
		</table>
		
		
	</body>
</html>
