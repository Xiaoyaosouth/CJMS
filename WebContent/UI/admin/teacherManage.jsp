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
		<title>教师管理</title>
		<base href="<%=basePath%>">
	</head>
	<body>
	<h3>${msg }</h3>
	<a href="UI/admin/addTeacher.jsp"><input type="button" value="添加教师" /></a><br>
	查询完成，共查询到&nbsp;${teaList.size() }&nbsp;条数据。<br>
	  <table border="1">
   		<tr>
   			<th>工号</th>
   			<th>姓名</th>
   			<th>密码</th>
   			<th>性别</th>
   			<th>邮箱</th>
   			<th>手机号</th>
   			<th>操作</th>
   		</tr>
   		<c:forEach var="teaPojo" items="${teaList }">
  		<tr>
  			<td>${teaPojo.teacher_id }</td>
  			<td>${teaPojo.teacher_name }</td>
  			<td>${teaPojo.teacher_password }</td>			
  			<td>				
  			  <c:choose>
	   			<c:when test="${teaPojo.teacher_gender == 1 }">
	   					男
	   			</c:when>
	   			<c:when test="${teaPojo.teacher_gender == 2 }">
	   					女
	   			</c:when>
	   			<c:otherwise>???</c:otherwise>
	   		  </c:choose>
	   		</td>
			<td>${teaPojo.teacher_mail }</td>
  			<td>${teaPojo.teacher_tel }</td>  			
  			<td><!-- 用超链接传值方式把id传给控制层 -->
			<a href="redirectView?id=${teaPojo.teacher_id }&role=teacher">修改</a> 
			<a href="deleteTeacher?teaId=${teaPojo.teacher_id }">删除</a>
			</td>
   		</tr>
   		</c:forEach> 
   	</table>
	</body>
</html>
