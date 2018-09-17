import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class redistest {

	public static void main(String[] args) {
		// 连接本地的Redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		/*//查看服务是否运行
		System.out.println("服务正在运行："+jedis.ping());
*/
		/*//设置redis字符串数据
		jedis.set("myName","pyt");
		System.out.println("redis存储的字符串为："+ jedis.get("myName"));*/
		
		/*//存储数据到列表
		jedis.lpush("list", "1");
		jedis.lpush("list", "2");
		jedis.lpush("list", "3");
		//获取存储的数据并输出
		List<String> lists = jedis.lrange("list", 0, 2);
		for(String s : lists) {
			System.out.println("列表项为："+s);
		}*/
		
		Set<String> sets = jedis.keys("*");
		Iterator<String> iterator = sets.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
		}
		
	}

}
