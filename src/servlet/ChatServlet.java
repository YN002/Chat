package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ChatBeans;
import logic.AddCommentLogic;
import logic.FindCommentLogic;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//既存のコメントを探し、保存
		FindCommentLogic fcl = new FindCommentLogic();
		List<ChatBeans> list = fcl.executeFindComment();

		HttpSession session = request.getSession();
		session.setAttribute("listAttribute", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ChatRoom.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// コメントを追加し、表示
		String name = request.getParameter("userName");
		String icon = request.getParameter("icon");
		String comment = request.getParameter("comment");

		ChatBeans cb = new ChatBeans();
		cb.setUserName(name);
		cb.setIcon(icon);
		cb.setComment(comment);

		AddCommentLogic acl = new AddCommentLogic();
		acl.executeAddComment(cb);

		FindCommentLogic fcl = new FindCommentLogic();
		List<ChatBeans> list = fcl.executeFindComment();

		HttpSession session = request.getSession();
		session.setAttribute("listAttribute", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ChatRoom.jsp");
		dispatcher.forward(request, response);
	}

}
