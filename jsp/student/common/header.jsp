<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<% String studentName = (String) session.getAttribute("studentName"); %>
<% String userId = (String) session.getAttribute("userId"); %>
<!-- ナビゲーションバーの作成 -->
<c:if test="${userId != null }">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/drillMaster/jsp/student/home/index.jsp">Drill Master</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/drillMaster/jsp/student/home/index.jsp">Home</a></li>
				<li><a href="/drillMaster/jsp/student/viewQuestion/ViewQuestionServlet">学習問題閲覧</a></li>
				<li><a href="/drillMaster/jsp/student/viewAnswer/ViewAnswerServlet">学習状況</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/drillMaster/jsp/LogoutServlet">ログアウト</a></li>
				<li><a href="#"><% out.println(studentName); %>さん</a></li>
			</ul>
		</div>
	</div>
</nav>
</c:if>
<c:if test="${userId == null }">
	<h2 class="text-center">
		<font color="red">
			ログインし直して下さい
		</font>
		<a href="/drillMaster/jsp/login.jsp" class="btn btn-danger btn-lg active" role="button">ログインページへ</a>
	</h2>
</c:if>