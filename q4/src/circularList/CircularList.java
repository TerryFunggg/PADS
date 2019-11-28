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
				
				ListNode current = head;
				while (current.getNext() != head) {
						current = current.getNext();
				}
				current.setNext(head.getNext());
				
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
				while(current.getNext().getNext() != head) {
						current = current.getNext();
				}
				result = current.getNext().getData();
				current.setNext(head);
			}
			size--;
			return result;
		}

		
		public String toString() {
			String r = "[ ";
			if( head != null) {
				ListNode current = head;
				do {
					r += current.getData() + " ";
					current = current.getNext();
				} while (current != head);
			
				
			}
			return r + " ]";
		}
		
		public int getSize() {
			return size;
		}
}
