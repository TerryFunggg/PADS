package doublyLinkedList;

public class Node {
    private Object item;
    private Node next;
    private Node pervious;


    public Node(){this(null,null,null);}
    public Node(Object item){this(item,null,null);}

    public Node(Object item, Node next , Node pervious){
	this.setItem(item);
	this.setNext(next);
	this.setPervious(pervious);
    }
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPervious() {
		return pervious;
	}
	public void setPervious(Node pervious) {
		this.pervious = pervious;
	}
}
