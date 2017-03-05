<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加商品信息</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath }/items/addNameSubmit.action" method="post">
增加专辑信息：
<table width="100%" border=1>
<tr>
	<td>专辑名称</td>
	<td><input type="text" name="itemInfo['album_name']" value="请输入专辑名称"/></td>
</tr>
<tr>
	<td>专辑歌手</td>
	<td><input type="text" name="itemInfo['singer']" value="请输入专辑歌手"/></td>
</tr>
<tr>
	<td>专辑图片</td>
	<td><input type="text" name="itemInfo['album_url']" value="请输入专辑图片"/></td>
</tr>
<td colspan="2" align="center"><input type="submit" value="提交" /></td>
</table>
</form>
</body>
</html>