import java.util.Iterator;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * @author pyt
 * @createTime 2018年11月5日上午11:49:46
 */
public class GsonTest {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("name1", "value1");
		jsonObject.put("name2", "value2");
		System.out.println(jsonObject);
		Set<String> keys = jsonObject.keySet();
		Iterator iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key);
			System.out.println(jsonObject.get(key));
		}
	}

}

