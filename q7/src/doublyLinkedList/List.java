package doublyLinkedList;

import comparator.Comparator;
import comparator.EmptyComparatorException;

public class List {
    private Node head;
    private Node tail;
    private int size;
    private Comparator comparator;
    
    public List(){
    	this(null);
    }
    
    public List(Comparator comparator){
    	head = tail = null;
    	size = 0;
    	this.comparator = comparator;
    }

    public void addToHead(Object item){
		Node newNode = new Node(item);
		if(isEmpty()){
		    head = tail = newNode;
	
		}else{
		    head.setPervious(newNode);
		    newNode.setNext(head);
		    head = newNode;
		}
		size++;
    }

    public void addToTail(Object item){
		Node newNode = new Node(item);
		if(isEmpty()){ head = tail = newNode;}
		else{
		    newNode.setPervious(tail);
		    tail.setNext(newNode);
		    tail = newNode;
		}
		size++;
    }

    public Object removeFromHead() throws EmptyListException{
    	if(isEmpty()) throw new EmptyListException();
    	
    	Object item = head.getItem();
		if(size == 1){
		    head = tail = null;
		}else{
		    head = head.getNext();
		    head.setPervious(null);
		}
		size --;
		return item;
    }
    
    public Object removeFromTail() throws EmptyListException{
    	if(isEmpty()) throw new EmptyListException();
    	
    	Object item = tail.getItem();
		if(size == 1){
		    head = tail = null;
		}else{
		    tail = tail.getPervious();
		    tail.setNext(null);
		}
		size --;
		return item;
    }
    
    public int indexOf(Object item) {
    	int index = 0;
    	Node current = head;
    	while (current != null) {
			if(current.getItem() == item)
				return index;
			index++;
			current = current.getNext();
		}
    	return -1;
    }
    

    public String toString(){
		String result = "[ ";
		Node current = head;
		while(current != null){
		    result += current.getItem() + " ";
		    current = current.getNext();
		}
	
		return result + "]";
    }
    
    
    public boolean isEmpty(){return head == null;}
    
    public int getSize() {return size;}
    
    public void mergeSort() throws EmptyComparatorException {
    	if(comparator == null) 
    		throw new EmptyComparatorException("The mergeSort need comparator object. Please set the comparator first.");
    	// update head
    	head =  mergeSort(head);
    	//update tail
    	Node current = head;
    	while (current.getNext() != null) {
			current = current.getNext();
		}
    	tail = current;
    }
    
    private Node mergeSort(Node listNode) {
    	if(listNode == null || listNode.getNext() == null){
    		return listNode;
    	}
    	
    	Node secondList = split(listNode);
    	
    	listNode = mergeSort(listNode);
    	secondList = mergeSort(secondList);
    	
    	return merge(listNode , secondList);
    	
    	
    }
    
    private Node merge(Node firstNode , Node secondNode ) {
    	if(firstNode == null) {return secondNode;}
    	if(secondNode == null) {return firstNode;}
    	
    	if(comparator.isSmallThanEqualTo(firstNode.getItem(), secondNode.getItem())){
    		firstNode.setNext(merge(firstNode.getNext(), secondNode));
    		firstNode.getNext().setPervious(firstNode);
    		firstNode.setPervious(null);
    		return firstNode;
    	}else {
			secondNode.setNext(merge(firstNode, secondNode.getNext()));
			secondNode.getNext().setPervious(secondNode);
			secondNode.setPervious(null);
			return secondNode;
		}
    }
    
    private Node split(Node head) {
    	Node rear,prev;
    	rear = prev = head;
    	while (rear.getNext() != null && rear.getNext().getNext() != null) {
			rear = rear.getNext().getNext();
			prev = prev.getNext();
		}
    	Node temp = prev.getNext();
    	prev.setNext(null);
    	return temp;
    }
    
    
}
