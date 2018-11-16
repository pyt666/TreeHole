package memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * @author pyt
 * @createTime 2018年10月22日下午3:44:05
 */
public class MemcachedJava {
	public static void main(String[] args) {	
			//连接本地memcached服务
		    MemcachedClient mcc;
			try {
				mcc = new MemcachedClient(
						new InetSocketAddress("127.0.0.1",11211)
						);
				System.out.println("Connection to server successful!");
				//存储数据			
				Future fo = mcc.set("test", 9000, "Free Education");
				//查看存储状态
				try {
					System.out.println("set status:"+fo.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//输出值
				System.out.println("test value in cache - "+ mcc.get("test"));
				//关闭连接
				mcc.shutdown();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}

}

