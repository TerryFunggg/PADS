
import arrayQueue.*;
public class MainDrive {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(9999);
		try {
				arrayQueue.enqueue(12);
				arrayQueue.enqueue(18);
				arrayQueue.enqueue("Terru");
				arrayQueue.enqueue("Same");
				arrayQueue.enqueue(13);
				System.out.println(arrayQueue.toString());
				
				System.out.println(arrayQueue.dequeue());
				System.out.println(arrayQueue.toString());
				
				System.out.println(arrayQueue.dequeue());
				System.out.println(arrayQueue.toString());
				
				System.out.println(arrayQueue.dequeue());
				System.out.println(arrayQueue.toString());
				
				System.out.println(arrayQueue.dequeue());
				System.out.println(arrayQueue.toString());
				
				System.out.println(arrayQueue.dequeue());
				System.out.println(arrayQueue.toString());
				
				System.out.println("Dequeue: " + arrayQueue.dequeue());

		} catch (QueueFullException | EmptyQueueException e) {
			
			System.out.println(e.getMessage());
		}catch (Exception e) {
			
			System.out.println("Unexpected Error: " + e.getMessage());
		}

	}

}
