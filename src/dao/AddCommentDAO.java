package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import beans.ChatBeans;

public class AddCommentDAO {
	final String ID = "postgres";
	final String PASWORD = "sutoraiku";
	final String URL = "jdbc:postgresql://localhost:5432/users";

	public AddCommentDAO(ChatBeans cb) {
		if(cb.getUserName().isEmpty()) {
			cb.setUserName("名無し");
		}

		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn = DriverManager.getConnection(URL, ID, PASWORD)){
				//テーブルの一番新しいidを取り出す
				String sql = "SELECT id FROM \"chat2\"order by id DESC OFFSET 0 LIMIT 1";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					//取り出したidを1ずつ増やしてidの更新が出来るようにする
					cb.setId(rs.getInt("id"));
					int id = cb.getId() + 1;
					String updatesql = "INSERT INTO \"chat2\"(id, username, comment, date, icon) VALUES(?, ?, ?, ?, ?)";
					PreparedStatement pst = conn.prepareStatement(updatesql);
					pst.setInt(1, id);
					pst.setString(2, cb.getUserName());
					pst.setString(3, cb.getComment());

					Calendar calendar = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					pst.setString(4, sdf.format(calendar.getTime()));
					pst.setString(5, cb.getIcon());


					int i = pst.executeUpdate();

					if(i != 0) {
						System.out.println("書き込み成功しました!");
					}else {
						System.out.println("書き込み失敗!!");
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
