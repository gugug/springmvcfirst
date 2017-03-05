<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<title>Insert title here</title>

<script type="text/javascript" src="../public/javascript/jquery-2.1.1.min.js">  
</script>  
<script type="text/javascript">  
$(function() {  
    getjson();  
});  
  
function getjson() {  
    $.ajax( {  
        type : "get",  
        url : "${pageContext.request.contextPath }/shop/getShopInJSON.action",  
        dataType:"json",  
        success : function(msg) {  
            alert("Data Saved: " + msg.name+"--"+msg.staffName);  
        },
        error:function(msg){  
            alert("出错了！！"+msg.name+"--"+msg.staffName);  
        }
    });  
}  
</script>  

</head>
<body>

test json by 简单的JQuery(AJAX)+SpringMVC的小例子(JSON)
</body>
</html>