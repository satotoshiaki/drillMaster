<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Student"%>
<html>
<head>
<title>学習者一覧</title>
<%@include file="/jsp/common/default.jsp"%>
</head>

<body>
	<div class="container">
		<%@include file="/jsp/teacher/common/header.jsp"%>
		<div class="container-fluid"
			style="background-color: #FD7; coror: #000">
			<h2 class="text-center">学習者一覧</h2>
		</div>
		<div class="container-fluid">
			<h1 class="page-header">
				<small>登録されている学習者の一覧です</small>
			</h1>
			<table class="table table-striped table-bordered">
				<thead>
					<tr class="active">
						<th class="col-sm- 3">ユーザーid</th>
						<th class="col-sm- 3">学習者名</th>
						<th class="col-sm- 3">校種・学年</th>
						<th class="col-sm- 3"></th>
					</tr>
					<c:forEach items="${studentList}" var="student">
						<tr class="active">
							<th><c:out value="${student.getUserID()}" /></th>
							<th><c:out value="${student.getStudentName()}" /></th>
							<th><c:out value="${student.getStudentAge()}" /></th>
							<th>
								<div class="text-right">
									<form class="form-horizontal" method="POST" action="./ViewAnswerServlet">
										<input type="hidden" value="${student.getUserID()}"
											name="userId" />
										<button class="btn btn-lg btn-success" type="submit"
											name="view" value="View">学習問題解答一覧</button>
										&nbsp;&nbsp;
									</form>
								</div>
							</th>
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