package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Question;

public class QuestionDAO {
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

	// 学生問題情報をデータベースに登録する
    // 引数はQuestionオブジェクトと、Connectionオブジェクト
    public void addQuestion(Question question, Connection connection) {
        try {
            // SQLコマンド
            String sql = "insert into questions_information(unit_name, target, question_statement) values(?, ?, ?)";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, question.getUnitName());
            stmt.setString(2, question.getTarget());
            stmt.setString(3,  question.getQuestion_statement());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
        } finally {
        }
    }


    // 登録されているすべての学習問題情報を引き出す
    // 引数はConnectionオブジェクト
    public  static List<Question> questionList(Connection connection){

    	List<Question>  questionList = new ArrayList<Question>();

    	try{

    		String sql = "select * from questions_information";
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);


    		while(rs.next()){
    			Question temp = new Question();
    			temp.setQuestionID(rs.getInt("question_id"));
        		temp.setUnitName(rs.getString("unit_name"));
        		temp.setTarget(rs.getString("target"));
        		temp.setQuestion_statement(rs.getString("question_statement"));
        		questionList.add(temp);
    		}

    		return questionList;

    	}catch(SQLException e){
    		e.printStackTrace();
    		return null;
    	}finally{

    	}
    }

 // 引数をquestionIdに、questions_informationテーブルから対応するquestionオブジェクトを取り出す
 	public  static Question getQuestion(int questionId,Connection connection){
 		try{

 			String sql = "select * from 	questions_information where question_id = '" + questionId + "'";
 			Statement stmt = connection.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);

 			rs.first();

 			Question question = new Question();
 			question.setQuestionID(questionId);
 			question.setUnitName(rs.getString("unit_name"));
 			question.setTarget(rs.getString("target"));
 			question.setQuestion_statement(rs.getString("question_statement"));
 			stmt.close();
 			rs.close();


 			return question;
 		}catch (SQLException e){

 			e.printStackTrace();
 			return null;
 		}finally{
 		}
 	}

}
