package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import control.QuestionManager;

public class AnswerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		int questionId = Integer.parseInt(request.getParameter("questionId"));

		// QuestionManagerオブジェクトの生成
		QuestionManager questionManager = new QuestionManager();

		//  QuestionManagerからquestionを持ってくる
		Question question = questionManager.getQuestion(questionId);

		request.setAttribute("question", question);
		getServletContext().getRequestDispatcher("/jsp/student/answer/index.jsp").forward(request, response);

	}
}