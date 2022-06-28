/**
 * 
 */
 
function inputChange() {

	var id = document.getElementById("id");
	id = id.selectedIndex;
	document.getElementById("quantity").selectedIndex = id;
}

function updateData() {
	var fm = document.getElementById("inputDataStock");	
	var obj = document.getElementById("id");
	var objQu = document.getElementById("quantity");
	var id = obj.value;
	var idx = obj.selectedIndex;
	var name = obj.options[idx].text;
	var  quantity = objQu.options[idx].text;
	var shipMounts = document.getElementById("number").value;
	
	console.log(quantity + "," + shipMounts);
	
	if(shipMounts > quantity){
		alert("出庫数が在庫数を上回っています。");
	}else{
		fm.name.value = name;
		fm.submit();
	}
	
	
	
}					