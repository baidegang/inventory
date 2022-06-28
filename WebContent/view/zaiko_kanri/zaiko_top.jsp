<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.select ,p , h1{
		text-align:center;
	}
</style>
<title>商品TOP</title>
</head>
<body>

	<header>
		<h1>在庫管理システム</h1>
	</header>
		<p>こんにちは、<s:property value="#session.userName" />さん
		
		<div class="select">
			<s:form action="registPage">
				<p><s:submit value="商品を登録"/>
			</s:form>
			<p><button onclick="location.href='/zaiko_kanri/view/zaiko_kanri/xxxxxxxxxxxxxxx.jsp'">商品を入庫</button>
			<p><button onclick="location.href='/zaiko_kanri/view/zaiko_kanri/xxxxxxxxxxxxxxx.jsp'">商品を出庫</button>
			<p><button onclick="location.href='/zaiko_kanri/view/zaiko_kanri/xxxxxxxxxxxxxxx.jsp'">入出庫履歴を確認</button>
	        <s:form action="updateList">
				<p><s:submit value="商品情報を更新"/>
	        </s:form>
	        <s:form action="deleteList">
				<p><s:submit value="商品情報を削除"/>
	        </s:form>
		</div>
	
	<footer>
		<div class="select">
			<s:form action="logout">
				<p><s:submit value="ログアウト"/>
			</s:form>
		</div>
	</footer>
</body>
</html>