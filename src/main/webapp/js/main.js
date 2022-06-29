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
	}else if(document.getElementById("date").value== ""){
		alert("日付が入力されていません");
	}else if(document.getElementById("number").value== ""){
		alert("出庫数が未記入です。");
	}
	
	else{
		fm.name.value = name;
		fm.submit();
	}
}


function deleteIndex(element){
	var fm = document.getElementById("delete");
	var row = element.closest('tr').rowIndex;
	console.log(row)
	
	fm.index.value = row;
	fm.submit();
	
	
}


function submit(element){
	var fm = document.getElementById("submit");
	
	if(element.value = "出庫"){
		fm.action = "submit";
	}else{
		fm.action = "clear";
	}
	fm.submit();
}



//function rowadd(item,number,today,note,id) {
//	var table = document.getElementById("table");
//    var row = table.insertRow(-1);
//    
//    var cell1 = row.insertCell(-1);
//    var cell2 = row.insertCell(-1);
//    var cell3 = row.insertCell(-1);
//    var cell4 = row.insertCell(-1);
//    var cell5 = row.insertCell(-1);
//
//    cell1.innerHTML = item+'<input type="hidden" name="id" value='+id+'>';
//    cell2.innerHTML = number+'<input type="hidden" name="number" value='+number+'>';
//    cell3.innerHTML = today+'<input type="hidden" name="today" value='+today+'>';
//    cell4.innerHTML = note+'<input type="hidden" name="note" value='+note+'>';
//    cell5.innerHTML = '<input type="submit" value="削除" onclick="coldel(this)">';
// 
//}
//
//function rowdel(obj) {
//    // 削除ボタンを押下された行を取得
//	tr = obj.parentNode.parentNode;
//    // trのインデックスを取得して行を削除する
//    tr.parentNode.deleteRow(tr.sectionRowIndex);
//}
					