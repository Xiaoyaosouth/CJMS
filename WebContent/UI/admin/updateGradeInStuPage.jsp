<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	  <input type="button" value="返回" class="btn btn-default" 
  		     onclick="window.location.href='<%=basePath%>adminSearchGrade?id=${gradePojo.grade_student }&type=stu'"/>
	  <form action="adminUpdateStuGrade?backPage=stu" method="post" role="form">
	    <table class="table table-striped table-bordered">
	      <tr>
	        <th></th>
	        <th>值</th>
	      </tr>
	      <tr>
	        <td>学生ID</td>
	        <td>
	          <input type="text" name="grade_student" 
	                 value="${gradePojo.grade_student }" readonly required />
	        </td>
	      </tr>
	      <tr>
	        <td>学生姓名</td>
	        <td>${gradePojo.student.student_name }</td>
	      </tr>
	      <tr>
	        <td>课程ID</td>
	        <td>
	          <input type="text" name="grade_course" 
	                 value="${gradePojo.grade_course }" readonly required />
	        </td>
	      </tr>
	      <tr>
	        <td>课程名</td>
	        <td>${gradePojo.course.course_name }</td>
	      </tr>
	      <tr>
	        <td>学年、学期</td>
	        <td>
	          ${fn:substring(gradePojo.course.course_semester,0,4)}学年
	                    第${fn:substring(gradePojo.course.course_semester,4,5)}学期
	        </td>
	      </tr>
	      <tr>
	        <td>成绩ID</td>
	        <td>
	          <input type="text" name="grade_id" 
	                 value="${gradePojo.grade_id }" readonly required />
	        </td>
	      </tr>
	      <tr>
	        <td>成绩</td>
	        <td>
	          ${gradePojo.grade_fraction }&nbsp;&nbsp;【修改】
	          <input type="number" name="grade_fraction" min="0" max="100"
	                 value="${gradePojo.grade_fraction }" required />
	        </td>
	      </tr>
	    </table>
	    <input type="submit" value="修改" class="btn btn-warning"/>
	  </form>
	  
	</body>
</html>