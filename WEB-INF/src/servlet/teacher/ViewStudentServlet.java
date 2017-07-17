package servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import control.StudentManager;

public class ViewStudentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		// 学習者の情報を入れるListを宣言
		List<Student> studentList = new ArrayList<Student>();

		StudentManager manager = new StudentManager();

		studentList = manager.studentList();
		request.setAttribute("studentList", studentList);
		getServletContext().getRequestDispatcher("/jsp/teacher/viewStudent/index.jsp").forward(request, response);
	}
}