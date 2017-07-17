package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import dao.QuestionDAO;

public class QuestionManager {


	private Connection connection = null;

	public void addQuestion(Question quesiton){

		// QuestionDAOオブジェクトの生成
		QuestionDAO questionDAO = new QuestionDAO();
		// データベースへ接続し、コネクションオブジェクトを生成する
		this.connection = questionDAO.createConnection();
		// questionオブジェクトの中身をquestions_informationテーブルのデータベースへ登録する
		questionDAO.addQuestion(quesiton,this.connection);
		//  データベースとの接続を切断する
        questionDAO.closeConnection(this.connection);
        //  コネクションオブジェクトを破棄する
        this.connection = null;
	}

	// すべての学習者問題を持ってくる
	public List<Question> questionList(){

		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();

		List<Question> questionList = new ArrayList<Question>();

		questionList = QuestionDAO.questionList(this.connection);

		return questionList;
	}

	// questionIdに対応するquestionオブジェクトを持ってくる
	public Question getQuestion(int questionId){

		// QeustionDAOオブジェクトの生成
		QuestionDAO questionDAO = new QuestionDAO();
		// データベースへ接続し、コネクションオブジェクトを生成する
		this.connection = questionDAO.createConnection();
		// quesitonDAOからquestionオブジェクトを持ってくる
		Question question = new Question();
		question = QuestionDAO.getQuestion(questionId,connection);
		//  データベースとの接続を切断する
        questionDAO.closeConnection(this.connection);
        //  コネクションオブジェクトを破棄する
        this.connection = null;

		return question;
	}
}