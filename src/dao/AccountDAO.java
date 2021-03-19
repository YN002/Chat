package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AccountBeans;

public class AccountDAO {
	final String ID = "postgres";
	final String PASSWORD = "sutoraiku";
	final String URL = "jdbc:postgresql://localhost:5432/users";


	public AccountBeans findAccount(AccountBeans ab) {
		AccountBeans returnab = new AccountBeans();
		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn = DriverManager.getConnection(URL, ID, PASSWORD)){
				String sql = "SELECT userid, password,name FROM \"userInfomation\" WHERE userid = ? AND password = ?";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, ab.getId());
				ps.setString(2, ab.getPassword());

				//データベースの検索
				ResultSet rs = ps.executeQuery();

				//アカウント情報を戻り値に入れていく
				if(rs.next()) {
					returnab.setId(rs.getString("userid"));
					returnab.setPassword(rs.getString("password"));
					returnab.setName(rs.getString("name"));
				}else {
					//アカウントがなかった場合nullを返す
					return null;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return returnab;
	}
}
