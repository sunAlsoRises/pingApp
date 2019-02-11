package commonSources;

public class jsonUtil {
	
	/*创建简单的json返回，包括是否成功和提示*/
	public static String createEasyJson(String success,String msg){
		return "{\"success\":\""+success+"\",\"msg\":\""+msg+"\"}";
	}
}
