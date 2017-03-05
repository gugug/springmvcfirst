<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<script type="text/javascript" src="../public/javascript/jquery-2.1.1.js"></script>   
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<title>Insert title here</title>  
<script type="text/javascript">  
    function ajaxTest(){  
        $.ajax({  
        data:"name="+$("#name").val(),  //要发送的数据
        type:"GET",  //使用GET方法访问后台
        dataType: 'json',  //返回json格式的数据  可选XML ,Json jsonp script html text等
        //cache: false,  
        async: false,
        /*
      	  对于此方法调用之后会一直返回undefined，原因是Jquery的ajax是异步的，所以大多时候没执行完AJAX就return htmlcontent了，所以会一直返回undefined, 
	解决方法：添加async: false,即修改此方法为同步
        */
        url:"${pageContext.request.contextPath }/user/login.action",  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data.msg);  
        },  
        success:function(data){  
            alert("success:"+data.msg);
            $("#result").html("");
            $("#result").html(data.msg) ;  
            $("#result").append("qewew");
        }  
        });  
    }  
</script>  
</head>  
<body>  
    <input type="text" name="name" id="name"/>  
    <input type="submit" value="登录" onclick="ajaxTest();"/>  
    <div id="result"></div>  
</body>  
</html> 