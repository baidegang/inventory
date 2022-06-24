<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Struts2でHelloWorld</title>
    </head>
    <body>
        <!-- 入力フォームはStruts2のタグを使用します -->
        <s:form action="hello">
            user:　　   <s:textfield name="username"/><br/>
            password:<s:password key="password" />
            <s:submit value="login" />
        </s:form>
       <s:property value="message"/>
       
    </body>
</html>