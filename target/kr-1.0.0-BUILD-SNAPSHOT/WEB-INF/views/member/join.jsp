<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="/joinData" method="post">
		<input type="text" name="id" placeholder="id"> <input
			type="text" name="password" placeholder="password"> <input
			type="text" name="name" placeholder="name"> <input
			type="text" name="email" placeholder="email"> <input
			type="submit" value="회원가입" />
	</form>
</body>
</html>