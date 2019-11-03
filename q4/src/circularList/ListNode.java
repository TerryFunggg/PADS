package circularList;

public class ListNode {
		private Object data;
		private ListNode next;
		
		public ListNode() {
			this(null,null);
	 	}
		
		public ListNode(Object object) {
			this(object, null);
		}
		public ListNode(Object object , ListNode next) {
			this.data = object;
			this.next = next;
		}
		
		public Object getData() {
			return data;
		}
		
		public void setData(Object data) {
			this.data = data;
		}
		
		public ListNode getNext() {
			return next;
		}
		
		public void setNext(ListNode next) {
			this.next = next;
		}
}
