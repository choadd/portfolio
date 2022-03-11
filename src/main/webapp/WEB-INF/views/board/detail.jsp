<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td><b>번호</b> : ${detail.no}</td>
		</tr>
		<tr>
			<td><b>작성자</b> : ${detail.writer}</td>
		</tr>
		<tr>
			<td><b>제목</b> : ${detail.title}</td>
		</tr>
		<tr>
			<td><b>내용</b> : ${detail.content}</td>
		</tr>
		<tr>
			<td>${detail.writedate}</td>
		</tr>
	</table>
	<c:if test="${prevNext.prev ne 0}">
		<a href="detail?no=${prevNext.prev }">이전글</a>
	</c:if>
	<c:if test="${prevNext.next ne 0}">
		<a href="detail?no=${prevNext.next }">다음글</a>
	</c:if>
	

</body>
</html>