/**
 * 
 */
package bupt.tjlcast.framework.bean;

/**
 * @author tangjialiang
 * 封装Result视图
 * <result name="loginFaild" type="redirect">/login.jsp</result>
 */

public class Result {
	// 跳转的标记
	private String name ;
	// 跳转类型，默认为转发
	private String redirect = "dispatch";
	// 条状的页面路径
	private String page ;
	
	public String getName() {
		return name;
	}
	public String getRedirect() {
		return redirect;
	}
	public String getPage() {
		return page;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "Result [name=" + name + ", redirect=" + redirect + ", page=" + page + "]";
	}
	
	public Result(String name, String redirect, String page) {
		super();
		this.name = name;
		this.redirect = redirect;
		this.page = page;
	}
	
	public Result() {
		super();
	}
	
}
