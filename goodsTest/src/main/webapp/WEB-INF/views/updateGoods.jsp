<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateGoods.do" method="post" enctype="multipart/form-data">
		상품번호:<input type="text" name="no" value="${g.no }"><br>
		상품이름:<input type="text" name="item" value="${g.item }"><br>
		상품가격:<input type="text" name="price" value="${g.price }"><br>
		상품수량:<input type="text" name="qty" value="${g.qty }"><br>
		상품이미지:<br>
		<img src="resources/img/${g.fname}" width="50" height="50">
		<input type="file" name="multipartFile" value="${g.multipartFile }"><br>
		<input type="hidden" name="fname" value="${g.fname}">
		<input type="submit" value="수정">
		<input type="reset" value="삭제">
	</form>

</body>
</html>