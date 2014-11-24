/**
 * 
 */


function viewData(bno) {
	var curbno = document.form1.bbsno;
	curbno.value = bno;
	
	var prebno = document.form1.prebbsno.value;
	
	if(prebno === "" || prebno === null){
		prebno = bno;
	}

	var prediv = document.getElementById("viewContent_"+prebno);
	if(curbno.value !== prebno && prediv !== ""){
		prediv.innerHTML = "";
		document.form1.prebbsno.value = bno;
	}
	
	if(curbno.value === prebno && prediv === ""){
		var div = document.getElementById("viewContent_"+bno); 
		div.innerHTML = "";
		prebno = "";
		return;
	}
	
	var div = document.getElementById("viewContent_"+bno);
	if(div.innerHTML !== ""){
		div.innerHTML = "";
		return;
	} 
	
	  var xhr = 
		  (typeof XMLHttpRequest != 'undefined')
	    ? new XMLHttpRequest()
	    : new ActiveXObject('Microsoft.XMLHTTP');
	  xhr.open("GET", "view?bbsno="+bno, false);
	  xhr.onreadystatechange = function() {
	    var status;
	    var data;
	    if (xhr.readyState == 4) { 
	      status = xhr.status;
	      if (status == 200) {
	    	
	        data = xhr.responseText;
	        div.innerHTML = data;
	        
	        //이벤트 추가 시키기 위해서는 head에 append시켜줘야한다.
	        var head= document.getElementsByTagName('head')[0];
	        var script= document.createElement('script');
	        script.type= 'text/javascript';
	        script.innerHTML = "EventUtil.addHandler(modifybtn, 'click', function(event){" + 
	        					"modifyData();" +
	        					"});" + 
	        					"EventUtil.addHandler(deletebtn, 'click', function(event){" + 
	        					"deleteData();" +
	        					"});" + 
	        					"EventUtil.addHandler(replybtn, 'click', function(event){" + 
	        					"reCreData();" +
	        					"});";
	        head.appendChild(script);
	        
	      } else {
	    	  alert("불러오기 실패");
	      }
	    }
	  };
	  xhr.send();
}

function deleteData(){
	confirm('정말 삭제하시겠습니까?');
	document.form1.method = "get";
	document.form1.action = "delete";
	document.form1.page.value = 1;
	document.form1.submit();
}

//값이 없으면 알아서 빈칸으로 인식..
function writeData(){
	document.form1.method = "get";
	document.form1.action = "write";
//	document.form1.page.value = 1;
	document.form1.submit();
}

function modifyData(){
	var bno = document.form1.bbsno.value;
	var div = document.getElementById("viewContent_"+bno);
	//var realcontent = document.getElementById("realContent");
	
	  var xhr = 
		  (typeof XMLHttpRequest != 'undefined')
	    ? new XMLHttpRequest()
	    : new ActiveXObject('Microsoft.XMLHTTP');
	  xhr.open("GET", "modify?bbsno="+bno, false);
	  xhr.onreadystatechange = function() {
	    var status;
	    var data;
	    if (xhr.readyState == 4) { 
	      status = xhr.status;
	      if (status == 200) {
	        data = xhr.responseText;
	        div.innerHTML = data;
	      } else {
	    	  alert("불러오기 실패");
	      }
	    }
	  };
	  xhr.send();
}


function goPage(pageNo){
	document.form1.page.value = pageNo;
	document.form1.submit();
}

function goSearch(){
	document.form1.page.value = 1;
	document.form1.submit();
}


function reCreData(){
	document.rwForm.method = "POST";
	document.rwForm.action="reply/write";
	document.rwForm.submit();
}

//댓글 삭제.
function reDelete(replyNo){
	confirm('정말 삭제하시겠습니까?');
	document.form3.method ="get";
	document.form3.action = "reply/delete";
	document.form3.replyNo.value = replyNo;

	document.form3.submit();
	
}

//댓글 수정 화면 전환
function reModify(replyNo){
	var div = document.getElementById("reContent_" + replyNo);
	var replyContent = div.firstChild.nodeValue;
	if(replyContent !== null){
		div.innerHTML = "<div class='input-group'><input type='hidden' id='mod_replyNo' value='"+replyNo+"'>"
		+"<input id='mod_reply' type='text' class='form-control input-sm chat_input' value='"+ replyContent +"' />"
		+ "<span class='input-group-btn'><button class='btn btn-default btn-sm' id='completemodbtn'>Complete</button></span></div>";
		
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.innerHTML = "EventUtil.addHandler(completemodbtn, 'click', function(event){" + 
        					"reUpdate();" +
        					"})";
        head.appendChild(script);
	}
}

//댓글 수정 처리 함수.
function reUpdate(){
	var reply = document.getElementById('mod_reply').value;
	var replyNo = document.getElementById('mod_replyNo').value;
	
	document.form3.method = "POST";
	document.form3.action = "reply/modify";
	document.form3.reply.value = reply;
	document.form3.replyNo.value = replyNo;
	document.form3.submit();
	
	
}



