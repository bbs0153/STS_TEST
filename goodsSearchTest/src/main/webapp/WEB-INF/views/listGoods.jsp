<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	
	<form action="listGoods.do" method="post">
		<select name="searchField">
			<option value="no">상품번호</option>		
			<option value="item">상품이름</option>		
			<option value="price">상품가격</option>		
		</select> : <input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>

	<table border="1" width="80%">
		<tr>
			<td><a href="listGoods.do?sortField=no">상품번호</a></td>
			<td><a href="listGoods.do?sortField=item">상품이름</a></td>
			<td><a href="listGoods.do?sortField=price">상품가격</a></td>
			<td><a href="listGoods.do?sortField=qty">상품수량</a></td>
			<td><a href="listGoods.do?sortField=fname">상품이미지</a></td>
		</tr>

		<c:forEach items="${list}" var="g">
			<tr>
				<td>${g.no}</td>
				<td>${g.item}</td>
				<td>${g.price}</td>
				<td>${g.qty}</td>
				<td>${g.fname}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>