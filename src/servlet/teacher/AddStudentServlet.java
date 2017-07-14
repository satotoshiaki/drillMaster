package servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import control.StudentManager;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// doGetメソッドは使わないので、doPostメソッドへ転送
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    // requestオブジェクトには、フォームで入力された文字列などが格納されている。
    // responseオブジェクトを使って、次のページを表示する
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // requestオブジェクトの文字エンコーディングの設定
    	request.setCharacterEncoding("UTF-8");
        // requestオブジェクトから登録情報の取り出し
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String userId = request.getParameter("userId");
        String userPass = request.getParameter("userPass");

        // student オブジェクトに情報を格納
        Student student = new Student(name, age, userId);

        // AddStudentManagerオブジェクトの生成
        StudentManager manager = new StudentManager();
        manager.addStudent(student,userPass);

     // 成功画面を表示する
     // sendRedirectは引数をページに渡すことができない
     response.sendRedirect(response.encodeRedirectURL("completion.jsp"));

    }
}
