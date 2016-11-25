package bupt.tjlcast.framework;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bupt.tjlcast.framework.bean.ActionMapping;
import bupt.tjlcast.framework.bean.ActionMappingManager;
import bupt.tjlcast.framework.bean.Result;

/**
 * Servlet implementation class ActionServlet
 * 核心控制器，此项目只有这一个servlet
 * 1. 拦截所有的*.action为后缀的请求
 * 2. 请求: http://localhost:8080/mystruts/login.action
 */
@WebServlet(name="AnnotationServlet",urlPatterns="*.action", loadOnStartup=1)
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
		try {
			// 1. 得到请求路径uri［/MyMVC/*.action］
			String uri = request.getRequestURI() ;
			// 得到action的请求路径 ［login］
			String actionName = uri.substring(uri.lastIndexOf("/")+1, uri.indexOf(".action")) ;
			
			// 2. 根据路径名称，读取配置文件，得到类的全名 [bupt.....loginAction]
			ActionMapping actionMapping = actionMappingManager.getActionMapping(actionName) ;
			String className = actionMapping.getClassName() ;
			// 当前请求的处理方法
			String method = actionMapping.getMethod() ;
			// 3. 通过反射：创建对象，调用方法，获取方法返回的标记
			Class<?> clazz = Class.forName(className) ;
			// 4. 拿到标记，读取配置文件得到标记对应的路径
			Object obj = clazz.newInstance() ;
			Method declaredMethod = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class) ;
			String returnFlag = (String) declaredMethod.invoke(obj, request, response) ;
			
			// 5. 跳转
			Result result = actionMapping.getResults().get(returnFlag) ;
			if ("redirect".equals(result.getPage())) {
				response.sendRedirect(result.getPage());
			} else {
				request.getRequestDispatcher(result.getPage()).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
