/**
 * 
 */
package excelTestPoi;

/**
 * @author pyt
 *
 */
public class Employee {
	private String name;
	private String gender;
	private int age;
	private String department;
	private float salary;
	private String date;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String gender, int age, String department, float salary, String date) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", age=" + age + ", department=" + department
				+ ", salary=" + salary + ", date=" + date + "]";
	}
	
	
	

}
