<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
  <!-- AJAX를 사용할 때는 제이쿼리 원본을 사용해야한다. -->
  <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
  
  <!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<form method="post" action="/lesson06/ex01/add_user"> <!-- 저장만 하는 용도라 view가 없음 -->
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예) 19881120">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일을 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="5"></textarea>
			</div>
			<!-- form 태그를 위한 submit 버튼 -->
			<!-- <input type="submit" class="btn btn-success" value="회원가입"> -->
			
			<!-- AJAX를 위한 버튼, type="button"을 꼭 명시해주어야한다. -->
			<input type="button" id="join" class="btn btn-success" value="회원가입"> 
		</form>
	</div>
	<script>
		$(document).ready(function(){
			// 1) jQuery의 submit 기능 이용하기
			/* $("form").on("submit", function(e) { // e객체를 선언해줘야 밑에서 메소드를 사용할 수 있다.
				// alert("서브밋");
				// e.preventDefault(); // 서브밋 되는 것을 막는다. submit버튼을 눌러도 화면이 머물러져 있다.
				
				// validation
				let name = $("#name").val().trim();
				if (name.length == '') {
					alert("이름을 입력하세요");
					return false; // submit일 때는 return false를 해주어야 submit이 동작하지 않는다.
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요.");
					return false;
				}
				
				// 여기까지 도달하면 submit
				alert("서브밋");
			}); */
			
			// 2) jQuery의 AJAX 통신 이용하기
			$("#join").on("click", function() {
				// alert("aaaa");
				// validation
				let name = $("#name").val().trim();
				if (name.length == '') {
					alert("이름을 입력하세요");
					return;
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim();
				if (yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요.");
					return;
				}
				
				if (isNaN(yyyymmdd)) { // 잘못했을 때 true가 된다. 모두 숫자가 아닌 경우 참
					alert("숫자만 입력해주세요");
					return;
				}
				
				// 데이터 취합
				let email = $("#email").val().trim();
				console.log(email); // 온전한 값인지 미리 확인하기, ajax에서 보낼 data가 있는지 확인하기 위해서
				
				let introduce = $("#introduce").val(); 
				console.log(introduce);
				
				// AJAX, 서버로 보내기
				$.ajax({
					// Request, 키명은 소문자로 적는다.
					type: "POST"
					, url: "/lesson06/ex01/add_user" // jsp로 보내는 화면으로 못보냄
					// "리퀘스트파라미터명" : 변수(미리 변수를 만들어야한다.)
					, data: {"name": name, "yyyymmdd": yyyymmdd, "email": email, "introduce": introduce}
					
					// Response
					, success:function(data) { // data는 변수이름(관례적으로 사용)
						alert(data);
						// 화면 이동
						location.href = "/lesson06/ex01/after_add_user_view";
					} // 성공
					, complete:function(data) {
						alert("완료");
					} // 성공, 실패 둘 다, 잘 안씀
					, error:function(e) {
						alert("에러");
					} // 실패
					
				});
			})
		});
	</script>
</body>
</html>