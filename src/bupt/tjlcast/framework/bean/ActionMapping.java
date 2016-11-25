package bupt.tjlcast.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangjialiang
 * 封装Action 节点视图
 * <action name="login" class="bupt.tjlcast.framework.action.LoginAction" method="login">
			<result name="success" type="redirect">/index.jsp</result>
			<result name="loginFaild">/login.jsp</result>
		</action>
 */

public class ActionMapping {
	// 请求路径
	private String name ;
	// 处理action类的全名
	private String className ;
	// 处理方法
	private String method ;
	// 结果视图集合
	private Map<String, Result> results = new HashMap<String, Result>(); // <请求标记， Result视图>
	
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	public String getMethod() {
		return method;
	}
	public Map<String, Result> getResults() {
		return results;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setResults(Map<String, Result> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return "ActionMapping [name=" + name + ", className=" + className + ", method=" + method + ", results="
				+ results + "]";
	}
	
	public ActionMapping() {
		super();
	}
	
	public ActionMapping(String name, String className, String method, Map<String, Result> results) {
		super();
		this.name = name;
		this.className = className;
		this.method = method;
		this.results = results;
	}

}
