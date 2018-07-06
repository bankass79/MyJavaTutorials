package priorityQueueJava;

import java.util.PriorityQueue;

public class CreatePriorityQueueExample {
	
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer>priorityQueue = new PriorityQueue<Integer>();
		
		//Add items to a Priority Queue (EnQueue)
		
		priorityQueue.add(750);
		priorityQueue.add(500);
		priorityQueue.add(900);
		priorityQueue.add(100);
		
		// Remove items from Priority Queue(dequeue)
		
          while (!priorityQueue.isEmpty()) {
        	  
        	 System.out.println("\nPriority Queue remove value: "+ priorityQueue.remove()); 
        	  
			
		}
		
	}

}
