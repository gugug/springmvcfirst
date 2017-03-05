<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑列表搜索结果</title>
</head>
<body>
<form action="" method="post">
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
<td>操作</td>
</tr>
<c:forEach items="${albumList }" var="item">
<tr>
<td>${item.id }</td>
<td>${item.album_name }</td>
<td>${item.singer }</td>
<td>${item.album_url }</td>

<td><a href="${pageContext.request.contextPath}/items/editAlbum.action?id=${item.id}">修改</a></td>
<td><a href="${pageContext.request.contextPath}/items/deleteAlbum.action?id=${item.id}">删除</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>
</html>