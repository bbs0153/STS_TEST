<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="insertGoods.do" method="post">
	상품번호 : <input type="text" name="no"><br>
	상품이름 : <input type="text" name="item"><br>
	상품가격 : <input type="text" name="price"><br>
	상품수량 : <input type="text" name="qty"><br>
	상품이미지 : <input type="file" name="uploadFile">
	
	<input type="submit" value="추가">
	<input type="reset" value="취소">
	</form>

</body>
</html>