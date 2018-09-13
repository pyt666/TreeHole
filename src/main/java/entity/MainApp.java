/**
 * 
 */
package entity;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author pyt
 *
 */
public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld1 obj = (HelloWorld1) context.getBean("helloWorld1");         
        obj.getUser();
        obj.getMessage();
		context.registerShutdownHook();
	}
}
