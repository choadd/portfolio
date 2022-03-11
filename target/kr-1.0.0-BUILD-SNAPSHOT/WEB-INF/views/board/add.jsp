<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h1>hello</h1>
	<form action="/add" method="post" enctype="multipart/form-data">
		<c:if test="${loginName eq null}">
			<input type="text" name="writer" placeholder="작성자">
		</c:if>
		<c:if test="${loginName ne null}">
			<input type="hidden" name="writer" value="${loginName}">
		</c:if>
		<input type="text" name="title" placeholder="제목"> 
		<input type="text" name="content" placeholder="내용">
		<input type="file" name="files" />
		<input type="file" name="files" /> 
		<input type="submit" />
	</form>

</body>
</html>