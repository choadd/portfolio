<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일첨부</h2>
	<form action="/storage/insertOk" method="post"
		enctype="multipart/form-data">
		<p>
			<input type="text" name="title" placeholder="제목">
		</p>
		<p>
			<textarea name="desciption" placeholder="내용" rows="10"></textarea>
		</p>
		<p>
			<input type="file" name="attach" placeholder="파일이름">
		</p>
		<button>전송</button>
	</form>
</body>
</html>