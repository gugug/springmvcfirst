<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/public/javascript/jquery-2.1.1.min.js">  
</script>  
<script type="text/javascript">  

//请求的是json，输出json
function requestJson() {  
    $.ajax({
    	type:'post',
    	url:'${pageContext.request.contextPath }/requestJson.action',
    	contentType:'application/json;charset=utf-8',
    	//数据格式是json串, 专辑信息
    	data:'{"album_name":"爱你一万年","singer":"张国荣"}',
    	success:function(data){
    		//返回json 结果
    		alert(data.album_name);
    	}
    });  
}  

//请求的是key/value，输出json
function responseJson() {  
    $.ajax( {  
    	type:'post',
    	url:'${pageContext.request.contextPath }/responseJson.action',
    	//请求key/value这里不需要指定contentType，因为默认就是key/value类型
    	//contentType:'application/json;charset=utf-8',
    	//数据格式是json串, 专辑信息
    	data:'album_name=爱你一万年&singer=张国荣',
    	success:function(data){
    		//返回json 结果
    		alert(data.album_name);
    	}
    });  
}  

</script>  

</head>
<body>

<input type="button" onclick="requestJson()" value="请求的是json，输出json"/>
<input type="button" onclick="responseJson()" value="请求的是key/value，输出json"/>

</body>
</html>