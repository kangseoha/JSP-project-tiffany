<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- product 메인화면  -->
<div class="ftco-blocks-cover-1">
<h1></h1>

	<!--  c문법 사용하여 퍼퓸이면, 링이면, 시계면 돌리기 -->
	<c:choose>
		<c:when test ="${cookie.type.value eq 'ring'}">		
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
							<p>사랑과 아름다움은 티파니가 추구하는 본질입니다. 병 속에 담은 티파니 향수가 사랑과 아름다움을 선사합니다.</p>
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

<c:choose>

<c:when test="${sessionScope.user.admin == 1}">
<div class="container">
<a href="/product?cmd=write" class="btn btn-primary col-md-2 float-right m-2" >제품 업로드</a>
</div>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
<br/>
<div class="site-section">
	<div class="container">
		<div class="row align-items-stretch">
			
				<!--  반복구간 -->
				
				
				<c:forEach var="productList" items="${productList}">
				<div class="col-lg-4 col-md-6 mb-5">
					<div class="post-entry-1 h-50">
					 	<a href="/product?cmd=detail&productno=${productList.productno}"> <img src="/upload/${productList.images}"		 	
							alt="Image" class="img-fluid">
						</a>
						<div class="post-entry-1-contents">

							<span class="meta">${productList.productname}</span>
							<h2>${productList.madeof}</h2>
							<p>${productList.content}</p>

						</div>
					</div>
					</div>
				</c:forEach>
				
				<!--  반복구간 끝 -->

			
		</div>
	</div>
</div>

 


<%@ include file="/include/footer.jsp"%>