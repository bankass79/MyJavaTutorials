package comparableandComparatorObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExample {

	public static void main(String[] args) {
		List<Employee> employees= new ArrayList<Employee>();
		
		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
		
		System.out.println("Before sorting" + employees);
		
		
		//Sort employees by Name
		
		
		Comparator<Employee> employeeNameComparator =new  Comparator<Employee> () {

			public int compare(Employee o1, Employee o2) {
				
				return  o1.getName().compareTo(o2.getName());
			}
			
			
		};
		Collections.sort(employees, employeeNameComparator);
		System.out.println("After sorting" + employees);
		
	
		
		// utilisation expression Lambda
		
		Comparator<Employee> employeeNameComparator2 = (e1, e2)->e1.getName().compareTo(e2.getName());
		
		
		Collections.sort(employees, employeeNameComparator2);
		System.out.println("\nEmployees using  lambda expression:" + employees);
		
		
		// Sort employees by Salary
		
		Comparator<Employee>employeeBySalary = new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				
				if(o1.getSalary()<o2.getSalary()) {
					
					return -1;
				}else if(o1.getSalary()>o2.getSalary()) {
					
					return 1;
				}else {

				return 0;
			}
			
			}
		};
		
		System.out.println();
		Collections.sort(employees, employeeBySalary);
		System.out.println("\nEmployees sorting by salary: " +employees);
		
		// Employees compare by joingDate
		
		Comparator<Employee> employeeComparatorJoingDate = new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
			
				return o1.getJoiningDate().compareTo(o2.getJoiningDate());
			}
		};
		
		Collections.sort(employees, employeeComparatorJoingDate);
		
		System.out.println("\nEmployees are comparing by joing date:"+ employees);
		
	}
}
