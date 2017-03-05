<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑列表搜索结果</title>
<script type="text/javascript">
function editItemsAllSubmit(){
	//提交itemsForm
	document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsAllSubmit.action";
	document.itemsForm.submit();
}
function queryItems(){
	//提交queryItems
	document.itemsForm.action="${pageContext.request.contextPath }/items/searchAlbum.action";
	document.itemsForm.submit();
}
</script>

</head>
<body>
<form name="itemsForm" action="" method="post">

查询条件：
<table width="100%" border=1>
<tr>
<td><input type="text" name="searchContent" value="请输入专辑关键字"/></td>
<td><input type="button" value="查询" onclick="queryItems()"/>
<input type="button" value="批量修改提交" onclick="editItemsAllSubmit()"/>
</td>
</tr>
</table>

查询结果：
<table width="100%" border=1>
<tr>
<td>
<a href="${pageContext.request.contextPath }/items/queryAlbum.action">
首页
</a>
</td>
</tr>
<tr>
<td><a href="${pageContext.request.contextPath}/items/addAlbum.action">增加</a></td>
</tr>
</table>

搜索专辑列表结果
<table width="100%" border=1>
<tr>
<td>专辑id</td>
<td>专辑名称</td>
<td>专辑歌手</td>
<td>专辑图片</td>
<td>专辑图片预览</td>


</tr>
<c:forEach items="${albumList }" var="item" varStatus="status">
<tr>
<td>${item.id }</td>
<td><input name ="albumItemsList[${status.index }].album_name" value="${item.album_name }" /></td>
<td><input name ="albumItemsList[${status.index }].singer" value="${item.singer }" /></td>
<td><input name ="albumItemsList[${status.index }].album_url" value="${item.album_url }" /></td>

	<td><img alt="" src="/albumpic/${item.album_url }" style="width:130px;height:190px;" />
	<input type="file" name="file" /> </td>
</tr>
</c:forEach>

</table>
</form>
</body>
</html>