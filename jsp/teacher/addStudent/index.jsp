<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>学習者登録</title>
<%@include file="/jsp/common/default.jsp"%>
</head>

<body>
	<div class="container">
		<%@include file="/jsp/teacher/common/header.jsp"%>
		<div class="container-fluid" style="background-color: #FD7; coror: #000">
			<h2 class="text-center">学習者登録</h2>
		</div>
		<div class="container-fluid">
			<h1 class="page-header">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>登録する情報を入力して下さい</small>
			</h1>
			<br>
			<form class="form-horizontal" action="./AddStudentServlet"
				method="POST">
				<div class="form-group">
					<label class="col-sm-2 control-label">学習者名:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="studentName" maxlength="50"
							required autofocus></input>
					</div>
					<div class="col-sm-3">
						<p class="help-block">50文字以内で入力してください。</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">校種・学年:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="studentAge" maxlength="10"
							placeholder="10文字以内" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">ユーザーid:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="userId"
							maxlength="12" placeholder="12文字以内" required>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">ユーザーパスワード:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="userPass"
							maxlength="12" placeholder="12文字以内" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10 text-right">
						<button class="btn btn-lg btn-primary" type="submit" name="add"
							value="Add">新規登録</button>
					</div>
				</div>
			</form>
		</div>

		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>