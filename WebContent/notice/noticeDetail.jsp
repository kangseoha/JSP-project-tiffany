<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>


<div class="container">
	<div class="card">
		<div class="col-sm-8 mx-auto">
			<div id="title" class="m-4">
				<h2>
					<b>${NoticeListVM.notice.title}</b>
				</h2>
			
					
			</div>

			<hr />

			<div class="d-flex align-items-center">




				<c:choose>
					<c:when
						test="${sessionScope.user.userid eq NoticeListVM.user.userid}">
						<a
							href="/notice?cmd=modify&noticeno=${NoticeListVM.notice.noticeno}&userno=${NoticeListVM.user.userno}"
							class="btn btn-warning m-1 ">수정</a>&nbsp;
				<button id="delete" type="button" class="btn btn-danger m-1">삭제</button>&nbsp;
	</c:when>
					<c:when test="${sessionScope.user.admin eq 1}">
						<button id="delete" type="button" class="btn btn-danger m-1">삭제</button>&nbsp;
	</c:when>

				</c:choose>
				<a href="/notice?cmd=list&pageno=1" class="btn btn-primary m-1">목록</a>
				<span id="username" class="ml-auto">${NoticeListVM.user.username}</span>
				
			</div>
			<span class="ml-auto">${fn:substring({NoticeListVM.notice.noticeCreateTime},1,17)}</span>
					
			<br />
			<div id="content">${NoticeListVM.notice.content}</div>
		</div>

		<br /> <br />

		<div class="input-group col-sm-8 mx-auto">
			<div class="container">
				<div class="row">
					<div class="col-md-8 blog-content">
						<ul class="comment-list">

							<c:forEach var="comment" items="${NoticeListVM.comment}">
								<li class="comment">
									<div class="vcard bio">
										<img src="images/p10.jpg"
											alt="Free Website Template by Free-Template.co">
									</div>

									<div class="comment-body">
										<h3>${comment.username}</h3>
										<div class="meta">${fn:substring({comment.commentCreateTime},1,17)}</div>
										<p>${comment.content}</p>


										<c:choose>
											<c:when
												test="${sessionScope.user.userno eq comment.userno || sessionScope.user.admin eq 1}">

												<button id="deleteComment"
													onclick="deleteComment(${NoticeListVM.user.userno} ${comment.commentno},${NoticeListVM.notice.noticeno})"
													type="button" class="btn btn-danger m-1">삭제</button>
											</c:when>

										</c:choose>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>

			<form action="/notice?cmd=commentWrite" method="POST">
				<input type="hidden" name="userno"
					value="${sessionScope.user.userno}" /> <input type="hidden"
					name="noticeno" value="${NoticeListVM.notice.noticeno}" />
				<textarea rows="2" cols="70"
					class="w3-input w3-border newLogin col-sm-8" name="content"
					required="required"></textarea>
				<div class="form-group">
					<input type="submit" value="댓글 작성"
						class="btn btn-primary btn-md text-white">
				</div>
			</form>
			<br />
		</div>
	</div>
</div>
</div>

<form id="deleteForm" action="/notice?cmd=delete" method="POST">
	<input type="hidden" name="noticeno"
		value="${NoticeListVM.notice.noticeno}" /> <input type="hidden"
		name="userno" value="${NoticeListVM.user.userno}" />
</form>



<form id="deleteCommentForm" action="/notice?cmd=commentdelete"
	method="POST">
	<input id="commentno" type="hidden" name="commentno" value="" /> <input
		id="userno" type="hidden" name="userno" value="" /><input
		id="noticeno" type="hidden" name="noticeno" value="" />

</form>






<script>
	$('#delete').on('click', function() {
		$('#deleteForm').submit();
	});

	function deleteComment(userno, commentno,noticeno){
		$('#deleteCommentForm #userno').attr('value',userno);
		$('#deleteCommentForm #commentno').attr('value',commentno);
		$('#deleteCommentForm #noticeno').attr('value',noticeno);
		// submit
	 $('#deleteCommentForm').submit();
	}

	
</script>

<%@ include file="/include/footer.jsp"%>