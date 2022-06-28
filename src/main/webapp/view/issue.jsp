<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Zaiko/css/style.css">
<script type="text/javascript" src="/Zaiko/js/main.js"></script>
</head>
<body>
	<br>
	<a href="">TOP</a>
	<br>
	<h2>出庫情報入力</h2>

	<s:form action="inputDataStock" id="inputDataStock">
		<table class="inputdata" border="1">
			<tr>
				<th>商品</th>
				<th>在庫数</th>
				<th>出庫数</th>
				<th>出庫日</th>
				<th>備考</th>
				<th>更新</th>
			</tr>
			<tr>
				<td><s:select list="list" listValue="name" listKey="id"
						defaultvalue="0" id="id" name="id" onchange="inputChange()">
					</s:select> <input type="hidden" name="name"></td>
				<td><s:select list="list" listValue="quantity" listKey="id"
						id="quantity" name="quantity" disabled="true"></s:select></td>
				<td><input id="number" name="shipMounts" type="number" min="0"
					value="10"></td>
				<td><input type="date" name="date"></td>
				<td><textarea></textarea></td>
				<td><input type="button" value="更新" onclick="updateData()"></td>
			</tr>
		</table>

	</s:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="">
		<table class="stockdata">
			<tr>
				<th>商品</th>
				<th>出庫数</th>
				<th>出庫日</th>
			</tr>
			<s:iterator value="duaList">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="shipMount" /></td>
					<td><s:property value="date" /></td>
				</tr>
			</s:iterator>
		</table>
		<br> <input type="submit" value="出庫">
	</form>


	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>quantity</th>
			<th>user</th>

		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="quantity" /></td>
				<td><s:property value="lastuser" /></td>
			</tr>
		</s:iterator>
	</table>


</body>
</html>