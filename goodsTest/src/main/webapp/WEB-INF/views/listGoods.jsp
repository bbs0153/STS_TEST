<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		setTimeout(function() {
			$("#show_msg").html("")
		}, 3000);
	});
</script>
</head>
<body>
<div id=show_msg><h2>${msg}</h2></div>
	<form action="listGoods.do" method="post">
		<select name="keyField">
			<option value="no">상품번호</option>		
			<option value="item">상품이름</option>		
			<option value="price">상품가격</option>		
		</select> : <input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>


	<table border="1" width="600">
		<tr align="center">
			<td>상품번호</td>
			<td>상품이름</td>
			<td>상품가격</td>
			<td>상품수량</td>
			<td width="110">상품이미지</td>
		</tr>

		<c:forEach items="${list}" var="g">
			<tr align="center">
				<td>${g.no}</td>
				<td><a href="detailGoods.do?no=${g.no}">${g.item}</a></td>
				<td>${g.price}</td>
				<td>${g.qty}</td>
				<td><img src="resources/img/${g.fname}" width="100"
					height="100"></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertGoods.do">상품등록</a>


</body>
</html>