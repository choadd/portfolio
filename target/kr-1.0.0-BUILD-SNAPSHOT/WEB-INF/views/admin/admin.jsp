<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<colgroup>
			<col style="width: 14%;" />
			<col style="width: 14%;" />
			<col style="width: 14%;" />
			<col style="width: 14%;" />
			<col style="width: 14%;" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">ID</th>
				<th scope="col">PASSWORD</th>
				<th scope="col">NAME</th>
				<th scope="col">EMAIL</th>
				<th scope="col">JOINDATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.no }<a href="/admin/delete?no=${list.no }">삭제</a></td>
					<td>${list.id }</td>
					<td>${list.password }</td>
					<td>${list.name }</td>
					<td>${list.email }</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd"
							value="${list.joinDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/list">글목록으로 돌아가기</a>
	
</body>
</html>
