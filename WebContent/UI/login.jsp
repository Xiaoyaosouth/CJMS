<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生成绩管理系统</title>
	<base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
	<style type="text/css">
		body {
		  padding-top: 140px;
		  padding-bottom: 40px;
		  background-color: #eee;
		  background-image: url('img/bg.png');
		  background-repeat: no-repeat;
		}
		.form-signin {
		  max-width: 330px;
		  padding: 15px;
		  margin: 0 auto;
		}
	</style>
	
	<!-- 用JS由radio值来更改表单action -->
	<script type="text/javascript">     
        function submitForm()
        {  
        	var form = document.getElementById("myLoginForm"); // 由id获取表单
            var selectValue = $("input[name='userRadio']:checked").val(); // selectValue为radio中选中的值
            if(selectValue == 0){
            	form.action = "adminLogin";
            }else if(selectValue == 1){
            	form.action = "teacherLogin";
            }else if(selectValue == 2){
            	form.action = "studentLogin";
            }
            form.submit(); // 提交表单
        }  
    </script>

  </head>
  <body>
  	
    <div class="container">

      <form class="form-signin" action="" method="post" id="myLoginForm">
        <h2 class="form-signin-heading">欢迎登录！</h2>
        <input type="text"  name="userId" class="form-control"placeholder="证件号"  autofocus>
        <input type="password"  name="password" class="form-control" placeholder="密码" >
        <div class="radio">
          <label>
            <input type="radio" name="userRadio" value="0" checked="checked">
            	管理员
          </label>
          <label>
            <input type="radio" name="userRadio" value="1" >
            	教师
          </label>
          <label>
            <input type="radio" name="userRadio" value="2" >
            	学生
          </label>
        </div>
        <input class="btn btn-lg btn-primary btn-block"
               type="button" value="登录" onclick="submitForm()"/>
      </form>

    </div> <!-- /container -->

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="lib/jquery-3.3.1/jquery-3.3.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>