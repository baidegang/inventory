<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.Date" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<script type="text/javascript">
function aa(a){
	alert(a);
  document.hello4.aaa.value=a;
}
</script>
</head>
<body>
<%=122
%>

	<s:form action="hello4">
		<s:hidden name="aaa"/>
		<br>&nbsp;&nbsp;&nbsp;&nbsp; 学号:<s:textfield name="id" /><br>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;名字:<s:textfield name="name" /><br>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;性别:<s:textfield name="sex" /><br>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;年龄:<s:textfield name="age" /><br>
		<br>ClassID:<s:textfield name="classid" />
		<hr>
		<s:submit value="更新" onClick="aa(1)"/>
		<s:submit value="削除" onClick="aa(2)"/>
		<s:submit value="戻る" onClick="aa(3)"/>
	</s:form>
			
	<s:form action="hello1">
		<hr> &nbsp;&nbsp;&nbsp;&nbsp;学号:<s:textfield name="id" />
		<hr> &nbsp;&nbsp;&nbsp;&nbsp;名字:<s:textfield name="name" />
		<hr> &nbsp;&nbsp;&nbsp;&nbsp;性别:<s:textfield name="sex" />
		<hr> &nbsp;&nbsp;&nbsp;&nbsp;年龄:<s:textfield name="age" />
		<hr>ClassID:<s:textfield name="classid" />
		<hr>
		<s:submit value="insert" />
		   </s:form>
		   
		   <s:form action ="hello2">
		   <hr><s:textfield name="id" />
		   <s:submit value="delete"/>
		   </s:form>

	<table border="1" width="500" height="50">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>班级</th>
		</tr>
		<s:iterator value="students">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="classid" /></td>
				<td><input type="submit" value="詳細" onclick="aa(2222)" />
				<input type="submit" value="编辑" onclick=${"aa("}${id}${")"} />
				<input type="submit" value="删除" onclick=${"aa("}${id}${")"} />
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>