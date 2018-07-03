<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 수정</h2>
<hr>
	<form action="updateBoard.do" method="post">
		글번호 : ${b.no} <input type="hidden" name="no" value="${b.no}"><br>
		글 제목 :<input type="text" name="title" value="${b.title}"><br>
		작성자 :<input type="text" name="writer" value="${b.writer}"><br>
		암호 :<input type="password" name="pwd" required="required"><br>
		글 내용 :<br>
		<textarea rows="10" cols="60" name="content">${b.content}</textarea><br> 
		파일:<input type="text" name="fname" value="${b.fname}"><br>
		
		<input type="submit" value="수정"> 
		<input type="reset" value="취소">
	</form>

</body>
</html>