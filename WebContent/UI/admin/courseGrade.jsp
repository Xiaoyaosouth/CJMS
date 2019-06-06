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
		<title>课程成绩信息</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
        <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
        <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	  <h3 style="color:red">${msg }</h3>
	  <input type="button" value="返回" target="_context" class="btn btn-default" 
  		     onclick="window.location.href='<%=basePath%>trySearchGradeByCourId'"/>
  	  <p>课程${courId }的成绩统计信息</p>
		<table align="center" class="table table-striped table-bordered">
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
		
	  <p>选修该课程的学生成绩信息</p>
		<table align="center" class="table table-striped table-bordered">
			<tr>
				<td>学号、姓名</td>
				<td>课程号</td>
				<td>课程</td>
				<td>教师姓名</td>
				<td>学分</td>
				<td>成绩</td>
			</tr>
			<c:forEach items="${listGrade}" var="grades">
				<tr>
					<td>${grades.grade_student}&nbsp;${grades.student.student_name}</td>
					<td>${grades.grade_course}</td>
					<td>${grades.course.course_name}</td>
					<td>${grades.course.teacher.teacher_name}</td>
					<td>${grades.course.course_credit}</td>
					<td>
					  ${grades.grade_fraction }&nbsp;&nbsp;
					  <input type="button" value="修改成绩" class="btn btn-warning" 
  		                     onclick="window.location.href='<%=basePath%>redirectView?id=${grades.grade_id}&role=gradeInCourPage'"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>