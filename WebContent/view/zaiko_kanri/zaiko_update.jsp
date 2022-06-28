<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.select ,p , h1, h5{
		text-align:center;
	}
	#product {
		margin:auto;
	}
</style>
<title>商品の更新</title>

<!-- 実験用 -->
<script type="text/javascript">
	var value = {
		<s:iterator value="map">
			'<s:property value="key" />': [
				<s:iterator value="value">
					'<s:property />' ,
				</s:iterator>
			] ,  
		</s:iterator>
	};
	// idを取得してvalueの中から一致する値を代入
	function setName() {
		var id = document.getElementById("id").value;
		var name = document.getElementById("name");
		var text = value[id];
		name.value = text;
	}
	
</script>
<!-- 実験用ここまで -->

</head>
<body>
	<s:form action="update">
		<header><h1>在庫管理システム</h1></header>
			<p>変更したい情報を書き換えてください
				<div class="select">
					<table id="product" border="1">
						<tr>
							<th>ID(*)</th>
							<th>商品名</th>
							<th>備考</th>
						</tr>
						<tr>
							<td><s:select id="id" name="id" list="map.keySet()" 
								headerKey="-1" headerValue="商品IDを選択してください。" onchange="setName()"/></td>
							<td><s:textfield id="name" name="name"/></td>
							<td><s:textarea name="note" /></td>
						</tr>
						
					<!-- 実験用 -->
					<!-- 実験用ここまで -->
					</table>
					<h5>(*)は変更不可</h5><br>
					<p><s:property value="%{message}" escapeHtml="false"/><br>
					<s:hidden name="userName" value="%{userName}"/>
					<p><s:submit value="変更"/>
				</div>
	</s:form>

	<footer>
		<p><button onclick="location.href='/zaiko_kanri/view/zaiko_kanri/zaiko_top.jsp'">商品TOPへ戻る</button>
	</footer>
</body>
</html>