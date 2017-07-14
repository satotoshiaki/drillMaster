<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
 	 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	 	<title>DrillMaster</title>
 		<link href="/drillMaster/css/bootstrap.min.css" rel="stylesheet">
 		<link href="/drillMaster/css/signin.css" rel="stylesheet">
	</head>
	<body>
		<div class="jumbotron text-center" style="background-color:#FFF;color:#000">
 	 		<h1 class="text-center">Drill Master</h1>
 	 	</div>
 	 	<div class="container">

        	<form action="./LoginServlet" method="POST" class="form-signin">
	        	<h2 class="form-signin-heading text-center">ログイン情報を<br>入力して下さい</h2>
	       		<input type="text" name="userId" class="form-control" placeholder="ユーザーid" maxlength="12" required autofocus>
	      	    <input type="password" name="userPass" class="form-control" placeholder="パスワード" maxlength="12" required>
	     	    <button class="btn btn-lg btn-warning btn-block" type="submit" name="login" value="Login">サインイン</button>
      		</form>
		</div> <!-- container -->

<!--
		<c:if test="${result != 0}">
			<div class="text-center" style="color:#ff0000; font-size:125%;">入力されたUser Id、またはPasswordが違います。</div>
		</c:if>
-->

		<br><br>

		<hr>
 		<div class="footer"><p>&nbsp;&nbsp;&nbsp;&copy; Toshiaki SATO</p></div>

  		<script src="/drillMaster/js/all.min.js"></script>
 		<script src="/drillMaster/js/bootstrap.min.js"></script>
	</body>
</html>