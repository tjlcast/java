package bupt.tjlcast.framework.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author tangjialiang
 * 加载配置文件，封装所有的mystruts.xml
 */
public class ActionMappingManager {
	
	private Map<String, ActionMapping> allActions = new HashMap<String, ActionMapping>() ; // <请求路径， Action视图>

	public ActionMappingManager() {
		// 初识化
		this.init();
	}
	
	public void init() {
		/***************读取配置文件****************/
		try {
			// 1. 得到解析器
			SAXReader reader = new SAXReader() ;
			// 得到配置文件句柄
			InputStream in = this.getClass().getResourceAsStream("/mystruts.xml") ;
			// 2. 加载文件
			Document doc = reader.read(in) ;
			// 3. 得到根节点
		    Element root = doc.getRootElement() ;
		    // 4. 得到package节点
		    Element ele_package = root.element("package") ;
		    // 5. 得到package节点下的所有action子节点 
		    @SuppressWarnings("unchecked")
			List<Element> actions = ele_package.elements("action") ;
		    
		    for(Element ele : actions){
		    	ActionMapping actionMapping = new ActionMapping() ;
		    	actionMapping.setName(ele.attributeValue("name"));
		    	actionMapping.setClassName(ele.attributeValue("class"));
		    	actionMapping.setMethod(ele.attributeValue("method"));
		    	
		    	// 封装当前action下的所有result节点
		    	@SuppressWarnings("unchecked")
				List<Element> result_list = ele.elements("result") ;
		    	for(Element result_ele : result_list) {
		    		// 封装对象
		    		Result result = new Result() ;
		    		result.setName(result_ele.attributeValue("name"));
		    		if (result_ele.attributeValue("type")==null || "".equals(result_ele.attributeValue("type"))) {
		    			// 默认为转发
		    			result.setRedirect("dispatch");
		    		} else {
		    			// 设置为重定向
		    			result.setRedirect("redirect");
		    		}
		    		result.setPage(result_ele.getTextTrim());
		    		// 设置result集合
		    		actionMapping.getResults().put(result.getName(), result);
		    	}
		    	// 设置action集合
		    	allActions.put(actionMapping.getName(), actionMapping) ;
		    }
		    
		} catch (Exception e) {
			throw new RuntimeException() ;
		}
	}
	
	
	/**
	 * 根据请求路径，得到Action的映射对象
	 * @param url
	 * @return
	 */
	public ActionMapping getActionMapping(String actionName) {
		if (actionName == null) {
			throw new RuntimeException("actionName is wrong") ;
		}
		ActionMapping actionMapping = allActions.get(actionName) ;
		if (actionMapping == null) {
			throw new RuntimeException("can't find actionMapping") ;
		}
		return actionMapping ;
	}
	
}
