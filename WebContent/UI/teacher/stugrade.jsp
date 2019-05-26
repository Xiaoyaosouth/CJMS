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
		<title>学生成绩信息</title>
		<base href="<%=basePath%>">
	</head>
	<body>
		<table align="center" border="1" style="margin-top: 120px;">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>课程号</td>
				<td>课程</td>
				<td>教师姓名</td>
				<td>成绩</td>
			</tr>
			<c:forEach  items="${listGrade}" var="grades">
				<tr>
					<td>${grades.grade_student}</td>
					<td>${grades.student.student_name}</td>
					<td>${grades.grade_fraction}</td>
				</tr>
			</c:forEach>
		</table>
		
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
            	form.action = "searchstugrade";
            }else if(selectValue == 1){
            	form.action = "searchcoursegrade";
            }
            form.submit(); // 提交表单
        }  
    </script>
</html>