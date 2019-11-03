package queue;

import linkedList.*;

public class Queue extends LinkedList {
		public Queue() {
			super();
		}
		
		public boolean empty(){return isEmpty();}
		
		public void enqueue(Object element) {addToTail(element);}
		
		public Object dequeue() throws EmptyListException {
			Object object = removeFromHead();
			return object;
		}
		
		
}
