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
		<title>按key搜索成绩信息</title>
		<base href="<%=basePath%>">
		<!-- Bootstrap -->
      <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
      <link href="css/admin.css" rel="stylesheet">
	</head>
	<body>
		<form action="" method="post" id="myform">
			<table align="center"  style="margin-top: 120px;">
				<tr>
					<td>
						<input type="text" name="key"/>
					</td>
					<td>
						<input type="button" value="搜索" onclick="submitForm()"  class="btn btn-warning" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="selRadio" value="0" checked="checked"/>
						按课程号搜
					</td>
					<td>
						<input type="radio" name="selRadio" value="1" />
						按学号搜
					</td>
				</tr>
				<tr>
					<td colspan="2">
						${msg}
					</td>
				</tr>
			</table>
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
            	form.action = "searchstugrade";
            }
            form.submit(); // 提交表单
        }  
    </script>
</html>