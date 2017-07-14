package control;

import java.sql.Connection;

import dao.LoginDAO;

public class CheckLoginManager {

	private  Connection connection = null;

	public int checkUser(String userId, String userPass){
		int checkId = 0;

		LoginDAO loginDAO = new LoginDAO();
		this.connection = loginDAO.createConnection();

		String getUserPass = loginDAO.getUserPass(userId, connection);

		//ログイン情報と登録されている情報が一致する
		if(getUserPass == userPass){
			checkId = 1;
		}else{ // ログイン情報と登録されている情報が一致しない
			checkId = -1;
		}

		return checkId;
	}
}
