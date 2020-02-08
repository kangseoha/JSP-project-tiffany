<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<!-- product 메인화면  -->
<div class="ftco-blocks-cover-1">
	<div class="ftco-cover-1"
		style="background-image: url('/images/perfuem_main.jpg');">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-lg-6 text-center">
					<h1>
						About <span class="text-primary">perfuem</span>
					</h1>
					<p>알파벳 “T”의 강렬하고 간결한 라인에서 영감을 얻은 Tiffany T 컬렉션은 대담한 디자인으로 당당한
						자신감을 드러냅니다</p>

				</div>
			</div>
		</div>
	</div>
</div>
<!-- product 메인화면  종료-->

<div class="container">

	<div class="card">
		<div class="card-header">제품 수정 업로드</div>
		<div class="card-body">
			<form action="/product?cmd=modifyProc" method="POST"
				enctype="multipart/form-data">
			<input type="hidden" name="productno" value="${product.productno}" />
			<div class="form-group">
					<label for="type">제품 타입(수정불가)</label> 
					<input type="text"
						class="form-control" value="${product.type}" name="type"
						required="required" maxlength="50" readonly="readonly">
				</div>
				
				<div class="form-group">
					<label for="images">제품 이미지 업로더</label> 
					<input type="file" class="form-control" name="images" id="img_input" required="required" >
				</div>
				
				<div class="form-group">
					<label for="productname">제품 이름</label> <input type="text"
						class="form-control" value="${product.productname}" name="productname"
						required="required" maxlength="50">
				</div>
				
				
				<div class="form-group">
					<label for=madeof>재질</label> <input type="text"
						class="form-control" value="${product.madeof}"
						name="madeof" maxlength="50" required="required" >
				</div>
				
				
				<div class="form-group">
					<label for="content">제품 간단 소개</label> <input type="text"
						class="form-control" value="${product.content}" name="content"
						required="required">
				</div>
				
				
				<div class="form-group">
					<label for="detail">제품 상세 소개</label>
					<textarea name="detail" class="form-control" rows="10" cols="5"required="required">${product.detail}</textarea>
				</div>

				<button type="submit" class="btn btn-primary">제품 수정 업로더하기</button>
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
</script>

<%@ include file="/include/footer.jsp"%>