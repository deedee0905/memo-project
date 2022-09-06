<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/static/css/style.css" type="text/css">

<meta charset="UTF-8">
<title>메모</title>
</head>
<body>

	<div class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
	
		<section class="d-flex justify-content-center">
			<div class="content-box">
				<h2 class="text-center mt-3">메모보기</h2>
				<div class="d-flex">
					<label class="col-2">제목 : </label> 
					<input type="text" class="form-control col-10" id="titleInput" value="${post.subject }">
				</div>
				<textarea id="contentInput" class="form-control mt-2" rows="7">${post.content }</textarea>
				
				<div class ="mt-3">
					<img class="w-100" src="${post.imagePath }">
				</div>
				
				<div class="d-flex justify-content-between mt-3 mb-3">
					<div>
						<a href="/post/list/view" class="btn btn-primary " >목록으로</a>
						<a href="#" class="btn btn-danger" id="deleteBtn">삭제</a>
					</div>
					<a href="#" class="btn btn-primary" id="modifyBtn">수정</a>
				</div>
				
			</div>
			
		
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

</body>
</html>