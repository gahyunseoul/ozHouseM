<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상품 문의 답변 -->
<link rel="stylesheet" type="text/css" href="resources/merchant/css/board_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../storeMain/storeManagementTop.jsp" %>
<%@ include file="board_top.jsp" %>
<head>
<title>OZ의 집 : 상품 문의 답변</title>
<script>
	function validateForm() {
	  var product_reQA_content = document.forms["f"]["product_reQA_content"].value;
	  
	  if (product_reQA_content == null || product_reQA_content.trim() === "") {
	    alert("내용을 입력해주세요.");
	    return false; 
	  }
	  return true;
	}
</script>
</head>

<div class="container">
	<div class="content-container">
	    <h1 class="board-header">상품 문의 상세보기</h1>
		<div class="flex-container">
			<c:forEach var="dto" items="${productContent}">
				<div class="flex-row">
					<div class="flex-cell">글번호</div>
					<div class="flex-cell">${dto.product_QA_num}</div>
					<div class="flex-cell">제품명</div>
					<div class="flex-cell">${dto.product_name}</div>
					<div class="flex-cell">문의 유형</div>
					<div class="flex-cell">${dto.product_inquiry_type}</div>
				</div>
				<div class="flex-row">
					<div class="flex-cell">작성자</div>
					<div class="flex-cell">${dto.member_id}</div>
					<div class="flex-cell">작성일</div>
					<div class="flex-cell">${dto.product_QA_date}</div>
				</div>
				<div class="flex-row">
					<div class="flex-cell">글내용</div>
					<div class="flex-cell-sub">${dto.product_QA_content }</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<form name="f" action="product_reqa.do?product_QA_num=${product_QA_num }" method="post" onsubmit="return validateForm()">
		<input type="hidden" name="product_reQA_num" value="${product_QA_num}">
		<input type="hidden" name="product_num" value="${product_num}">
		<input type="hidden" name="member_id" value="${member_id}">
		<div class="content-container">
			<h1 class="board-header">답변 하기</h1>
			<div class="flex-container">
				<div class="flex-row">
					<div class="flex-cell">내 용</div>
					<div class="flex-cell-sub"><textarea name="product_reQA_content" rows="11" cols="40" class="box"></textarea></div>
				</div>
				<div class="button-group">
						<input type="submit" value="답변 작성">
						<input type="reset" value="다시작성">
						<c:set var="mer_num" value="${merchantLoginMember.mer_num}"/>
						<input type="button" value="목록 보기" onclick="window.location='board_productBoard.do?mer_num=${mer_num}'">
				</div>
			</div>
		</div>
	</form>
</div>
