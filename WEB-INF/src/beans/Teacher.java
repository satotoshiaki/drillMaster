package beans;

public class Teacher {

	// 属性
	private String userID = null; // ユーザーid


	// 初期値を引数に持つコンストラクタ
	public Teacher(String userID){
		this.userID = userID;
	}

	//初期値を引数に持たないコンストラクタ
	public Teacher(){
	}


	// getメソッド,setメソッド
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

}
