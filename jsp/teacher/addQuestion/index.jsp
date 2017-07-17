<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>学習問題登録</title>
<%@include file="/jsp/common/default.jsp"%>
</head>

<body>
	<div class="container">
		<%@include file="/jsp/teacher/common/header.jsp"%>

		<div class="container-fluid" style="background-color: #FD7; coror: #000">
			<h2 class="text-center">学習問題登録</h2>
		</div>
		<div class="container-fluid">
			<h1 class="page-header">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>登録する情報を入力して下さい</small>
			</h1>
			<br>
			<form class="form-horizontal" action="./AddQuestionServlet"
				method="POST">
				<div class="form-group">
					<label class="col-sm-2 control-label">学習単元名:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="unitName"
							maxlength="50" required autofocus>
					</div>
					<div class="col-sm-3">
						<p class="help-block">50文字以内で入力してください。</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">対象校種・学年:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="target"
							maxlength="10" required>
					</div>
					<div class="col-sm-3">
						<p class="help-block">10文字以内で入力してください。</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">問題文:</label>
					<div class="col-sm-7">
						<textarea class="form-control" name="questionStatement"
							maxlength="1000" required> </textarea>
					</div>
					<div class="col-sm-3">
						<p class="help-block">1000文字以内で入力してください。</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10 text-right">
						<button class="btn btn-lg btn-primary" type="submit" name="add"
							value="Add">新規登録</button>
					</div>
				</div>

				<%@include file="/jsp/common/footer.jsp"%>
			</form>
		</div>
	</div>
</body>
</html>