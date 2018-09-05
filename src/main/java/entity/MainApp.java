/**
 * 
 */
package entity;

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
		/*ApplicationContext context = 
				new ClassPathXmlApplicationContext("Beans.xml");*/
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		HelloWord obj = (HelloWord) factory.getBean("helloWorld");		
		obj.getUser();
		obj.getMessage();
	}

}
