<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnRead").click(function() {

			$.ajax("listGoods.do", {
				success : function(data) {
					var list = eval("(" + data + ")");
					$("#tb").html("");
					$.each(list, function(i, g) {

						var tr = $("<tr></tr>");
						var td1 = $("<td></td>").html(g.item);
						var td2 = $("<td></td>").html(g.price);

						$(tr).append(td1, td2);
						$("#tb").append(tr);

						$(tr).mouseover(function() {
							
							$("#div").empty();
							
							var img = $("<img/>").attr({
								src:"resources/img/"+g.fname,
								width: "300",
								height: "300"
							});
							
							
							$("#div").append(img,$("<br>"));
							$("#div").append("상품번호:" + g.no + "&nbsp;&nbsp;&nbsp;");
							$("#div").append("상품명:" + g.item + "&nbsp;&nbsp;&nbsp;");
							$("#div").append("가격:" + g.price + "&nbsp;&nbsp;&nbsp;");
							$("#div").append("수량:" + g.qty + "&nbsp;&nbsp;&nbsp;");
						});

						});
					

				}
			});

		});

	});
</script>
</head>
<body>
	<h2>${title }</h2>
	<button id="btnRead">상품목록 읽어오기</button>
	<a href="insertGoods.do">상품추가</a>
	<table border="1" width="80%">
		<thead>
			<tr>
				<td>상품명</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody id="tb"></tbody>
	</table>
	<div id=div></div>
</body>
</html>