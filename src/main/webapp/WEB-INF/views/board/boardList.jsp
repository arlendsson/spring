<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/incHeader.jsp" %>

<script type="text/javascript">

</script>

<form id="myForm" name="myForm">
	<table class="table table-striped">
		<%-- 
		<c:forEach var="item" items="${list}" begin=0 end=5 step=1 varStatus="status">
		    번호 : ${status.count}
		    이름 : ${item.name}
		    나이 : ${item.age}
		    주소 : ${item.addr}
		</c:forEach>
		출처: http://fruitdev.tistory.com/132 [과일가게 개발자]
		 --%>
		<c:forEach var="item" begin="0" end="6" step="1" varStatus="status">
			<tr>
				<th><c:out value="${status.index }" /></th>
				<td><c:out value="${status.count }" /></td>
				<td>가가</td>
				<td>나나</td>
			</tr>
		</c:forEach>
		
	</table>
</form>

<%@include file="/WEB-INF/views/include/incFooter.jsp" %>