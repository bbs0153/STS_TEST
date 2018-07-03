<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원등록</h2>
	<hr>

	<form action="insertMember.do" method="post" enctype="multipart/form-data">
		아이디: <input type="text" name="id"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="text" name="age"><br>
		주소: <input type="text" name="addr"><br>
		이미지: <input type="file" name="uploadFile"><br>
		
		<input type="submit" value="추가">
		<input type="reset" value="취소">
	</form>

</body>
</html>