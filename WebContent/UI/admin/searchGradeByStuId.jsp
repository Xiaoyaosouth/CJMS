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
		<title>管理员按学号查询成绩</title>
		<base href="<%=basePath%>">
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	<h3>${msg}</h3>
	<input type="button" value="返回首页" class="btn btn-default" 
  		   onclick="window.location.href='<%=basePath%>UI/admin/person.jsp'"/>
  		   
		<form action="adminSearchGrade?type=stu" method="post" role="form">
		  <div class="form-group">
	        <label class="control-label col-sm-2">请输入要查询的学号：</label>
	        <div class="col-sm-4">
	          <input type="text" name="id" required 
	                 class="form-control" style="width:120px"/>
	        <span class="help-block">帮助文本块。</span>
	          <input type="submit" value="搜索" class="btn btn-default"/>
	        </div>
	      </div>
		</form>
	</body>
</html>