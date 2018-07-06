<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mborder {
	border: 1px solid pink;
	border-radius: 10px;
	width: 200px;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "listMongoMember.do",
			success : function(data) {
				var arr = eval("(" + data + ")");
				$.each(arr, function(idx, m) {

					var div = $("<div></div>");
					$(div).addClass("mborder");
					$.each(m, function(i, m2) {

						if (i == "name") {

							$("<h3></h3>").html(m2).appendTo(div);
						} else {

							var h1 = $("<p></p>").html(m2);
							$(div).append(h1);
						}

					})
					$("#list").append(div);

				});
			}
		});
		
		
	
	$("#btn").click(function() {

			$.ajax({
				url : "",
				success : function(data) {
					
					
				}
			})

		})

	});
</script>
</head>
<body>
	<h2>회원정보</h2>
	
	이름 : <input type="text">
	<button id="btn">검색</button>
	
	<div id="list"></div>

</body>
</html>