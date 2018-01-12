<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/incHeader.jsp" %>

<script type="text/javascript">
// 스프링 시큐리티 403 오류
$(function () {
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
		xhr.setRequestHeader("AJAX", true);
	});
});

$(document).ready(function () {
	$("#testBtn").click(function () {
		$.ajax({
			url : '/mypage/ajax/data'
			, data : $("#myForm").serialize()
			, processData : false
			, type : 'POST'
			//, dataType : 'application/json'
			, success : function (result) {
				var data = JSON.parse(result);
				if (data.success) {
				} else {
					$("#body").html(result);
				}
			}
			, error : function () {
				alert('ajax error');
			}
		});
	});
	
	$("#loginBtn").click(function () {
		/* 안됨
		var myForm = document.getElementById('myForm');
		var formData = new FormData(myForm);
		var formData = new FormData();
		formData.append('id', 'tete');
		formData.append('pw', 'zzzzzz');
		 */
		
		$.ajax({
			url : '/login/login'
			, data : $("#myForm").serialize()
			, processData : false
			, type : 'POST'
			, success : function (result) {
				var data = JSON.parse(result);
				if (data.success) {
					$("#name").val(data.loginUser.name);
				}
				//location.href = '/mypage/myPage';
			}
		});
	});
});

</script>

<form id="myForm" name="myForm">
	<div class="row">
	<input type="text" class="form-control" placeholder="" id="name" name="name" value="" />
	</div>
	
	<div class="row">
		<div class="col-lg-6">
			<div class="input-group">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">&nbsp;&nbsp;&nbsp;</button>
				</span>
				<input type="text" class="form-control" placeholder="아이디 입력" id="id" name="id" value="test" />
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->
		<div class="col-lg-6">
			<div class="input-group">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">&nbsp;&nbsp;&nbsp;</button>
				</span>
				<input type="password" class="form-control" placeholder="패스워드 입력" id="pw" name="pw" value="1234" />
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="loginBtn">Go!</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
	
	<button class="" type="button" id="testBtn">ajax test</button>
</form>

<%@include file="/WEB-INF/views/include/incFooter.jsp" %>