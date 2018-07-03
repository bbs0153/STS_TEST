<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#inputForm").hide();
	
	
	var senderNumber = "";
	
	$("#btnEmail").click(function(){
		var data = $("#F").serializeArray();
		$.ajax({url:"mail.do",data:data,success:function(data){
			//alert(data);
			senderNumber = data;
		}});
	});	
	
	
	
	$("#btnOk").click(function(){
		var userInput = $("#inputNumber").val();
		alert(userInput)
		alert(userInput)
		if(senderNumber == userInput )
		{
			$("#inputForm").show();
			$("#authResult").html("인증되었습니다.");
		}
		else
		{
			$("#authResult").html("인증에 실패하였습니다.");
		}
	});
	
	
});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	
	<form id="F">
	이메일 인증 : <input type="email" name="emailAuth">
	</form>
	<button id="btnEmail">인증</button>
	
	
	<div id="inputDiv">
	인증번호 입력 : <input  type="text" id="inputNumber"/>
	<button id="btnOk">확인</button>
	</div>
	
	
	<div id="authResult"></div>
	<form id="inputForm" action="insertMember.do" 
			method="post">
	
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		주소 : <input type="text" name="addr"><br>
		이메일 : <input type="text" name="email" id="email"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>









