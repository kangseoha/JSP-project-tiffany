<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>
<div class="container">
	<div class="card">
		<div class="card-header">로그인</div>
		<div class="card-body">
			<form action="/user?cmd=loginProc" method="POST">
				<div class="form-group">
					<label for="userid">아이디</label> <input type="text"
						value="${cookie.useridCookie.value}" class="form-control" placeholder="Enter ID" name="userid"
						required="required" maxlength="20">
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label> <input type="password"
						class="form-control" placeholder="Enter password" name="password"
						required="required" maxlength="12">
				</div>
				<div class="form-group form-check">
					<label class="form-check-label"> <c:choose>
							<c:when test="${empty cookie.useridCookie.value}">
								<input class="form-check-input" type="checkbox"
									name="rememberMe"> 아이디 기억하기
						</c:when>
							<c:otherwise>
								<input class="form-check-input" type="checkbox"
									name="rememberMe" checked> 아이디 기억하기
						</c:otherwise>
						</c:choose>



					</label>
				</div>


				<button type="submit" class="btn btn-primary">로그인</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>