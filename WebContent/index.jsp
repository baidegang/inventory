<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.select ,p , h1{
		text-align:center;
	}
</style>
<title>ログイン</title>
</head>
<body>

<header><h1>在庫管理システム</h1></header>
	<div class="select">
		<s:form action="login">
			USER:<s:textfield name="userName" value="" errorPosition="false"/><br>
			PASSWORD:<s:password name="password" size="10" maxlength="10"/><br>
<%-- 			<s:hidden name="userName"/> --%>
			<s:submit value="ログイン"/>
		</s:form>
		<s:property value="%{message}"/>
	</div>   
</body>
</html>