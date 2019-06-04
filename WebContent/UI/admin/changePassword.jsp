<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
		<base href="<%=basePath%>">
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<form action="changeAdminPassword" method="post">
			<table align="center" border="1" style="margin-top: 120px;">
				<tr>
					<td>ID：</td>
					<td><input type="text" name="admin_id" value="${param.admId }" readonly /></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input type="password" name="newpwd" required/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="confirmpwd" required/></td>
				</tr>
				<tr align="center">
					<td colspan="2">
					  <input type="submit" value="修改" class="btn btn-warning"/>
						&nbsp;&nbsp;
					  <input type="button" value="返回" class="btn btn-default" 
  			                 onclick="window.location.href='UI/admin/person.jsp'"/>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<span id="mySpan">${msg}</span>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>