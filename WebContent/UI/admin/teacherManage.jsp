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
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	  <h3>${msg }</h3>
	  <input type="button" value="添加教师"  class="btn btn-default" 
	         onclick="window.location.href='UI/admin/addTeacher.jsp'"/>
	  <p>查询完成，共查询到&nbsp;${teaList.size() }&nbsp;条数据。</p>
	  <table class="table table-striped table-bordered">
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
	   			<c:when test="${teaPojo.teacher_gender == 1 }">男</c:when>
	   			<c:when test="${teaPojo.teacher_gender == 0 }">女</c:when>
	   		  </c:choose>
	   		</td>
			<td>${teaPojo.teacher_mail }</td>
  			<td>${teaPojo.teacher_tel }</td>  			
  			<td>
  		      <input type="button" value="修改" class="btn btn-default" 
	                 onclick="window.location.href='redirectView?id=${teaPojo.teacher_id }&role=teacher'"/>
			  <input type="button" value="删除" class="btn btn-danger" 
	                 onclick="window.location.href='deleteTeacher?teaId=${teaPojo.teacher_id }'"/>
			</td>
   		</tr>
   		</c:forEach> 
   	</table>
	</body>
</html>
