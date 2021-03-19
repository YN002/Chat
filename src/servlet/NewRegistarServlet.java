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
import dao.NewAccountDAO;

/**
 * Servlet implementation class NewRegistarServlet
 */
@WebServlet("/NewRegistarServlet")
public class NewRegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegistarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//新規登録サーブレット
		String loginId = request.getParameter("loginid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		AccountBeans ab = new AccountBeans();
		ab.setId(loginId);
		ab.setPassword(password);
		ab.setName(name);

		HttpSession session = request.getSession();
		session.setAttribute("account", ab);

		NewAccountDAO nad = new NewAccountDAO();
		nad.registar(ab);

		RequestDispatcher dispatcher = request.getRequestDispatcher("NewAccountSuccess.jsp");
		dispatcher.forward(request, response);

	}

}
