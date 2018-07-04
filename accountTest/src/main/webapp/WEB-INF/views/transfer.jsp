<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계좌이체</h2>
	<hr>
	<form action="transfer.do" method="post">
		돈 보내는 사람 : <input type="text" name="from"><br>
		돈 받는 사람 : <input type="text" name="to"><br>
		금액 : <input type="text" name="amount"><br>
		
		<input type="submit" value="이체">
	</form>
</body>
</html>