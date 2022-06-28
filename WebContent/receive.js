/**
 * 
 */
 
var today = new Date();
today.setDate(today.getDate());
var yyyy = today.getFullYear();
var mm = ("0"+(today.getMonth()+1)).slice(-2);
var dd = ("0"+today.getDate()).slice(-2);
document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;



function register(){
	if(document.getElementById('number').value == "" && document.getElementById('today').value == ""){
		swal("入庫数、入庫日が未入力です");		
	}else if(document.getElementById('number').value == ""){
		swal("入庫数が未記入です");
	}else if(document.getElementById('today').value == ""){
		swal("入庫日が未記入です");
	}else{
		
		var item0 = document.getElementById('productname').selectedIndex;
		var id = document.getElementById('productname').options[item0].value;
		var item = document.getElementById('productname').options[item0].innerText;
		var number = document.getElementById('number').value; 
		var today = document.getElementById('today').value;
		var note = document.getElementById('r_note').value;
		console.log("商品名"+item);
		console.log("商品ID"+id);
		console.log(number);
		console.log(today);
		console.log(note);
		
		var options = {
        text:"商品名："+ item +"  入庫数："+ number +"  入庫日："+ today + "\n"  + "で登録しますか？", //\nでテキストの改行が出来ます
	        buttons: {
	            cancel: 'キャンセル',
	            ok: '登録する'
	        }
	    };
	    swal(options).then(function(value){
	        if(value){
	            //登録するを選んだ場合の処理
	            coladd(item,number,today,note,id);
	        }
	    });
	}
}

//一時登録用リストへの追加
function coladd(item,number,today,note,id) {
	var table = document.getElementById("table");
    var row = table.insertRow(-1);
    
    var cell1 = row.insertCell(-1);
    var cell2 = row.insertCell(-1);
    var cell3 = row.insertCell(-1);
    var cell4 = row.insertCell(-1);
    var cell5 = row.insertCell(-1);

    cell1.innerHTML = item+'<input type="hidden" name="id" value='+id+'>';
    cell2.innerHTML = number+'<input type="hidden" name="number" value='+number+'>';
    cell3.innerHTML = today+'<input type="hidden" name="today" value='+today+'>';
    cell4.innerHTML = note+'<input type="hidden" name="note" value='+note+'>';
    cell5.innerHTML = '<input type="submit" value="削除" onclick="coldel(this)">';
 
}




function coldel(obj) {
    // 削除ボタンを押下された行を取得
	tr = obj.parentNode.parentNode;
    // trのインデックスを取得して行を削除する
    tr.parentNode.deleteRow(tr.sectionRowIndex);
}




