package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ChatBeans;

public class ChatDAO {
	final String ID = "postgres";
	final String PASSWORD = "sutoraiku";
	final String URL = "jdbc:postgresql://localhost:5432/users";

	public List<ChatBeans> findComment(){
		List<ChatBeans> list = new ArrayList<>();


		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn = DriverManager.getConnection(URL, ID, PASSWORD)){
				String sql = "SELECT * FROM \"chat2\" LIMIT 50 OFFSET 1";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					ChatBeans co = new ChatBeans();
					co.setId(rs.getInt("id"));
					co.setUserName(rs.getString("username"));
					co.setComment(rs.getString("comment"));
					co.setDate(rs.getString("date"));
					co.setIcon(rs.getString("icon"));
					//リストに格納
					list.add(co);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
