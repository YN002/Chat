package logic;

import java.util.List;

import beans.ChatBeans;
import dao.ChatDAO;

public class FindCommentLogic {
	public List<ChatBeans> executeFindComment(){
		ChatDAO cd = new ChatDAO();
		List<ChatBeans> list = cd.findComment();
		return list;
	}
}
