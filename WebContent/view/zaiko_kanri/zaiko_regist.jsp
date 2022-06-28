<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.select ,p , h1 {
		text-align:center;
	}
	#product {
		margin:auto;
	}
	/* 	s:fielderrorは表示形式にul liタグを使っているのでCSSで設定を変えることができる */
	li {
		list-style:none;
		color:red;
	}
</style>
<title>商品の登録</title>
</head>
<body>
	<s:form action="regist">
		<header><h1>在庫管理システム</h1></header>
		<p>商品情報を入力してください。
		<p><s:property value="#session.userName"/>さん
		<p>
		<div class="select">
			<table id="product" border="1">
				<tr>
					<th>商品名</th>
					<th>備考</th>
				</tr>
				<tr>
					<td><s:textfield name="name" errorPosition="false"/></td>
					<td><s:textarea name="note" /></td>
				</tr>
			</table>
			<p><s:fielderror fieldName="name"/>
			<p><s:property value="%{message}" escapeHtml="false"/><br>
			<p><s:submit value="登録"/>
		</div>
	</s:form>
	<footer>
		<p><button onclick="location.href='/zaiko_kanri/view/zaiko_kanri/zaiko_top.jsp'">商品TOPへ戻る</button>
	</footer>
</body>
</html>