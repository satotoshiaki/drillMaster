package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import beans.Answer;
import beans.Question;
import dao.AnswerDAO;
import dao.QuestionDAO;

public class AnswerManager {

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

	// 新規に解答を登録する
	public void addAnswer(Answer answer){

		// LoginDAOオブジェクト生成
		AnswerDAO answerDAO = new AnswerDAO();
		// データベースへ接続し、コネクションオブジェクトを生成する
		this.connection = answerDAO.createConnection();
		// useridとuserPassをLoginテーブルのデータベースに登録する
		answerDAO.addAnswer(answer,this.connection);
		//  データベースとの接続を切断する
		answerDAO.closeConnection(this.connection);
		//  コネクションオブジェクトを破棄する
		this.connection = null;
	}

	// すべての解答情報を持ってくる
	public List<Answer> answerList(){

		AnswerDAO answerDAO = new AnswerDAO();
		this.connection = answerDAO.createConnection();

		List<Answer> answerList = new ArrayList<Answer>();

		answerList = AnswerDAO.answerList(this.connection);

		return answerList;
	}
}