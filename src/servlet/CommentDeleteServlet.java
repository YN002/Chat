package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ChatBeans;
import dao.CommentDeleteDAO;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*コメント削除サーブレット
		  idからデータベースに保存してあるコメントを削除*/
		String i = request.getParameter("deleteid");
		int id = Integer.parseInt(i);
		ChatBeans cb = new ChatBeans();
		cb.setId(id);;
		CommentDeleteDAO cdd = new CommentDeleteDAO();
		int delete = cdd.commentdelete(cb);

		if(delete != 0) {
			System.out.println("コメントを削除しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./ChatServlet");
			dispatcher.forward(request, response);
		}else {
			System.out.println("コメントの削除に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
