package priorityQueueJava;

import java.time.LocalDate;
import java.util.PriorityQueue;

import comparableandComparatorObject.Employee;

public class PriorityQueueUserDefinedObjectExample {

	
	public static void main(String[] args) {
		
		
		PriorityQueue<Employee> employeesPriorityQueue= new PriorityQueue<Employee>();
		
		employeesPriorityQueue.add(new Employee(1100, "Rajeev", 100000.00, LocalDate.of(2018, 3, 8)));
		employeesPriorityQueue.add(new Employee(0, "Chris", 145000.00, null));
		employeesPriorityQueue.add(new Employee(1, "Andrea", 115000.00, LocalDate.of(2019, 6, 25)));
		
		
		while (!employeesPriorityQueue.isEmpty()) {
			System.out.println(employeesPriorityQueue.remove());
			
		}
		
	}
}
