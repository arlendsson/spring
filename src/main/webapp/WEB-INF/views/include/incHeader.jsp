<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="requestURI" value="<%=request.getRequestURI()%>"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta name="_csrf" content="${_csrf.token}"/>

<!-- 부트스트랩 -->
<link
	href="<c:out value="${contextPath }" />/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script
	src="<c:out value="${contextPath }" />/resources/js/bootstrap.min.js"></script>

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>코딩</title>

</head>
<body>

<ul class="nav nav-tabs" id="menuBar">
	<li role="presentation" <c:if test="${fn:indexOf(requestURI, 'loginPage') }"> class="active"</c:if>>
		<a href="<c:out value="${contextPath }" />/login/loginPage">Home</a>
	</li>
	<li role="presentation" <c:if test="${fn:indexOf(requestURI, 'myPage') }"> class="active"</c:if>>
		<a href="<c:out value="${contextPath }" />/mypage/myPage">My Page</a>
	</li>
	<li role="presentation" <c:if test="${fn:indexOf(requestURI, 'boardList') }"> class="active"</c:if>>
		<a href="<c:out value="${contextPath }" />/board/boardList">Board</a>
	</li>
</ul>

<div id="contents" style="width: 100%;">
