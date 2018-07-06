package writeandModifyExcelfileWithApachePoi;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author a.guindo
 * 
 * tutotriel utilisation des interfaces Comparable et Comparator pour comparer deux objets
 *
 */
public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private double salary;
	private LocalDate joiningDate;
	
	private Date dateOfBirth;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * constructeur
	 */
	public Employee() {
		super();
		
	}
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param joiningDate
	 */
	public Employee(int id, String name, double salary, LocalDate joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}
	
	
	
	
	public Employee(int id, String name, double salary, LocalDate joiningDate, Date dateOfBirth, String email) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}
	// Compare Two Employees based on their ID
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Employee anotherEmployee) {
		
		return  this.getId()-anotherEmployee.getId();
	}
	
	
	public int  compareTo2(Employee e) {
		
		if(this.getSalary()<e.getSalary()) {
			
			return -1;
		}else if (this.getSalary()>e.getSalary()) {
			
			return 1;
			
		} else {
		return 0;
		
	}
	}
	//method equals for comparTo
	private boolean equals2(Object o) {
		
		if(this ==o) {
			
		return true;
		}else if(o==null || getClass() !=o.getClass()) {
			
			return false;
		}
		
		Employee e= (Employee) o;
		
		return  Double.compare(e.salary,salary)==0 &&  Objects.equals(name, e.name);
		

	}
	
	
	// Two employees are equal if their IDs are equal
	@Override
	public boolean equals(Object obj) {
		
		
		if(this==obj) {
			
			return true;
		} else if (obj==null || getClass() !=obj.getClass()) {
			
			return false;
		}
		
		Employee employee =(Employee) obj;
		 return id==employee.id;
	
	}

	
	@Override
	public int hashCode() {
		
		return Objects.hashCode(id);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", joiningDate=" + joiningDate + "]";
	}
	
	 
	
}
