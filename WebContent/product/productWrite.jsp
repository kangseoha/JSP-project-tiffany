<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<!-- product 메인화면  -->
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

<!-- product 메인화면  종료-->

<div class="container">

	<div class="card">
		<div class="card-header">제품 업로드</div>
		<div class="card-body">
			<form action="/product?cmd=writeProc" method="POST"
				enctype="multipart/form-data">

			<div class="form-group">
					<label for="type">제품타입</label> 
					<select id="type" size="1" class="form-control" name="type">
						<option value="ring">ring</option>
						<option value="watch">watch</option>
						<option value="perfuem">perfuem</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="images">제품 이미지 업로더</label> 
					<input type="file" class="form-control" name="images" id="img_input" required="required">
				</div>
				
				<div class="form-group">
					<label for="productname">제품 이름</label> <input type="text"
						class="form-control" placeholder="product name" name="productname"
						required="required" maxlength="50">
				</div>
				
				
				<div class="form-group">
					<label for=madeof>재질</label> <input type="text"
						class="form-control" placeholder="made of" name="madeof"
						required="required" maxlength="50">
				</div>
				
				
				<div class="form-group">
					<label for="content">제품 간단 소개</label> <input type="text"
						class="form-control" placeholder="content" name="content"
						required="required" maxlength="50">
				</div>
				
				
				<div class="form-group">
					<label for="detail">제품 상세 소개</label>
					<textarea name="detail" class="form-control" rows="10" cols="5"placeholder="detail" required="required"></textarea>
				</div>

				<button type="submit" class="btn btn-primary">제품 업로더 하기</button>
			</form>
		</div>
	</div>
</div>
<script>
	$("#img_input").on("change", handleImgFile);

	function handleImgFile(e) {
		console.log(e);
		console.log(e.target);
		console.log(e.target.files);
		console.log(e.target.files[0]);
		var f = e.target.files[0];

		if (!f.type.match("image.*")) {
			console.log("이미지타입이 아닙니다.");
			alert('이미지타입이 아닙니다.')
			return;
		}
		var reader = new FileReader();

		reader.onload = function(e) {
			console.log("================");
			console.log(e.target);
			console.log(e.target.result);
			$("#img_warp").attr("src", e.target.result);
		}

		reader.readAsDataURL(f);

	}

	
	$('#summernote').summernote({
		placeholder : 'Post Page',
		tabsize : 2,
		height : 300
	});


</script>

<%@ include file="/include/footer.jsp"%>