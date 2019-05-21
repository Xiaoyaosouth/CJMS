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
    <title>修改学生</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <a href="findAllStudent">返回学生列表</a><br>
	<form method="post" action="updateStudent">
	  <table>
		<tr>
		  <th>项目名称</th>
		  <th>修改前</th>
   		  <th>修改后</th>
   		</tr>
   		<tr>
   		  <td>学号</td>
   		  <td><input type="text" value="${stuPojo.student_id }" readonly/></td>
   		  <td><input type="text" name="student_id" value="${stuPojo.student_id }" readonly/></td>
   		</tr>
   		<tr>
   		  <td>姓名</td>
   		  <td><input type="text" value="${stuPojo.student_name }" readonly/></td>
   		  <td><input type="text" name="student_name" value="${stuPojo.student_name }" required/></td>
   		</tr>
   		<tr>
   		  <td>密码</td>
   		  <td><input type="text" value="${stuPojo.student_password }" readonly/></td>
   		  <td><input type="text" name="student_password" value="${stuPojo.student_password }" required/></td>
   		</tr>
   		<tr>
   		  <td>班级</td>
   		  <td><input type="text" value="${stuPojo.student_department }" readonly/></td>
   		  <td><input type="text" name="student_department" value="${stuPojo.student_department }" required/></td>
   		</tr>
   		<tr>
   		  <td>性别</td>
   		  <td>
   		    <c:choose>
	   		  <c:when test="${stuPojo.student_gender == 1 }">男</c:when>
	   		  <c:when test="${stuPojo.student_gender == 2 }">女</c:when>
	   		  <c:otherwise>???</c:otherwise>
	   		</c:choose>
	   	  </td>
   		  <td><input type="text" name="student_gender" required/>
	   	  </td>
   		</tr>
   		<tr>
   		  <td>邮箱</td>
   		  <td><input type="text" value="${stuPojo.student_mail }" readonly/></td>
   		  <td><input type="text" name="student_mail" value="${stuPojo.student_mail }"/></td>
   		</tr>
   		<tr>
   		  <td>手机号</td>
   		  <td><input type="text" value="${stuPojo.student_tel }" readonly/></td>
   		  <td><input type="text" name="student_tel" value="${stuPojo.student_tel }" required/></td>
   		</tr>
	  </table>
		<input type="submit" value="修改" />
	</form>
</body>
</html>