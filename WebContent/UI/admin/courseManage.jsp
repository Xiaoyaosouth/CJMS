<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>课程管理</title>
		<base href="<%=basePath%>">
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	  <h3>${msg }</h3>
	  <input type="button" value="添加课程"  class="btn btn-default" 
	         onclick="window.location.href='<%=basePath%>tryAddCourse'"/>
	
	<form action="findAllCourse" method="post">
	<!-- 先从数据库抓取所有学期，让用户选择 -->
	选择学期：<select id="mySelect" name="semester">
	  <c:forEach var="semester" items="${semesterList }">
	    <option value="${semester }">${semester }</option>
	  </c:forEach>
	</select>
	<input type="submit" value="显示课程"/><br><br>
	</form>
	
	<p>查询完成，共查询到&nbsp;${courseList.size() }&nbsp;条数据。</p>
	  <table class="table table-striped table-bordered">
   		<tr>
   			<th>课程编号</th>
   			<th>课程名</th>
   			<th>任课教师</th>
   			<th>学分</th>
   			<th>学期</th>
   			<th>是否录入完成</th>
   			<th>操作</th>
   		</tr>
   		<c:forEach var="coursePojo" items="${courseList }">
  		<tr>
  			<td>${coursePojo.course_id }</td>
  			<td>${coursePojo.course_name }</td>
  			<td>${coursePojo.course_teacher }</td>
  			<td>${coursePojo.course_credit }</td>
  			<td>${coursePojo.course_semester }</td>	
  			<td>${coursePojo.is_done eq true?"是":"否"}</td>
  			<td>
  			  <input type="button" value="修改" class="btn btn-default" 
	                 onclick="window.location.href='redirectView?id=${coursePojo.course_id }&role=course'"/>
	          <input type="button" value="删除" class="btn btn-default" 
	                 onclick="window.location.href='deleteCourse?courseId=${coursePojo.course_id }'"/>
			</td>
   		</tr>
   		</c:forEach> 
   	</table>
	</body>
</html>
