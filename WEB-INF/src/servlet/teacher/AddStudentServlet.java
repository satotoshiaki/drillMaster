package servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import control.StudentManager;

public class AddStudentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String studentName = request.getParameter("studentName");
		String studentAge = request.getParameter("studentAge");
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		// Studentオブジェクトに情報を格納
		Student student = new Student();
		student.setUserID(userId);
		student.setStudentName(studentName);
		student.setStudentAge(studentAge);

		// StudentManagerオブジェクトの生成
		StudentManager studentManager = new StudentManager();
		// 学習者の登録
		studentManager.addStudent(student,userPass);


		response.sendRedirect("/drillMaster/jsp/teacher/addStudent/confirm.jsp");
	}
}