package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Student;
import control.CheckLoginManager;
import control.StudentManager;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		// userIdとuserPassをManagerに渡す
		CheckLoginManager checkLoginManager = new CheckLoginManager();
		int checkId = checkLoginManager.checkUser(userId, userPass);

		// 正しいユーザーへの処理
		if (checkId == 0) {
			if (userId.equals("root")) {

				/*
				 * sessionの開始
				 */
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", userId);
				// session.setAttribute("userPass", userPass);
				response.sendRedirect("/drillMaster/jsp/teacher/home/index.jsp");

			} else {

				StudentManager studentManager = new StudentManager();
				Student student = studentManager.getStudent(userId);
				/*
				 * sessionの開始/
				 */
				HttpSession session = request.getSession(true);
				session.setAttribute("userId", student.getUserID());
				// session.setAttribute("userPass", userPass);
				session.setAttribute("studentName", student.getStudentName());

				response.sendRedirect("/drillMaster/jsp/student/home/index.jsp");

			}
		} else if (checkId == -1) { // 正しくないユーザーへの処理

			getServletContext().getRequestDispatcher("/jsp/loginError.jsp").forward(request, response);
		}

	}

}