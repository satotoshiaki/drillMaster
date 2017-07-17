package servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Answer;
import beans.Question;
import control.AnswerManager;
import control.QuestionManager;

public class ViewAnswerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");

		// 解答の情報を入れるListを宣言
		List<Answer> answerList = new ArrayList<Answer>();
		// AnswerManagerオブジェクトを生成
		AnswerManager answerManager = new AnswerManager();
		// すべての解答情報を持ってくる
		answerList = answerManager.answerList();

		// すべての問題情報を入れるListを宣言
		List<Question> questionList = new ArrayList<Question>();
		// QuestionManagerオブジェクトの生成
		QuestionManager questionManager = new QuestionManager();
		// すべての問題情報を持ってくる
		questionList = questionManager.questionList();

		request.setAttribute("answerList", answerList);
		request.setAttribute("questionList", questionList);
		request.setAttribute("userId", userId);

		getServletContext().getRequestDispatcher("/jsp/teacher/viewStudent/answer.jsp").forward(request, response);
	}
}
