package logic;

import beans.ChatBeans;
import dao.AddCommentDAO;

public class AddCommentLogic {
	public void executeAddComment(ChatBeans cb) {
		AddCommentDAO acd = new AddCommentDAO(cb);
	}
}
