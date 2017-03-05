<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>

<!-- 显示错误信息 -->
<c:if test="${allErrors!=null }">
<c:forEach items="${allErrors }" var="error">
	${error.defaultMessage }</br>
</c:forEach>
</c:if>


<form id="itemForm" action="${pageContext.request.contextPath }/items/editAlbumSubmit.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${album.id }" />
修改专辑信息：
<table width="100%" border=1>
<tr>
	<td>专辑名称</td>
	<td><input type="text" name="album_name" value="${album.album_name}"/></td>
</tr>
<tr>
	<td>专辑歌手</td>
	<td><input type="text" name="singer" value="${album.singer}"/></td>
</tr>
<tr>
	<td>专辑图片</td>
	<td><img alt="" src="/albumpic/${album.album_url }" style="width:130px;height:190px;" />
	<input type="file" name="file" /> </td>
	
	
</tr>
<td colspan="2" align="center"><input type="submit" value="提交" /></td>
</table>
</form>
</body>
</html>