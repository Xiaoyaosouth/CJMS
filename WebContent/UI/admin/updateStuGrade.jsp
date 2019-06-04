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
		<title>修改学生成绩</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
        <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
        <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	  <input type="button" value="返回" target="_context" class="btn btn-default" 
  		     onclick="window.location.href='<%=basePath%>UI/admin/searchGrade.jsp'"/>
		
	  <p>修改所修课程的成绩信息</p>
	  
	</body>
</html>