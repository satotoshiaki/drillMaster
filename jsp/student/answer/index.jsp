<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>学習問題解答</title>
<%@include file="/jsp/common/default.jsp"%>
</head>

<body>
	<div class="container">
		<%@include file="/jsp/student/common/header.jsp"%>
		<div class="container-fluid" style="background-color: #FD7; coror: #000">
			<h2 class="text-center">学習問題解答</h2>
		</div>
		<div class="container-fluid">
			<h1 class="page-header">
				<small>学習問題への解答ページです</small>
			</h1>
			<div class="panel panel-default">
 	    		<div class="panel-heading">
 	    			学習単元: <c:out value="${question.unitName}" /><br>
 	    			対象校種・学年: <c:out value="${question.target}" /><br>
  	    			問題文: <c:out value="${question.question_statement}" /><br>
 	    		</div>
 	    	</div>

			<form class="form-horizontal" action="./AddAnswerServlet" method="POST">
				<div class="form-group">
					<label class="col-sm-1 control-label">解答欄:</label>
					<div class="col-sm-11">
						<textarea class="form-control" name="questionAnswer"
							maxlength="1000" required autofocus> </textarea>
					</div>
					<div class="col-sm-offset-1">
						<p class="help-block">1000文字以内で入力してください。</p>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10 text-right">
						<input type="hidden" value="${question.getQuestionID()}" name="questionId" />
						<button class="btn btn-lg btn-primary" type="submit" name="add" value="Add">登録する</button>
					</div>
				</div>
			</form>
		<%@include file="/jsp/common/footer.jsp"%>
		</div>
	</div>
</body>
</html>