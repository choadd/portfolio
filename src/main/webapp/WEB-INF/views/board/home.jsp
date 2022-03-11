<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Home</title>
<style>
.nickname a {
	color: blue
}

.delete a {
	text-decoration-line: none;
}

.update a {
	text-decoration-line: none;
}
</style>
</head>
<body>
	<h1>Hello world!</h1>
	<form action="/test" method="get">
		<input type="checkbox" name="column" value="writer">작성자
		<input type="checkbox" name="column" value="title">제목
		<input type="checkbox" name="column" value="content">내용
		<input type="text" name="keyword"  placeholder="텍스트를 입력하세요"/>
		<input type="submit" value="검색"/> 
	</form>
	<c:if test="${loginName ne null}">
		<div class="nickname">
			환영합니다 :<a href=""> ${loginName }</a> 님
		</div>
	</c:if>	
	<c:if test="${admin ne null}">
		<div class="nickname">
			안녕하세요 :<a href=""> ${admin }</a> 님
		</div>
		<a href="/admin">관리자 페이지로 이동</a>
	</c:if>

	<h4>전체 게시글 수 ${boardCount}</h4>
	<table border="1px">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 30%;" />
			<col style="width: 19%;" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">작성자</th>
				<th scope="col">제목</th>
				<th scope="col">내용</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href="/detail?no=${vo.no}">${vo.no}(클릭시 상세보기)</a></td>
					<td>${vo.writer}</td>
					<td>${vo.title}</td>
					<td>${vo.content}</td>
					
					<td>${vo.writedate}</td>

					<c:if
						test="${sessionScope.loginName eq vo.writer ||sessionScope.admin ne null}">
						<td><button class="delete">
								<a href="${contextPath}/delete?no=${vo.no}">${vo.no}번 글 삭제 </a>
							</button></td>
						<td><button class="update">
								<a href="${contextPath}/update?no=${vo.no}">${vo.no}번 글 수정</a>
							</button></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
		<button>
			<a href="/add">글쓰기</a>
		</button>
		<c:if test="${loginName eq null || sessionScope.admin eq null}">
			<button>
				<a href="/login">회원가입/로그인</a>
			</button>
		</c:if>
		<c:if test="${loginName ne null || sessionScope.admin ne null}">
			<button>
				<a href="/logout">로그아웃</a>
			</button>
		</c:if>
	</table>


	<c:forEach var="i" begin="0" end="${boardCount/10}" step="1">
		<c:if test="${i < 5}">
			<ul>
				<a href="/list?pageStart=${i*10}">${i+1} 페이지</a>
			</ul>
		</c:if>
		<c:if test="${i==5}">
			<a href="/list?pageStart=${i*10}">next</a>
		</c:if>
	</c:forEach>
</body>
</html>

