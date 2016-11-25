package bupt.tjlcast.framework.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bupt.tjlcast.entity.User;
import bupt.tjlcast.service.UserService;

/**
 * @author tangjialiang Action 表示动作类 
 * 1. 一个Servlet对应一个action 
 * 2. action中负责处理具体请求
 */
public class LoginAction {


	/**
	 * constructor
	 */
	public LoginAction() {
	}

	public Object login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object uri = null ;
		// 1. 获取请求数据，封装
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);

		// 2. 调用Service
		UserService userService = new UserService();
		User userInfo = userService.login(user);

		// 3. 跳转
		if (userInfo == null) {
			uri = "loginFaild" ;
		} else {
			request.getSession().setAttribute("userInfo", userInfo);
			uri = "loginSuccess" ;
		}
		
		return uri ;
	}

} 
