<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pro(url) {
		re = confirm("정말로 삭제 하시겠습니까?");
		if (re == true) {
			location.href = url;
		}
	}
</script>
</head>
<body>
	상품번호:${g.no}
	<br> 상품이름:${g.item}
	<br> 상품가격:${g.price}
	<br> 상품수량:${g.qty}
	<br> 상품이미지:
	<br>
	<img src="resources/img/${g.fname}" width="100" height="100">
	<br>

	<a href="updateGoods.do?no=${g.no}">수정</a>
	<a href="#" onclick="pro('deleteGoods.do?no=${g.no}')">삭제</a>

</body>
</html>