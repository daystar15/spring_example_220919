<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
  <!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>${title}</h1>
		
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<td>${seller.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${seller.name}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${seller.yyyymmdd}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${seller.email}</td>
			</tr>
			<tr>
				<th>자기소개</th>
				<td>${seller.introduce}</td>
			</tr>
			<!-- DB에 저장될 때는 서울시간으로 저장되어 있으나 변환이 UTC로 됨 -->
			<!-- application.properties의 serverzonetime 때문임, 삭제해야함 -->
			<tr>
				<th>생성일</th>
				<td>${seller.createdAt}</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td>${seller.updatedAt}</td>
			</tr>
		</table>
	</div>
</body>
</html>