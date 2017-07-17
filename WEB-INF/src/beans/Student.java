package beans;

public class Student {

	// 属性
	private String userID = null; //ユーザーid
	private String studentName = null; // 学習者名
	private String studentAge = null; // 校種・学年


	// 初期値を引数に持つコンストラクタ
	public Student(String userID,String studentName,String studentAge){
		this.userID = userID;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	// 初期値を引数に持たないコンストラクタ
	public Student(){
	}

	// getメソッド,setメソッド
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}


}