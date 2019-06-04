<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员查询成绩</title>
		<base href="<%=basePath%>">
	  <!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
	<h3>${msg}</h3>
		<form action="" method="post" id="myform" role="form">
		  <div class="form-group">
		    <label class="control-label col-sm-1">请选择：</label>
	        <label class="radio-inline">
	          <input type="radio" name="selRadio" value="0" checked>按课程号搜
	        </label>
	        <label class="radio-inline">
	          <input type="radio" name="selRadio" value="1" >按学号搜
	        </label>
	      </div>
		  <div class="form-group">
	        <label class="control-label col-sm-1">关键词：</label>
	        <div class="col-sm-11">
	          <input type="text" name="key" required 
	                 class="form-control" style="width:120px"/>
	        <span class="help-block">帮助文本块。</span>
	          <input type="button" value="搜索" onclick="submitForm()" 
	                 class="btn btn-default"/>
	        </div>
	      </div>
		</form>
	</body>
	<!-- 用JS由radio值来更改表单action -->
	<script type="text/javascript">     
        function submitForm()
        {  
        	var form = document.getElementById("myform"); // 由id获取表单
        	var radios=document.getElementsByName("selRadio");
            for(var i=0;i<radios.length;i++)
            {
                if(radios[i].checked==true)
                {
                    var selectValue=radios[i].value
                }
            }
            if(selectValue == 0){
            	form.action = "searchcoursegrade";
            }else if(selectValue == 1){
            	form.action = "adminSearchStuGrade";
            }
            form.submit(); // 提交表单
        }  
    </script>
</html>