package bupt.tjlcast.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bupt.tjlcast.framework.action.RegisterAction;

/**
 * Servlet implementation class RegiesterServlet
 */
@WebServlet("/register.action")
public class RegiesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegiesterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建Action
		RegisterAction registerAction = new RegisterAction() ;
		
		// 调用具体业务处理
		Object uri = registerAction.register(request, response) ;
		
		// TODO 读配置文件
		
		// 跳转控制
		if (uri instanceof String) {
			response.sendRedirect((String) uri);
		} else {
			((RequestDispatcher)uri).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
