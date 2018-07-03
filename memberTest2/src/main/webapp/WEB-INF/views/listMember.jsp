<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			$("#show_msg").html("");
		}, 3000);
	});
</script>

</head>
<body>
	<h2>회원목록</h2>
	<hr>
	<div id="show_msg">${msg}</div>
	<table>
		<tr>
			<td>이름</td>
			<td>나이</td>
		</tr>

		<c:forEach items="${list}" var="m">
			<tr>
				<td>${m.name}</td>
				<td>${m.age}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertMember.do">회원추가</a>
</body>
</html>