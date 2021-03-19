package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBeans;

public class NewAccountDAO {
	final String ID = "postgres";
	final String PASSWORD = "sutoraiku";
	final String URL = "jdbc:postgresql://localhost:5432/users";

	public AccountBeans registar(AccountBeans ab) {

		try {
			Class.forName("org.postgresql.Driver");

			try(Connection conn = DriverManager.getConnection(URL, ID, PASSWORD)){
				PreparedStatement ps = conn.prepareStatement("INSERT INTO \"userInfomation\"(userid, password, name) VALUES(?, ?, ?)");
				ps.setString(1,ab.getId());
				ps.setString(2, ab.getPassword());
				ps.setString(3, ab.getName());

				int update = ps.executeUpdate();
				conn.getAutoCommit();

				if(update > 0) {
					System.out.println("登録成功しました");
				}else {
					System.out.println("もういちどやり直して下さい");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ab;
	}
}
