<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN" style="height: 100%;">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生成绩管理系统</title>
	<base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">

  </head>
  <body>
  	<!--头部-->
  	<header class="admin_header">
  		<!--导航条-->
		<nav class="navbar navbar-inverse" style="border-radius: 0;">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="UI/admin/person.jsp" target="_context" style="color: #FFF;">学生成绩管理系统</a>
		    </div>
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav verticalline">
		        <li ><a href="UI/admin/person.jsp" target="_context">个人信息<span class="sr-only">(current)</span></a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户管理<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="findAllTeacher" target="_context">教师管理</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="findAllStudent" target="_context">学生管理</a></li>
		            <li role="separator" class="divider"></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">课程管理<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="findAllCourse?semester=null" target="_context">查看课程</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="tryAddCourse" target="_context">添加课程</a></li>
		            <li role="separator" class="divider"></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">成绩管理<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="UI/admin/searchGradeByStuId.jsp" target="_context">按学号查询</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="trySearchGradeByCourId" target="_context">按课程号查询</a></li>
		            <li role="separator" class="divider"></li>
		          </ul>
		        </li>
		        <li><a href="help?role=admin" target="_context">帮助<span class="sr-only">(current)</span></a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="logout" target="_top">退出系统</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
  	</header>
  	
  	<!--内容-->
		<iframe  name="_context" class="admin_content" src="UI/admin/person.jsp"
			 marginheight="0px" marginwidth="0px" width="100%"frameborder="0">
		</iframe>
  	
  	
  	<!--底部-->
	<footer class="footer text-muted admin_footer">
	    <div class="container " style="text-align: center;">
	    	<h5 >***学生成绩管理系统--管理员在线***</h5>
	    </div>
	</footer>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="lib/jquery-3.3.1/jquery-3.3.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>