package circularList;


public class CircularList {
		private ListNode head;
		private int size;
		
		public CircularList() {
			head = null;
			size = 0;
		}
		
		public boolean isEmpty() {return size == 0;}
		
		
		public void push(Object item) {
			ListNode newNode = new ListNode(item);
			if(isEmpty()) {
				head = newNode;
			}else {
				ListNode current = head;
				while (current.getNext() != head) {
					current = current.getNext();
				}
				current.setNext(newNode);
			}
			newNode.setNext(head);
			size++;
		}
		
		public Object removeFromHead()throws EmptyListException {
			if(isEmpty()) throw new EmptyListException();
			
				Object result = null;
			if (size == 1 ) {
				result = head.getData();
				head = null;
				
			}else {
				result = head.getData();
				head = head.getNext();
			}
			size --;
			return result;
		}
		
		public Object removeFromTail()throws EmptyListException{
			if(isEmpty()) throw new EmptyListException();
			Object result = null;
			if(size == 1) {
				result = head.getData();
				head = null;
			}else {
				ListNode current = head;
				while (current.getNext().getNext() != head) {
					current = current.getNext();
				}
				result = current.getNext().getData();
				current.setNext(current.getNext().getNext());
			}
			size--;
			return result;
		}
		
		
		
		public String toString() {
			String r = "[ ";
			ListNode current = head;
			for (int i = 0; i < size; i++) {
				r += current.getData() + " ";
				current = current.getNext();
			}
			return r + "]";
		}
		
		public int getSize() {
			return size;
		}
}
