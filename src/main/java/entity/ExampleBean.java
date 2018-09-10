/**
 * 
 */
package entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author pyt
 *
 */
public class ExampleBean implements InitializingBean,DisposableBean {
	public void init() {
	    System.out.println("ExampleBean---Bean is going through init.");
	}
	public void destroy2(){
	    System.out.println("ExampleBean---Bean will destroy now.");
	}
	/* 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ExampleBean---进行简单的初始工作");
	}
	/* 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("ExampleBean---销毁Bean");
	}	
}
