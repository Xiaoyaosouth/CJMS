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
		<title>课程成绩统计信息</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>课程总人数：</td>
				<td>平均成绩：</td>
				<td>最高分：</td>
				<td>最低分：</td>
				<td>优秀数：</td>
				<td>挂科数：</td>
			</tr>
			<tr>
				<td>${stuNum}</td>
				<td>${avg}</td>
				<td>${max}</td>
				<td>${min}</td>
				<td>${goodNum}</td>
				<td>${failNum}</td>
			</tr>
		</table>
	</body>
</html>
