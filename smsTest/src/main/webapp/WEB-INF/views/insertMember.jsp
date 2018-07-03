<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#joinForm").hide();
		var sendNumber = "";
		$("#btnAuth").click(function() {
			var data = $("#F").serializeArray();
			$.ajax({
				url : "send.do",
				data : data,
				success : function(data) {
					
					sendNumber = data;
					
				}
			});
		});
		
		$("#btnOk").click(function() {
			var userInput = $("#userInput").val();
			
			if(sendNumber == userInput){
				$("#joinForm").show();
				$("#msg").html("인증에 성공하였습니다");
			}else{
				$("#msg").html("인증에 실패하였습니다");
			}
		});
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form id="F">
		전화번호 : <input type="text" name="authTel">
	</form>
	<button id="btnAuth">인증하기</button><br>
	인증번호 입력 : <input type="text" id="userInput">
	<button id="btnOk">확인</button>
	
	<div id="msg"></div>
	<form id="joinForm" action="insertMember.do" method="post">
		아이디:<input type="text" name="id"><br>
		암호:<input type="password" name="pwd"><br>
		이름:<input type="text" name="name"><br>
		전화:<input type="text" name="tel"><br>
		
		<input type="submit" value="가입">
	</form>
</body>
</html>