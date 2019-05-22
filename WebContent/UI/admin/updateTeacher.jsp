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
    <title>修改教师</title>
    <base href="<%=basePath%>">
  </head>
<body>
  <a href="findAllTeacher">返回教师列表</a><br>
	<form method="post" action="updateTeacher">
	  <table>
		<tr>
		  <th>项目名称</th>
		  <th>修改前</th>
   		  <th>修改后</th>
   		</tr>
   		<tr>
   		  <td>工号</td>
   		  <td><input type="text" value="${teaPojo.teacher_id }" readonly/></td>
   		  <td><input type="text" name="teacher_id" value="${teaPojo.teacher_id }" readonly/></td>
   		</tr>
   		<tr>
   		  <td>姓名</td>
   		  <td><input type="text" value="${teaPojo.teacher_name }" readonly/></td>
   		  <td><input type="text" name="teacher_name" value="${teaPojo.teacher_name }" required/></td>
   		</tr>
   		<tr>
   		  <td>密码</td>
   		  <td><input type="text" value="${teaPojo.teacher_password }" readonly/></td>
   		  <td><input type="text" name="teacher_password" value="${teaPojo.teacher_password }" required/></td>
   		</tr>
   		<tr>
   		  <td>性别</td>
   		  <td>${teaPojo.teacher_gender eq 1?"男":"女"}</td>
   		  <td><input type="text" name="teacher_gender" value="${teaPojo.teacher_gender eq 1?"1":"0"}" required/>
	   	  </td>
   		</tr>
   		<tr>
   		  <td>邮箱</td>
   		  <td><input type="text" value="${teaPojo.teacher_mail }" readonly/></td>
   		  <td><input type="text" name="teacher_mail" value="${teaPojo.teacher_mail }"/></td>
   		</tr>
   		<tr>
   		  <td>手机号</td>
   		  <td><input type="text" value="${teaPojo.teacher_tel }" readonly/></td>
   		  <td><input type="text" name="teacher_tel" value="${teaPojo.teacher_tel }" required/></td>
   		</tr>
	  </table>
		<input type="submit" value="确认修改" />
	</form>
</body>
</html>