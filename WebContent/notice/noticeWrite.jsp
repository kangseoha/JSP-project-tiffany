<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>	


<div class="container">
	<div class="card">
		<div class="card-header">문의</div>
		<div class="card-body">
			<form action="/notice?cmd=writeProc" method="POST">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" placeholder="문의글 제목" name="title"
						required="required" maxlength="50">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea name="content" id="summernote" class="form-control" rows="10" cols="5" required="required" placeholder="문의 글 작성"></textarea>
				</div>

				<button type="submit" class="btn btn-primary">글쓰기</button>
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



