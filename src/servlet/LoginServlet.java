package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AccountBeans;
import dao.AccountDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginId = request.getParameter("loginid");
		String password = request.getParameter("password");

		//Login.jspから受け取ったidとパスワードをAccountBeansにセット
		AccountBeans ab = new AccountBeans();
		ab.setId(loginId);
		ab.setPassword(password);

		//アカウントの有無を検索
		AccountDAO ad = new AccountDAO();
		AccountBeans returnAb = ad.findAccount(ab);

		//検索したアカウント情報を取得・保存
		if(returnAb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("account", returnAb);

			RequestDispatcher rd = request.getRequestDispatcher("ChatRoom.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		doGet(request, response);
	}

}
