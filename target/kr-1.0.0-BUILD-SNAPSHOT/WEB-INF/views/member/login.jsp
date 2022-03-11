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

	<table border="1">
		<div>
			<form action="/list" method="post">
				<div>
					아이디 : <input type="text" name="id">
				</div>
				<div>
					비밀번호 : <input type="password" name="password">
				</div>
				<div>
					<input type="submit" value="로그인">
				</div>
			</form>
		</div>
		<div>
			<button>
				<a href="/join">회원가입</a>
			</button>
		</div>
	</table>

</body>
</html>