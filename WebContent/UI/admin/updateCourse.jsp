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
    <title>修改课程</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <a href="findAllCourse">返回课程列表</a><br>
	<form method="post" action="updateCourse">
	  <table>
		<tr>
		  <th>项目名称</th>
		  <th>修改前</th>
   		  <th>修改后</th>
   		</tr>
   		<tr>
   		  <td>课程编号</td>
   		  <td><input type="text" value="${coursePojo.course_id }" readonly/></td>
   		  <td><input type="text" name="course_id" value="${coursePojo.course_id }" readonly/></td>
   		</tr>
   		<tr>
   		  <td>课程名称</td>
   		  <td><input type="text" value="${coursePojo.course_name }" readonly/></td>
   		  <td><input type="text" name="course_name" value="${coursePojo.course_name }" required/></td>
   		</tr>
   		<tr>
   		  <td>任课教师</td>
   		  <td><input type="text" value="${coursePojo.course_teacher }" readonly/></td>
   		  <td><input type="text" name="course_teacher" value="${coursePojo.course_teacher }" required/></td>
   		</tr>
   		<tr>
   		  <td>学分</td>
   		  <td><input type="text" value="${coursePojo.course_credit }" readonly/></td>
   		  <td><input type="text" name="course_credit" value="${coursePojo.course_credit }" required/>
	   	  </td>
   		</tr>
   		<tr>
   		  <td>学期</td>
   		  <td><input type="text" value="${coursePojo.course_semester }" readonly/></td>
   		  <td><input type="text" name="course_semester" value="${coursePojo.course_semester }" required/></td>
   		</tr>
   		<tr>
   		  <td>?成绩录入完成?</td>
   		  <td><input type="text" value="${coursePojo.is_done }" readonly/></td>
   		  <td><input type="text" name="is_done" value="${coursePojo.is_done }" required/></td>
   		</tr>
	  </table>
		<input type="submit" value="修改" />
	</form>
</body>
</html>