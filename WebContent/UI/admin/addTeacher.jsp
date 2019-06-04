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
    <title>添加教师</title>
    <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">
  </head>
<body>
  <input type="button" value="返回教师列表" target="_context" class="btn btn-default" 
  		 onclick="window.location.href='<%=basePath%>findAllTeacher'"/>
  <p>请输入要添加的教师信息</p>
	<form method="post" action="addTeacher" role="form">
	  <div class="form-group">
	    <label for="teacher_id" class="control-label col-sm-1">工号</label>
	    <div class="col-sm-11">
	    <input type="text" id="teacher_id" name="teacher_id" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacher_name" class="col-sm-1 control-label">姓名</label>
	    <div class="col-sm-11">
	    <input type="text" id="teacher_name" name="teacher_name" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacher_password" class="col-sm-1 control-label">密码</label>
	    <div class="col-sm-11">
	    <input type="text" id="teacher_password" name="teacher_password" required 
	           class="form-control" style="width:200px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	   <label class="col-sm-1 control-label">性别</label>
	   <label class="radio-inline">
	     <input type="radio" name="teacher_gender" value="1" checked>男
	   </label>
	   <label class="radio-inline">
	     <input type="radio" name="teacher_gender" value="0" >女
	   </label>
	  </div>
	  <div class="form-group">
	    <label for="teacher_mail" class="col-sm-1 control-label">邮箱</label>
	    <div class="col-sm-11">
	    <input type="text" id="teacher_mail" name="teacher_mail"
	           class="form-control" style="width:330px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacher_tel" class="col-sm-1 control-label">手机号</label>
	    <div class="col-sm-11">
	    <input type="text" id="teacher_tel" name="teacher_tel" required 
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