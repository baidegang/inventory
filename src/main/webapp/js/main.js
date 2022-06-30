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
	var quantity = objQu.options[idx].text;
	var shipMounts = document.getElementById("number").value;

	console.log(quantity + "," + shipMounts);

	if (parseInt(shipMounts) > parseInt(quantity)) {
		alert("出庫数が在庫数を上回っています。");
	} else if (document.getElementById("date").value == "") {
		alert("日付が入力されていません");
	} else if (document.getElementById("number").value == "") {
		alert("出庫数が未記入です。");
	}

	else {
		fm.name.value = name;
		fm.submit();
	}
}


function deleteIndex(element) {
	var fm = document.getElementById("delete");
	var row = element.closest('tr').rowIndex;
	console.log(row)

	fm.index.value = row;
	fm.submit();


}


function allAction(element) {
	var fm = document.getElementById("sub");
	console.log(element.value);
	if (element.value == "出庫") {
		fm.action = "submit";
	} else {
		fm.action = "clear";
	}
	fm.submit();
}



