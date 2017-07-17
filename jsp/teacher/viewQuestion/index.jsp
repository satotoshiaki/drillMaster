<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Question"%>
<html>
<head>
<title>学習問題一覧</title>
<%@include file="/jsp/common/default.jsp"%>
</head>

<body>
	<div class="container">
		<%@include file="/jsp/teacher/common/header.jsp"%>
		<div class="container-fluid" style="background-color: #FD7; coror: #000">
			<h2 class="text-center">学習問題一覧</h2>
		</div>
		<div class="container-fluid">
			<h1 class="page-header">
				<small>登録されている学習問題の一覧です</small>
			</h1>
			<table class="table table-striped table-bordered">
				<thead>
					<tr class="active">
						<th>学習単元</th>
						<th>対象校種・学年</th>
						<th>問題文</th>
					</tr>
					<c:forEach items="${questionList}" var="question">
						<tr class="active">
							<th><c:out value="${question.getUnitName()}" /></th>
							<th><c:out value="${question.getTarget()}" /></th>
							<th><c:out value="${question.getQuestion_statement()}" /></th>
						</tr>
						<br>
					</c:forEach>
				</thead>
			</table>
		</div>
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>