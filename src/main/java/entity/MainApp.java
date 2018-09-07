/**
 * 
 */
package entity;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author pyt
 *
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("Beans.xml");
		/*XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));*/
		HelloWord1 obj1 =  (HelloWord1) context.getBean("helloWorld1");	
		obj1.getUser();
		obj1.getMessage();
		obj1.setUser("pyt2");
		HelloWord1 obj2 =  (HelloWord1) context.getBean("helloWorld1");	
		obj2.getUser();
		obj2.getMessage();
		System.out.println(obj1 == obj2);
	}

}
