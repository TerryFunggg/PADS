package stack;

import linkedList.*;

public class Stack extends LinkedList {
		
		public Stack() {
			super();
		}
		
		public boolean empty() {return isEmpty();}
		
		public void push(Object element) {addToHead(element);}
		
		public Object pop() throws EmptyListException {
			return removeFromHead();
		}
		
		public Object peek() throws EmptyListException {
			Object element = removeFromHead();
			addToHead(element);
			return element;
		}
		
		public int search(Object element) {
			int index = -1;
			ListNode current = head;
			while (!current.getData().equals(element)) {
				current = current.getNext();
				index++;
			}
			return index + 2;
		}
		
		
		
}
