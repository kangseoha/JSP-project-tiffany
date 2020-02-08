<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<%@ include file="/include/header.jsp"%>



<div class="container">
	<div class="card">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성일자</th>
					<th scope="col">작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="noticeVM" items="${noticeListVM}">


					<tr>
						<th scope="row">${noticeVM.notice.noticeno}</th>
						<td><a
							href="/notice?cmd=detail&noticeno=${noticeVM.notice.noticeno}">${noticeVM.notice.title}</a></td>
						<td>${fn:substring({noticeVM.notice.noticeCreateTime},1,17)}</td>
						<td>${noticeVM.user.username}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>




	</div>

	<div id="page_control" class="text-center">
	<c:choose>
		<c:when test="${param.pageno-1 == 0 }">
			
				<a href="#" class="btn btn-info col-sm-2 m-5">Prev</a>
		
		</c:when>
	<c:otherwise>
	
			<a href="/notice?cmd=list&pageno=${param.pageno-1}"
				class="btn btn-info col-sm-2 m-5">Prev</a>
			
		</c:otherwise>
	</c:choose>

	<c:choose>
	<c:when test="${param.pageno>=lastpage}">
		
			<a href="#" class="btn btn-info col-sm-2 m-5">Next</a>
			
	</c:when>
		<c:otherwise>
			
			<a href="/notice?cmd=list&pageno=${param.pageno+1}"
				class="btn btn-info col-sm-2 m-5">Next</a>
			
		</c:otherwise>
	</c:choose>
</div>

	<a href="/notice?cmd=write"
		class="btn btn-primary col-sm-4 float-right m-2">글쓰기</a>

</div>


<%@ include file="/include/footer.jsp"%>

