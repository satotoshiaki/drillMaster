package servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import control.QuestionManager;

public class AddQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String unitName = request.getParameter("unitName");
		String target = request.getParameter("target");
		String questionStatement = request.getParameter("questionStatement");

		// Questionオブジェクトに情報を格納
		Question question = new Question();
		question.setUnitName(unitName);
		question.setTarget(target);
		question.setQuestion_statement(questionStatement);

		// QuestionManagerオブジェクトの生成
		QuestionManager questionManager = new QuestionManager();
		// 学習問題の登録
		questionManager.addQuestion(question);


		response.sendRedirect("/drillMaster/jsp/teacher/addQuestion/confirm.jsp");
	}
}