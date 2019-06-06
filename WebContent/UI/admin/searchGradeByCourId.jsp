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
		<title>管理员按课程号查询成绩</title>
		<base href="<%=basePath%>">
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	<h3>${msg}</h3>
	<input type="button" value="返回首页" class="btn btn-default" 
  		   onclick="window.location.href='<%=basePath%>UI/admin/person.jsp'"/>
  		   
		<form action="adminSearchGrade?type=cour" method="post" role="form">
		  <div class="form-group">
	        <label class="control-label col-sm-2">请输入要查询的课程号：</label>
	        <div class="col-sm-10">
	          <input type="text" name="id" required 
	                 class="form-control" style="width:120px"/>
	        <span class="help-block">帮助文本块。</span>
	          <input type="submit" value="搜索" class="btn btn-default"/>
	        </div>
	      </div>
		</form>
		
		<p>以下是课程预览</p>
		<table class="table table-striped table-bordered">
   		  <tr>
   			<th>课程号</th>
   			<th>课程名</th>
   			<th>任课教师ID</th>
   			<th>学分</th>
   			<th>学年、学期</th>
   		  </tr>
   		  <c:forEach var="coursePojo" items="${courseList }">
  		  <tr>
  			<td>${coursePojo.course_id }</td>
  			<td>${coursePojo.course_name }</td>
  			<td>${coursePojo.course_teacher }</td>
  			<td>${coursePojo.course_credit }</td>
  			<td>${coursePojo.course_semester }</td>	
   		  </tr>
   		  </c:forEach> 
   	    </table>
	</body>
</html>