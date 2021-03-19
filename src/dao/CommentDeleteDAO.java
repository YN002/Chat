package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ChatBeans;

public class CommentDeleteDAO {
	final String ID = "postgres";
	final String PASSWORD = "sutoraiku";
	final String URL = "jdbc:postgresql://localhost:5432/users";
	int delete;
	public int commentdelete(ChatBeans cb) {
		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn = DriverManager.getConnection(URL, ID, PASSWORD)){
				//選択したidのコメントを削除
				String sql = "Delete  FROM \"chat2\"WHERE id = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, cb.getId());
				delete = ps.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return delete;
	}
}
