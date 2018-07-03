<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title}</h2>
	<hr>

	<table border="1">
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서위치</td>
		</tr>

		<c:forEach items="${list}" var="d">
			<tr>
				<td>${d.dno}</td>
				<td><a href="detailDept.do?dno=${d.dno}">${d.dname}</a></td>
				<td>${d.dloc}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertDept.do">추가</a>
</body>
</html>