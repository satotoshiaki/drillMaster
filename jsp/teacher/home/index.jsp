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



<tiles:insert template="/WEB-INF/view/common/school/layout.jsp" flush="true">
	<tiles:put name="title" value="Home" />
	<tiles:put name="content" type="string">
		<div class="jumbotron text-center" style="background-color:#FB7;coror:#000">
 	 		<h1 class="text-center">Drill Master</h1>
 	 	</div>
 	    <c:forEach items="${schoolList}" var="school">
 	 	<c:if test="${school.userId == userId}">
 	 		<h2 class="text-center">ようこそ、<c:out value="${school.name}" />　さん</h2><br>
 	 	</c:if>
 	 	</c:forEach>
 	 	<pre class="text-center">WEB学習システム [ Drill Master ]</pre>
	</tiles:put>
</tiles:insert>