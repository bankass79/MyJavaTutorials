package priorityQueueJava;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueStringExample {

	public static void main(String[] args) {
	
	     //Add items to a Priority 	Queue (Enqueue)
		PriorityQueue<String>priorityQueue= new PriorityQueue<>();
		priorityQueue.add("Lisa");
		priorityQueue.add("Robert");
		priorityQueue.add("John");
		priorityQueue.add("Chris");
		priorityQueue.add("Angelina");
		priorityQueue.add("Joe");
		
	
		System.out.println("\nForEach");
		 priorityQueue.forEach(name->{
			
	System.out.println(name);
		});
	
		 
		 System.out.println();
	// remove items from the PriorityQueue(dequeue)
	
	while (!priorityQueue.isEmpty()) {
		
		System.out.println(priorityQueue.remove());	
		
	}
	}
	
	

}
