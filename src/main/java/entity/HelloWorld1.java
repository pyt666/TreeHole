/**
 * 
 */
package entity;

/**
 * @author pyt
 *
 */
public class HelloWorld1 {
	private String message;
	private String user;
	public void setUser(String user) {
		this.user = user;
	}	
	public void setMessage(String message) {
		this.message = message;
	}
	public void getMessage() {
		System.out.println("Your Message : " + message);
	}	
	public void getUser() {
		System.out.println("User is " + user);
	}
	
	public void init() {
	    System.out.println("HelloWord1---Bean is going through init.");
	}
	public void destroy2(){
	    System.out.println("HelloWord1---Bean will destroy now.");
	}
}
