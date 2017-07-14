package beans;

public class Question {

	// 属性
	private int questionID = 0; // 学習問題id
	private String unitName = null; // 学習単元名
	private String target = null; // 対象校種・学年
	private String question_statement = null; // 問題文
	private String correct_answer = null; //正答


	// 初期値を引数に持つコンストラクタ
	public Question(int questionID,String unitName,String target,String question_statement,String correct_answer){
		this.questionID = questionID;
		this.unitName = unitName;
		this.target = target;
		this.question_statement = question_statement;
		this.correct_answer = correct_answer;
	}

	// 初期値を引数に持たないコンストラクタ
	public Question(){
	}


	// getメソッド,setメソッド
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getQuestion_statement() {
		return question_statement;
	}
	public void setQuestion_statement(String question_statement) {
		this.question_statement = question_statement;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}


}
