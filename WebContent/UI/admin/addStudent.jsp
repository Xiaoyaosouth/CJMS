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
    <title>添加学生</title>
    <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">
  </head>
<body>
  <input type="button" value="返回学生列表" target="_context" class="btn btn-default" 
  		onclick="window.location.href='<%=basePath%>findAllStudent'"/>
  <p>请输入要添加的学生信息</p>
	<form method="post" action="addStudent" role="form">
	  <div class="form-group">
	    <label for="student_id" class="control-label col-sm-1">学号</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_id" name="student_id" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="student_name" class="col-sm-1 control-label">姓名</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_name" name="student_name" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="student_password" class="col-sm-1 control-label">密码</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_password" name="student_password" required 
	           class="form-control" style="width:200px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="student_department" class="col-sm-1 control-label">班级</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_department" name="student_department" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	   <label class="col-sm-1 control-label">性别</label>
	   <label class="radio-inline">
	     <input type="radio" name="student_gender" value="1" checked>男
	   </label>
	   <label class="radio-inline">
	     <input type="radio" name="student_gender" value="0" >女
	   </label>
	  </div>
	  <div class="form-group">
	    <label for="student_mail" class="col-sm-1 control-label">邮箱</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_mail" name="student_mail"
	           class="form-control" style="width:330px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="student_tel" class="col-sm-1 control-label">手机号</label>
	    <div class="col-sm-11">
	    <input type="text" id="student_tel" name="student_tel" required 
	           class="form-control" style="width:200px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <input type="submit" value="添加"  class="btn btn-default"/>
	  &nbsp;
	  <input type="reset" value="重填"  class="btn btn-default"/>
	</form>
</body>
</html>