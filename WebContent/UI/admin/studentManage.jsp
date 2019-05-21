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
		<title>学生管理</title>
		<base href="<%=basePath%>">
	</head>
	<body>
	<h3>${msg }</h3>
	<a href="UI/admin/addStudent.jsp"><input type="button" value="添加学生" /></a><br>
	查询完成，共查询到&nbsp;${stuList.size() }&nbsp;条数据。<br>
	  <table border="1">
   		<tr>
   			<th>学号</th>
   			<th>姓名</th>
   			<th>密码</th>
   			<th>班级</th>
   			<th>性别</th>
   			<th>邮箱</th>
   			<th>手机号</th>
   			<th>操作</th>
   		</tr>
   		<c:forEach var="stuPojo" items="${stuList }">
  		<tr>
  			<td>${stuPojo.student_id }</td>
  			<td>${stuPojo.student_name }</td>
  			<td>${stuPojo.student_password }</td>
  			<td>${stuPojo.student_department }</td> 			
  			<td>				
  			  <c:choose>
	   			<c:when test="${stuPojo.student_gender == 1 }">
	   					男
	   			</c:when>
	   			<c:when test="${stuPojo.student_gender == 2 }">
	   					女
	   			</c:when>
	   			<c:otherwise>???</c:otherwise>
	   		  </c:choose>
	   		</td>
			<td>${stuPojo.student_mail }</td>
  			<td>${stuPojo.student_tel }</td>  			
  			<td><!-- 用超链接传值方式把id传给控制层 -->
			<a href="updateStudent?stuId=${stuPojo.student_id }">修改</a> 
			<a href="deleteStudent?stuId=${stuPojo.student_id }">删除</a>	
			</td>
   		</tr>
   		</c:forEach> 
   	</table>
	</body>
</html>
