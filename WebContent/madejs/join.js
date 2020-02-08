var repeatUseridCheck = false;

function useridCheck() {
	var userid = $("#userid").val();
	if (userid == "" || userid == null) {
		alert('username이 입력 되지 않았습니다.');
		return;
	}

	var user = {
		userid : userid
	}

	// JSON.parse(제이슨데이터); - 자바스크립트 오브젝트형식으로 변경해줌
	// JSON.Stringify(자바스크립트오브젝트); - 자제이슨데이터 오브젝스 형식으로 변경해줌

	$.ajax({
		type : "POST",
		url : "/user?cmd=useridCheck",
		dataType : "text",
		contentType : "application/json", // 폼 이외의 데이터는 버퍼로 받음
		data : JSON.stringify(user),
		success : function(data) { // 자동 주입 됨
			console.log(data);
			if (data === "ok") {
				alert('사용할 수 있는 ID입니다.')
				repeatUseridCheck = true;
				$('#userid').attr('readonly', 'readonly');
			} else {
				alert('사용할 수 없는 ID입니다.')
			}
		},
		error : function(data) { // 자동 주입 됨
			console.log(data);
			alert("통신 실패");
		} // 서버는 out.print
	});
}

function validationCheck() {
	if (!repeatUseridCheck) {
		alert('아이디 중복확인을 해주세요.');
	}
	return repeatUseridCheck;
}

function goPopup() {
	var pop = window.open("/user/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr) {
	$('#address').val(roadFullAddr);
}