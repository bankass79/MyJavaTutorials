package priorityQueueJava;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCustomComparatorExample {
	
	public static void main(String[] args) {
		
		// compare deux String selon leur length 
		Comparator<String> comparator= new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return  o1.length()-o2.length();
			}
		};
		
		
		 //Add items to a Priority 	Queue (Enqueue)
		PriorityQueue<String>priorityQueue= new PriorityQueue<>(comparator);
		priorityQueue.add("Lisa");
		priorityQueue.add("Robert");
		priorityQueue.add("John");
		priorityQueue.add("Chris");
		priorityQueue.add("Angelina");
		priorityQueue.add("Joe");
		
		System.out.println("\nA custom comparator that compares two Strings by their length:");
		while (!priorityQueue.isEmpty()) {
			
			System.out.println(priorityQueue.remove());
		}
		
		
	}

}
