/**
 * 
 */
 
//今日の日付
var today = new Date();
today.setDate(today.getDate());
var yyyy = today.getFullYear();
var mm = ("0"+(today.getMonth()+1)).slice(-2);
var dd = ("0"+today.getDate()).slice(-2);
document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;

//入庫日：過去の日付のエラーチェック
function isDate(dateVal){
	var date = new Date(dateVal)
	var today = new Date();
	if(date < today){
		swal("過去の日付が入力されました" + "\n" + "入力された値：　" + dateVal)
		document.getElementById("today").value='';
		console.log(today);
	}
}
//入庫数：自然数以外のエラーチェック
function isNumber(numVal){
	var pattern = /^([1-9]\d*|0)$/
	if(!(pattern.test(numVal))){
		swal("無効な値が入力されました" + "\n" + "入力された値：　" + numVal);
		document.getElementById('number').value = 1;		
	}
}
//備考：文字数制限のエラーチェック
function isNote(noteVal){
	var text = document.getElementById('note_tag');
	var note = document.getElementById('r_note')
	if(255-noteVal.length < 0){
		swal("入力可能文字数を超えました");
		note.value = noteVal.substr(0,255);
	}
	text.innerText = 255-note.value.length;
}

//更新ボタンの挙動
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

		var options = {
        text:"商品名："+ item +"  入庫数："+ number +"  入庫日："+ today + "\n"  + "で登録しますか？", //\nでテキストの改行が出来ます
	        buttons: {
	            cancel: 'キャンセル',
	            ok: '登録する'
	        }
	    };
	    swal(options).then(function(value){
	        switch(value){
	            case "ok"://登録するを選んだ場合の処理
	            	coladd(item,number,today,note,id);
				case null:
					//入庫数、入庫日、備考の初期化
					var date = new Date();
					date.setDate(date.getDate());
					var yyyy = date.getFullYear();
					var mm = ("0"+(date.getMonth()+1)).slice(-2);
					var dd = ("0"+date.getDate()).slice(-2);
					document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;
					document.getElementById('number').value = "";
					document.getElementById('r_note').value = "";
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




