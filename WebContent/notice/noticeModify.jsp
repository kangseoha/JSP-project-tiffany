<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>	

<c:if test="${empty sessionScope.user}">
	<script>
		alert('잘못된 접근입니다.');
		location.href = '/user?cmd=login';
	</script>
</c:if>

<div class="container">
	<div class="card">
		<div class="card-header">문의</div>
		<div class="card-body">
			<form action="/notice?cmd=modifyProc" method="POST">
			<input type="hidden" name="noticeno" value="${noticeVM.notice.noticeno}"/>
			<input type="hidden" name="userno" value="${noticeVM.user.userno}"/>
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" placeholder="문의글 제목" name="title" value="${noticeVM.notice.title}"
						required="required" maxlength="50">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea name="content" id="summernote" class="form-control" rows="10" cols="5" required="required" >${noticeVM.notice.content}</textarea>
				</div>

				<button type="submit" class="btn btn-primary">수정하기</button>
			</form>
		</div>
	</div>
</div>

<script>
	$('#summernote').summernote({
		placeholder : 'Post Page',
		tabsize : 2,
		height : 300
	});
</script>

<%@ include file="/include/footer.jsp"%>



