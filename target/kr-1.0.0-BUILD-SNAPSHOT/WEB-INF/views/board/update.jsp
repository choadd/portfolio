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
	<form action="/updateClear" method="get">
		<input type="hidden" name="no" value="${no }"> 
		<input type="hidden" name="writer" value="${loginName}" placeholder="${loginName}"
			readonly>
		<h2>${loginName}님수정할제목과내용을입력해주세요</h2>
		<input type="text" name="title" placeholder="제목"> <input
			type="text" name="content" placeholder="내용"> <input
			type="submit" />

	</form>

</body>
</html>