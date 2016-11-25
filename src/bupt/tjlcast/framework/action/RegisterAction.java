/**
 * 
 */
package bupt.tjlcast.framework.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bupt.tjlcast.entity.User;
import bupt.tjlcast.service.UserService;

/**
 * @author tangjialiang
 *
 */
public class RegisterAction {

	/**
	 * constructor
	 */
	public RegisterAction() {
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		return null ;
	}


	/**
	 * 处理登录请求
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object uri = null ;
		
		// 1. 获取请求数据并封装
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);

		// 2. 调用Service
		UserService userService = new UserService();
		userService.register(user);

		// 3. 跳转
		uri = "registerSuccess" ;
		return uri ;
	}

}
