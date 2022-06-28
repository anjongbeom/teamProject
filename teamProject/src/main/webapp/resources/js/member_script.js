



/* 아이디 중복체크 */
function idOverlap(){
	member_id = document.getElementById("member_id").value;
	
	console.log("idOverlap 호출");
	console.log("아이디 입력 값 : ", member_id);
	
	$.ajax({
		type :"post",
		url :"/member/idOverlap",
		data : {"member_id" : member_id},
//		JSON형식 안에 JSON 형식으로 표현한 데이터. 
//	    "파라미터 이름" : 폼태그에 적은 NAME 값.ID입력창의 NAME값.value 여러 개 가능 
//		dataType : "text",	/* text, xml, html, script, json, jsonp  
		success : function(data){	
			if(data=="true"){
				alert("이 아이디는 사용 가능합니다.");
			}else{	//ajax가 제대로 안됐을 때 .
				alert("이 아이디는 사용 불가능합니다.");
			}
		},
		error : function(){
			alert("아이디 중복 확인 ajax 실행 실패");
		}
	});
	
}



/* 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치, 그렇지 않으면 불일치 라는 텍스트 출력.*/
function passConfirm() {
// 	alert("ddd");
	var member_pw = document.getElementById('member_pw');	//비밀번호 
	var member_pw2 = document.getElementById('member_pw2');	// 비밀번호 확인 값
	var confrimMsg = document.getElementById('confirmMsg');	// 확인 메세지
	var correctColor = "#77ee77";	// 맞았을 때 출력되는 색깔.
	var wrongColor ="#ff0000";	// 틀렸을 때 출력되는 색깔
	
	if(member_pw.value == member_pw2.value){ //password 변수의 값과 passwordConfirm 변수의 값과 동일하다.
		confirmMsg.style.color = correctColor; /* span 태그의 ID(confirmMsg) 사용  */
		confirmMsg.innerHTML ="비밀번호 일치"; /* innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용하는 것. */
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호 불일치";
	}
}




