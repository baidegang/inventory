<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入庫</title>
<link rel=stylesheet href="receive.css">
</head>
<body>

<!-- TOP遷移  -->
<form>
<div class="r_submit">
	<a href="/inventory">TOP</a>
</div>	
</form>

<h1>入庫情報入力</h1>

<!-- Javascriptのアラートの拡張  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<!-- 登録フォーム  -->
<div class="register">
		<table>
			<tr style="text-align:center">
				<th>商品</th>
				<th>在庫数</th>			
				<th>入庫数</th>
				<th>入庫日</th>
				<th>備考</th>
			</tr>
			<tr style="text-align:center">
				<td><form name="submit">
					<s:select id="productname" list="products" listValue="name" listKey="id" value="1" onchange="change_name()"/>
				</form></td>
				<td valign="middle"><meter id="inventory" max=200 value=<s:property value="products[0].inventory.quantity"/>></meter>
					<p id="math"><s:property value="products[0].inventory.quantity"/></p>
				</td>
				<td><input type="number" min="1" id="number"></td>
				<td><input type="date" name="today" id="today"></td>
				<td><textarea rows="3" cols="20" id=r_note></textarea></td>
				<td><input type="submit" value="更新" onclick="register()"></td>
			</tr>
		</table>
</div>


<!-- 在庫表示の実装  -->
<script type="text/javascript">
	function change_name(){
		var number = document.getElementById("productname").selectedIndex;
		var id = document.getElementById('productname').options[number].value
		var inventory = document.getElementById("inventory")
		var math = document.getElementById("math")
		<s:iterator value="products" var="product" status="key">
		if(id == '<s:property value="id"/>'){
			inventory.value = '<s:property value="inventory.quantity"/>';
			math.innerText = '<s:property value="inventory.quantity"/>';
		}
		</s:iterator>
		<!--  '<s:property value="students[20].name"/>' -->
		}
</script>


<!-- 本登録  -->
<form action="register" method="get">
	<table id="table" style="text-align:center">
		<tr>
			<th>商品</th>
			<th>入庫数</th>
			<th>入庫日</th>
			<th>備考</th>
			<th></th>
		</tr>
	</table>
	
	<div class="r_submit">
		<input type="submit" value="入庫">
	</div>
</form>

	<script type="text/javascript" src="receive.js"></script>
</body>
</html>