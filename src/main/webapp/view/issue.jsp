<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/local/css/style.css">
<script type="text/javascript" src="/local/js/main.js"></script>
</head>
<body>
	<br>
	<a href="/local">TOP</a>
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
				<td><s:select list="list" listValue="name" listKey="id" id="id"
						name="id" value="1" onchange="inputChange()">
					</s:select> <input type="hidden" name="name"></td>
				<td><s:select list="list" listValue="quantity" listKey="id"
						id="quantity" name="quantity" disabled="true"></s:select></td>
				<td><input id="number" name="shipMounts" type="number" min="0"
					value="10"></td>
				<td><input type="date" name="date" id="date"></td>
				<td><textarea name="note"></textarea></td>
				<td><input type="button" value="更新" onclick="updateData()"></td>
			</tr>
		</table>

	</s:form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<s:form action="delete" id="delete">
		<s:hidden name="index" />
		<table class="stockdata">
			<s:hidden id="hidden"></s:hidden>
			<tr>
				<th>商品</th>
				<th>出庫数</th>
				<th>出庫日</th>
				<th>備考</th>
				<th>削除</th>
			</tr>
			<s:iterator value="#session.duaList" status="stat">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="shipMounts" /></td>
					<td><s:property value="date" /></td>
					<td><s:property value="note" /></td>
					<td><input type="button" value="削除"
						onclick="deleteIndex(this)"></td>
				</tr>
			</s:iterator>
		</table>
		<br>
	</s:form>
	<br>
	<p style="color: red;">
		<s:property value="message" />
	</p>
	<s:form id="sub">
		<input type="button" value="出庫" onclick="allAction(this)">
		<input type="button" value="クリア" onclick="allAction(this)">
	</s:form>


</body>
</html>