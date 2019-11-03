package linkedList;


public class LinkedList {
		protected ListNode head;
		protected ListNode tail;
		private int size;
		
		public LinkedList() {
			head = tail = null;
			size = 0;
		}
		
		public boolean isEmpty() {return size == 0;}
		
		public void addToHead(Object object) {
			ListNode newNode = new ListNode(object);
			if(isEmpty()) 
				head = tail = newNode;
			else {
				newNode.setNext(head);
				head = newNode;
			}
			size++;
		}
		
		public Object removeFromHead() throws EmptyListException {
			if(isEmpty()) 
					throw new EmptyListException();
			
			Object object = head.getData();
			if(size == 1)
					head = tail = null;
			else {
				head = head.getNext();
			}
			size--;
			return object;
		}
		
		public Object removeFromTail() throws EmptyListException{
			if (isEmpty()) throw new EmptyListException();
			
			Object object = tail.getData();
			
			if(size == 1) {
				head = tail = null;
			}else {
				ListNode current = head;
				while (current.getNext().getNext() != null) {
					current = current.getNext();
				}
				tail = current;
				tail.setNext(null);
				
			}
			size--;
			return object;
		}
		
		public void addToTail(Object object) {
			ListNode newNode = new ListNode(object);
			if(isEmpty())
				head = tail = newNode;
			else {
				tail.setNext(newNode);
				tail = newNode;
			}
			size++;
		}
		
	
		
		@Override
		public String toString() {
			String result = "[ ";
			ListNode curret = head;
			while (curret != null) {
				result += curret.getData() + " ";
				curret = curret.getNext();
			}
			
			return result + "]";
			
		}
		
		
		
		
}
