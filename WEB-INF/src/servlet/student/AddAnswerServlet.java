package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Answer;
import control.AnswerManager;

public class AddAnswerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String questionAnswer = request.getParameter("questionAnswer");
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		// sessionスコープからuserIdを取得する
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");

		// Answerオブジェクトの生成
		Answer answer = new Answer();
		answer.setQuestionID(questionId);
		answer.setQuestion_answer(questionAnswer);
		answer.setUserID(userId);

		// AnswerManagerオブジェクトの生成
		AnswerManager answerManager = new AnswerManager();

		answerManager.addAnswer(answer);

		response.sendRedirect("/drillMaster/jsp/student/answer/confirm.jsp");
	}
}
