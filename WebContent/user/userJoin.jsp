<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>
<div class="container">
	<div class="card">
		<div class="card-header">회원 가입</div>
		<div class="card-body">
			<form action="/user?cmd=joinProc" method="POST"
				onsubmit="return validationCheck()">
				<div class="form-group">

					<label for="userid">아이디</label>
					<button onclick="useridCheck()" type="button"
						class="btn btn-primary float-right">중복확인</button>
					<input id="userid" type="text" class="form-control"
						placeholder="Enter Userid" name="userid" required="required"
						maxlength="20">
				</div>

				<div class="form-group">
					<label for="username">이름 </label> <input type="text"
						class="form-control" placeholder="Enter username" name="username"
						required="required" maxlength="12">
				</div>



				<div class="form-group">
					<label for="password">비밀번호</label> <input type="password"
						class="form-control" placeholder="Enter password" name="password"
						required="required" maxlength="12">
				</div>



				<div class="form-group">
					<label for="email">이메일주소</label> <input type="email"
						class="form-control" placeholder="Enter email" name="email"
						required="required" max="30">
				</div>



				<div class="form-group">
					<label for="address">주소</label>
					<button onclick="goPopup()" type="button"
						class="btn btn-primary float-right">주소찾기</button>
					<input type="text" class="form-control" placeholder="Enter address"
						id="address" name="address" required="required"
						readonly="readonly">
				</div>
				
					<div class="form-group">
						<label for="tel">전화번호</label>
						<input type="number"
							class="form-control" placeholder="Enter tel" name="tel"
							required="required">

					</div>


			
					<br />
					<button type="submit" class="btn btn-primary">회원가입</button>
			</form>
		</div>
	</div>
</div>

<script src="/madejs/join.js"></script>
<%@ include file="/include/footer.jsp"%>
