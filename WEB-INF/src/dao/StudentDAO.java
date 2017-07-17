package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Student;

public class StudentDAO {
	// 属性
    // データベースの接続先アドレスを静的変数として記述
    private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/drillMaster?useUnicode=true&characterEncoding=Windows-31J";
    // データベース接続ドライバの名前を静的変数として記述
    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    // データベースのユーザー名 （デフォルトではroot）
    private final static String USER_NAME = "root";
    // データベースのユーザーのパスワード (デフォルトでは設定なし)
    private final static String PASSWORD = "st1315KND7";
    // データベースとの接続を行なう
    // データベースの接続情報を持った、Connectionオブジェクトを返す
    public Connection createConnection() {
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException e) {
            System.out.println("Connect Error.\n");
        }
        return null;
    }
    // Connectionオブジェクトを使って、データベースとの接続を切断する
    // 引数Connectionオブジェクト
    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    // 引数をuserIdに、students_informationテーブルから対応するstudentオブジェクトを取り出す
	public  static Student getStudent(String userId,Connection connection){
		try{

			String sql = "select * from students_information where user_id = '" + userId + "'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			Student student = new Student();

			rs.first();
			student.setUserID(rs.getString("user_id"));
			student.setStudentName(rs.getString("name"));
			student.setStudentAge(rs.getString("age"));
			stmt.close();
			rs.close();

			return student;
		}catch (SQLException e){

			e.printStackTrace();
			return null;
		}finally{
		}
	}

	// 学生情報をデータベースに登録する
    // 引数はStudentオブジェクトと、Connectionオブジェクト
    public void addStudent(Student student, Connection connection) {
        try {
            // SQLコマンド
            String sql = "insert into students_information(user_id, name, age) values(?, ?, ?)";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, student.getUserID());
            stmt.setString(2, student.getStudentName());
            stmt.setString(3, student.getStudentAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
        } finally {
        }
    }

    // 登録されているすべての学生情報を引き出す
    // 引数はConnectionオブジェクト
    public  static List<Student> studentList(Connection connection){

    	List<Student>  studentList = new ArrayList<Student>();

    	try{

    		String sql = "select * from students_information";
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);


    		while(rs.next()){
    			Student temp = new Student();
        		temp.setUserID(rs.getString("user_id"));
        		temp.setStudentName(rs.getString("name"));
        		temp.setStudentAge(rs.getString("age"));
        		studentList.add(temp);
    		}

    		return studentList;

    	}catch(SQLException e){
    		e.printStackTrace();
    		return null;
    	}finally{

    	}
    }

}