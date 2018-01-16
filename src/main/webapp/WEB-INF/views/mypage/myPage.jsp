<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/incHeader.jsp" %>

<script type="text/javascript">
$(document).ready(function() {

	$("#saveBtn").click(function() {
		$.ajax({
			url : '/mypage/ajax/insertBoard'
			, data : $("#boardForm").serialize()
			, processData : false
			, type : 'POST'
			, success : function (result) {
				alert(JSON.stringify(result));
				var data = JSON.parse(result);
			}
		});
	});
});

var goPage = function(page) {
	$("#currentPage").val(page);
	$("#boardForm").attr("method", "POST" );
	$("#boardForm").attr("action", "/mypage/myPage" );
	$("#boardForm").submit();
}

var modBoard = function(seq) {
	$("#seq").val(seq);
	$("#title").val($("#title" + seq).val());
	$("#content").text("#content" + seq).text());
}
</script>

<form:form id="boardForm">
	<input type="text" id="seq" name="seq" value="${boardVo.seq }" />

	<table class="table table-striped">
		<tr>
			<th>작성자</th>
			<td>
				<c:out value="${sessionScope.loginUser.name }" />
				(<c:out value="${sessionScope.loginUser.id }" />)
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td>
				<button type="button" id="saveBtn">저장</button>
			</td>
		</tr>
	</table>
</form:form>

<form:form id="myForm">
<input type="text" name="currentPage" id="currentPage" value="${boardVo.currentPage > 0 ? boardVo.currentPage : 1 }" />
	<table class="table table-hover">
		<tbody>
			<c:choose>
				<c:when test="${boardList != null and boardList.size() > 0 }">
					<c:forEach var="item" items="${boardList }" begin="0" end="6" step="1" varStatus="status">
						<tr data-toggle="collapse" data-target="#accordion${item.seq }" class="clickable">
							<td onclick="javascript:modBoard('${item.seq }');"><c:out value="${status.index }" /></td>
							<td onclick="javascript:modBoard('${item.seq }');"><c:out value="${status.count }" /></td>
							<td onclick="javascript:modBoard('${item.seq }');"><c:out value="${item.title }" /></td>
							<td onclick="javascript:modBoard('${item.seq }');"><c:out value="${item.regId }" /></td>
							<td onclick="javascript:modBoard('${item.seq }');"><c:out value="${item.regDate }" /></td>
						</tr>
						<tr>
							<td colspan="5">
								<div id="accordion${item.seq }" class="collapse">
									<c:out value="${item.content }" />
									<input type="text" id="title${item.seq }" value="${item.title }" />
									<textarea class="form-control" rows="5" id="content${item.seq }">${item.content }</textarea>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><th>등록된 글이 없습니다.</th></tr>
				</c:otherwise>
			</c:choose>
		<tbody>
	</table>

	<nav>
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li><a href="javascript:goPage('1');">1</a></li>
	    <li><a href="javascript:goPage('2');">2</a></li>
	    <li><a href="javascript:goPage('3');">3</a></li>
	    <li><a href="javascript:goPage('4');">4</a></li>
	    <li><a href="javascript:goPage('5');">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
</form:form>


<%@include file="/WEB-INF/views/include/incFooter.jsp" %>