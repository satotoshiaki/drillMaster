package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	// 属性
    // データベースの接続先アドレスを静的変数として記述
    private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/musicshop?useUnicode=true&characterEncoding=Windows-31J";
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

    public String getUserPass(String userId, Connection connection){

    	try{
    		String sql = "select * userPass from login_information where userId = '" + userId + "'";

        	Statement stmt = connection.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);

        	String getUserPass;

        	rs.first();

        	getUserPass = rs.getString("userPass");

        	stmt.close();
        	rs.close();

        	return getUserPass;

    	}catch(SQLException e){

    		e.printStackTrace();
    		return null;

    	}finally{
    	}

    }

    // 新規学習者をログインテーブルに登録する
    // 引数はuserIdとuserPass、Connectionオブジェクト
    public void addUser(String userId, String userPass, Connection connection){
    	try{
    		// SQLコマンド
            String sql = "insert into user_informations(user_id, user_name, password, role_id) values(?, ?, ?, ?)";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, userId);
            stmt.setString(2, userPass);

            stmt.executeUpdate();
    	}catch(SQLException e){
    		 // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
        } finally {
        }
    }

}