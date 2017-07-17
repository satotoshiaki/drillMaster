<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>DrillMaster</title>
<%@include file="/jsp/common/default.jsp"%>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center"
			style="background-color: #FB7; color: #000">
			<h1 class="text-center">Drill Master</h1>
		</div>
		<div class="container">
			<form method="POST" action="./LoginServlet" class="form-signin">
				<h2 class="form-signin-heading text-center">
					ログイン情報を<br>入力して下さい
				</h2>
				<input type="text" name="userId" class="form-control"
					placeholder="ユーザーid" maxlength="12" required autofocus>
				<input type="password" name="userPass" class="form-control"
					placeholder="パスワード" maxlength="12" required>
				<button class="btn btn-lg btn-warning btn-block" type="submit"
					name="login" value="Login">サインイン</button>
			</form>
		</div>

		<br> <br>

		<hr>
		<%@include file="/jsp/common/footer.jsp"%>
	</div>
</body>
</html>