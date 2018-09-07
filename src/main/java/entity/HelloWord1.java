/**
 * 
 */
package entity;

/**
 * @author pyt
 *
 */
public class HelloWord1 {
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
}
