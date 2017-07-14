<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>
		<link rel="stylesheet" href="/drillMaster/css/bootstrap.min.css">
		<link rel="stylesheet" href="/drillMaster/css/signin.css">
	</head>
	<body>
	  <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/drillMaster/jsp/teacher/home/index.jsp">Drill Master</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="/drillMaster/jsp/teacher/home/index.jsp">Home</a></li>
              <li><a href="/drillMaster/jsp/teacher/addStudent/index.jsp">学習者登録</a></li>
              <li><a href="/drillMaster/jsp/teacher/addQuestion/index.jsp">問題登録</a></li>
              <li><a href="/drillMaster/jsp/teacher/viewStudent/index.jsp">学習者一覧</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="/drillMaster/teacher/logout/">ログアウト</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

		<div class="app">
		  <!-- tiles:insert attribute="content" /-->
		  <hr>
		  <footer>
		    <p>&copy; by toshiakiSATO</p>
		  </footer>
		</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/drillMaster/js/jquery.min.js"></script>
    <script src="/drillMaster/js/bootstrap.min.js"></script>
	</body>

	<script type='text/javascript'>
		$(function(){
			$('#navbar li a').each(function(){
				var $href = $(this).attr('href');
				if(location.href.match($href)) {
					var $class = $(this).parent().parent().parent().attr('class');
					if($class == "dropdown" ){
						$(this).parent().parent().parent().addClass('active');
					}
					else{
						$(this).parent().addClass('active');
					}
				}
				else {
					$('#navbar li a').removeClass('active');
				}
				if(location.href.match("/drillMaster/teacher/editStudent/") && $href=="/drillMaster/teacher/viewStudent/"){
					$(this).parent().addClass('active');
				}
			});
		});
	</script>
</html>




 	    <div class="container" style="background-color:#FD7;coror:#000">
 			 <h2 class="text-center">学習問題登録</h2>
		</div>
		<div class="container">
 	 		<h1 class="page-header">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>登録する情報を入力して下さい</small></h1><br>
        		<form class="form-horizontal" action="./addQuestionServlet" method="POST">
					<div class="form-group">
					<label class="col-sm-2 control-label">学習単元名:</label>
					<div class="col-sm-7"><input type="text" class="form-control" name="unitName" maxlength="50" required autofocus></div>
					<div class="col-sm-3"><p class="help-block">50文字以内で入力してください。</p></div>
					</div>

					<div class="form-group">
					<label class="col-sm-2 control-label">対象校種・学年:</label>
						<div class="col-sm-7"><input type="text" class="form-control" name="target" maxlength="10" required> </div>
						<div class="col-sm-3"><p class="help-block">10文字以内で入力してください。</p></div>
					</div>

					<div class="form-group">
					<label class="col-sm-2 control-label">問題文:</label>
						<div class="col-sm-7"><textarea class="form-control" name="questionStatement" maxlength="1000" required> </textarea></div>
						<div class="col-sm-3"><p class="help-block">1000文字以内で入力してください。</p></div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
	     	    			<button class="btn btn-lg btn-primary" type="submit" name="add" value="Add">新規登録</button>
	     	    		</div>
	     	    	</div>
	     	    </form>
	     </div>
 	 	<pre class="text-center">完全習得型学習システム [ Drill Master ]</pre>