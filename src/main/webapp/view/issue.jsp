<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Zaiko/css/style.css">
</head>
<body>
	    <br>
    <a href="">TOP</a>
    <br>
    <h2>出庫情報入力</h2>

    <s:form action="inputDataStock">
        <table class="inputdata" border="1">
            <tr>
                <th>商品</th>
                <th>在庫数</th>
                <th>出庫数</th>
                <th>出庫日</th>
                <th>備考 </th>
                <th>更新</th>
            </tr>
            <tr>
                <td>
                <s:select list="list" listValue="name" listKey="id" id ="name" onchange="inputChange()" name="id">
				</s:select></td>
                <td>
                <s:select list="list" listValue = "quantity" listKey="id" id="quantity" disabled="true"></s:select>
                </td>
                <td><input id="number" type="number" min="0" value="10"></td>
                <td><input type="date" value="2022/06/20"></td>
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
            <tr>
                <td>Computer</td>
                <td>3</td>
                <td>2022/06/20</td>
                <td><input type="button" value="削除"></td>
            </tr>
            <tr>
                <td>Mouse</td>
                <td>2</td>
                <td>2022/06/20</td>
                <td><input type="button" value="削除"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="出庫">
    </form>
    
    
     <table border="1">
        <tr>
        <th>id</th>
        <th>name</th>
        <th>quantity</th>
        <th>user</th>
        
        </tr>
        <s:iterator  value="list">
        <tr>
        <td><s:property value = "id" /></td>
        <td><s:property value = "name" /></td>
        <td><s:property value = "quantity" /></td>
        <td><s:property value = "lastuser" /></td>
        </tr>
        </s:iterator>
		</table>
		
		<script type="text/javascript">
        
        			function inputChange() {
        				
                    	var id = document.getElementById("name");
                    	    id = id.selectedIndex;
                    	document.getElementById("quantity").selectedIndex = id;
					}
        			
        			function updateData(){
        				var obj = document.getElementById("name");
        				var id = obj.value;
        				var idx = obj.selectedIndex;
        				var name = obj.options[idx].text;
        				
        				
                	    
        			}
        			
        			
        </script>
    
</body>
</html>