<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑列表</title>
<script type="text/javascript">
function deleteItems(){
	//提交itemsForm
	document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action";
	document.itemsForm.submit();
}
function queryItems(){
	//提交queryItems
	document.itemsForm.action="${pageContext.request.contextPath }/items/searchAlbum.action";
	document.itemsForm.submit();
}
function editItemsAllSubmit(){
	//提交itemsForm
	document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsQuery.action";
	document.itemsForm.submit();
}
</script>
</head>
<body>
<!-- 直接读取缓存 -->
 当前用户:${username}  
    <c:if test="${username!=null}">  
        <a href="${pageContext.request.contextPath }/user/albumLogout.action">退出</a>  
    </c:if>  

<form name="itemsForm" action="${pageContext.request.contextPath }/items/searchAlbum.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>

<td>
名称：<input type="text" name="searchContent" value="请输入专辑关键字"/>
类型：
<select name="itemType">
	<c:forEach items="${itemtypes }" var="itemType">
		<option value="${itemType.key }">${itemType.value }</option>
	</c:forEach>
</select>


</td>

<td><input type="button" value="查询" onclick="queryItems()"/>
<input type="button" value="批量删除" onclick="deleteItems()"/>
<input type="button" value="批量查询修改" onclick="editItemsAllSubmit()"/>

</td>
</tr>
</table>

<table width="100%" border=1>
<tr>
<td><a href="${pageContext.request.contextPath}/items/addAlbum.action">增加专辑</a>
<a href="${pageContext.request.contextPath}/items/addSinger.action">增加歌手</a></td>

</tr>
</table>

<table width="100%" border=1>
<tr>
<td><a href="showUpload.action">上传</a></td>
</tr>
</table>


专辑列表
<table width="100%" border=1>
<tr>
<td>选择</td>

<td>专辑id</td>
<td>专辑名称</td>
<td>专辑歌手</td>
<td>专辑图片</td>
<td>操作</td>
</tr>
<c:forEach items="${albumList }" var="item">
<tr>
<td><input type="checkbox" name="items_id" value="${item.id }" /></td>
<td>${item.id }</td>
<td>${item.album_name }</td>
<td>${item.singer }</td>
<td><img alt="" src="/albumpic/${item.album_url }" style="width:90px;height:90px;" /> </td>


<td><a href="${pageContext.request.contextPath}/items/editAlbum.action?id=${item.id}">修改</a></td>
<td><a href="${pageContext.request.contextPath}/items/deleteAlbum.action?id=${item.id}">删除</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>
</html>