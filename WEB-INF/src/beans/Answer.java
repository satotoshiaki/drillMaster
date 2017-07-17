package beans;

public class Answer {

	// 属性
		private String userID = null; // ユーザーid
		private int questionID = 0; // 学習問題id
		private String question_answer = null; // 解答内容

	//　初期値を引数に持ったコンストラクタ
		public Answer(String userID, int questionID, String question_answer){

			this.userID = userID;
			this.questionID = questionID;
			this.question_answer = question_answer;

		}


		//  初期値を引数に持たないコンストラクタ
		public Answer(){}


		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}

		public int getQuestionID() {
			return questionID;
		}
		public void setQuestionID(int questionID) {
			this.questionID = questionID;
		}

		public String getQuestion_answer() {
			return question_answer;
		}
		public void setQuestion_answer(String question_answer) {
			this.question_answer = question_answer;
		}


}
