<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入庫完了</title>
<link rel=stylesheet href="receive.css">
</head>
<body>
<h1>入庫完了</h1>
<!-- 在庫履歴遷移 -->
	<form>
		<div class="r_submit">
			<input type="submit" value="在庫履歴へ">
		</div>
	</form>
	
<!-- 入庫登録遷移 -->
	<form action="IndexAction">
		<div class="r_submit">
			<input type="submit" value="もどる"/>
		</div>
	</form>
</body>
</html>