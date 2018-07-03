<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서등록</h2>
	<hr>
		<form action="insertDept.do" method="post">
		
			부서번호 : <input type="text" name="dno"><br>
			부서명 : <input type="text" name="dname"><br>
			부서위치 : <input type="text" name="dloc"><br>
			
			<input type="submit" value="추가"> 
			<input type="reset" value="취소">
			
		</form>

</body>
</html>