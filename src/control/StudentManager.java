package control;

import java.sql.Connection;

import beans.Student;
import dao.LoginDAO;
import dao.StudentDAO;

public class StudentManager {

	private Connection connection = null;

	// 引数useIdに対応するstudentを持ってくる
	public Student getStudent(String userId){

		StudentDAO studentDAO = new StudentDAO();
		this.connection = studentDAO.createConnection();

		Student student = new Student();
		student = StudentDAO.getStudent(userId, connection);

		return student;
	}

	// 新規に学生登録を登録する
	public void addStudent(Student student, String userPass){

		// LoginDAOオブジェクト生成
		LoginDAO loginDAO = new LoginDAO();
		// データベースへ接続し、コネクションオブジェクトを生成する
		this.connection = loginDAO.createConnection();
		// userIdを生成
		String userId = student.getUserID();
		// useridとuserPassをLoginテーブルのデータベースに登録する
		loginDAO.addUser(userId, userPass,this.connection);
		  //  データベースとの接続を切断する
        loginDAO.closeConnection(this.connection);
        //  コネクションオブジェクトを破棄する
        this.connection = null;

        // StudentDAOオブジェクト生成
		StudentDAO studentDAO = new StudentDAO();
		// データベースへ接続し、コネクションオブジェクトを生成する
		this.connection = studentDAO.createConnection();
		// studentオブジェクトをStudentテーブルのデータベースに登録する
		studentDAO.addStudent(student, this.connection);
        //  DataBaseとの接続を切断する
        studentDAO.closeConnection(this.connection);
        //  コネクションオブジェクトを破棄する
        this.connection = null;

	}

}
