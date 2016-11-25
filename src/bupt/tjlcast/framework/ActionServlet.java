package bupt.tjlcast.framework;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bupt.tjlcast.framework.bean.ActionMappingManager;

/**
 * Servlet implementation class ActionServlet
 * 核心控制器，此项目只有这一个servlet
 * 1. 拦截所有的*.action为后缀的请求
 * 2. 请求: http://localhost:8080/mystruts/login.action
 */
@WebServlet("*.action")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActionMappingManager actionMappingManager = null ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
    }
    
    // 只配置一次
	@Override
	public void init() throws ServletException {
		actionMappingManager = new ActionMappingManager(); 
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 得到请求路径uri［login］
		// 2. 根据路径名称，读取配置文件，得到类的全名 [bupt.....loginAction]
		// 当前请求的处理方法
		// 3. 通过反射：创建对象，调用方法，获取方法返回的标记
		// 4. 拿到标记，读取配置文件得到标记对应的路径
		// 5. 跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
