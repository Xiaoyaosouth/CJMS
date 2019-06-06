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
		<!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<table align="center" class="table table-striped table-bordered" style="margin-top: 10px;">
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
