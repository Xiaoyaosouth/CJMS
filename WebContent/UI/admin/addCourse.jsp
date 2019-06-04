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
    <title>添加课程</title>
    <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">
  </head>
<body>
  <input type="button" value="返回课程列表" target="_context" class="btn btn-default" 
  		 onclick="window.location.href='<%=basePath%>findAllCourse?semester=null'"/>
  <h3>${msg }</h3>
  <p>请输入要的添加的课程信息</p>
	<form method="post" action="addCourse" role="form">
	
	  <div class="form-group">
	    <label for="course_id" class="control-label col-sm-1">课程编号</label>
	    <div class="col-sm-11">
	    <input type="text" id="course_id" name="course_id" 
	           value="${courseListSize +1 }" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="course_name" class="col-sm-1 control-label">课程名称</label>
	    <div class="col-sm-11">
	    <input type="text" id="course_name" name="course_name" required 
	           class="form-control" style="width:330px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="course_teacher" class="control-label col-sm-1">任课教师ID</label>
	    <div class="col-sm-11">
	    <input type="text" id="course_teacher" name="course_teacher" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="course_credit" class="control-label col-sm-1">学分</label>
	    <div class="col-sm-11">
	    <input type="text" id="course_credit" name="course_credit" required 
	           class="form-control" style="width:120px"/>
	    <span class="help-block">帮助文本块。</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="course_semester" class="control-label col-sm-1">学期</label>
	    <div class="col-sm-11">
	    <input type="text" id="course_semester" name="course_semester" required 
	           class="form-control" style="width:120px"
	           placeholder="请输入学期" />
	    <span class="help-block">格式：如20192,前4位表示学年,第5位表示学期</span>
	    </div>
	  </div>
	  <input type="submit" value="添加"  class="btn btn-default"/>
	  &nbsp;
	  <input type="reset" value="重填"  class="btn btn-default"/>
	</form>
</body>
</html>