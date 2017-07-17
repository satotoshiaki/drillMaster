package servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import control.QuestionManager;

public class ViewQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		// 学習問題の情報を入れるListを宣言
		List<Question> questionList = new ArrayList<Question>();

		QuestionManager manager = new QuestionManager();

		questionList = manager.questionList();
		request.setAttribute("questionList", questionList);
		getServletContext().getRequestDispatcher("/jsp/teacher/viewQuestion/index.jsp").forward(request, response);
	}
}