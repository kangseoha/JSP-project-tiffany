<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>

<!-- product 메인화면  -->
<div class="ftco-blocks-cover-1">
	<h1></h1>

	<!--  c문법 사용하여 퍼퓸이면, 링이면, 시계면 돌리기 -->
	<c:choose>
		<c:when test="${cookie.type.value eq 'ring'}">
			<div class="ftco-cover-1"
				style="background-image: url('/images/ring_main.jpg'
        );">
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center">
							<h1>
								About <span class="text-primary">ring</span>
							</h1>
							<p>알파벳 “T”의 강렬하고 간결한 라인에서 영감을 얻은 Tiffany T 컬렉션은 대담한 디자인으로 당당한
								자신감을 드러냅니다</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${cookie.type.value eq 'watch'}">
			<div class="ftco-cover-1"
				style="background-image: url('/images/watch_main.jpg'
        );">
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center">
							<h1>
								About <span class="text-primary">watch</span>
							</h1>
							<p>티파니 워치는 기술적 기교와 혁신적 디자인을 선보입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${cookie.type.value eq 'perfuem'}">
			<div class="ftco-cover-1"
				style="background-image: url('/images/perfuem_main.jpg'
        );">
				<div class="container">
					<div class="row align-items-center justify-content-center">
						<div class="col-lg-6 text-center">
							<h1>
								About <span class="text-primary">perfuem</span>
							</h1>
							<p>사랑과 아름다움은 티파니가 추구하는 본질입니다. 병 속에 담은 티파니 향수가 사랑과 아름다움을
								선사합니다.</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<%@ include file="/include/header.jsp"%>
		</c:otherwise>

	</c:choose>



	<!--  c문법 사용하여 퍼퓸이면, 링이면, 시계면 돌리기 끝 -->
</div>


<!-- product 메인화면  종료-->


<div class="site-section ">
	<div class="container site-section">
		<div class="row align-items-stretch feature-2">
			<div class="col-lg-4 feature-2-img">
				<img src="/upload/${product.images}" alt="Image" class="img-fluid">
			</div>
			<div class="col-lg-8 feature-2-contents pl-lg-5">
				<div class="fixed-content">
					<span class="caption">${product.productname}</span>
					<h2 class="heading-39291">${product.madeof}</h2>
					<p>${product.content}</p>
					<p>${product.detail}</p>
				</div>
				<c:if test="${sessionScope.user.admin eq 1}">
	<a href="/product?cmd=modify&productno=${product.productno}"
	class="btn btn-warning m-1 ">제품 수정</a>&nbsp;
				<button id="delete" type="button" class="btn btn-danger m-1">삭제</button>&nbsp;
			</c:if>
			</div>
		</div>
	</div>
</div>

<form id="deleteForm" action="/product?cmd=delete" method="POST">
	<input type="hidden" name="productno" value="${product.productno}" />
	<input type="hidden" name="type" value="${product.type}" />
</form>

<script>
	$('#delete').on('click', function() {
		$('#deleteForm').submit();
	});
</script>



<!--  디테일 푸더 -->
<c:choose>
	<c:when test="${cookie.type.value eq 'ring'}">
		<%@ include file="/include/ringDatail.jsp"%>
	</c:when>
	<c:when test="${cookie.type.value eq 'watch'}">
		<%@ include file="/include/watchDatail.jsp"%>
	</c:when>
	<c:when test="${cookie.type.value eq 'perfuem'}">
		<%@ include file="/include/perfuemDatail.jsp"%>
	</c:when>
</c:choose>


<%@ include file="/include/footer.jsp"%>