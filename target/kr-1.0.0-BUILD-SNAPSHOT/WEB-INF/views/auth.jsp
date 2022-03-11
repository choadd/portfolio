<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check() {

	}
</script>
</head>
<body>
	<h1>사용자 확인</h1>
	<div>
		<small>아래의 코드를 입력해 주십시오</small>
		<h2>보안코드 : ${authValue }</h2>
		<form action="/auth/pass" method="get">
			<input type="text" name="userkey">
		</form>
	</div>


</body>
</html>