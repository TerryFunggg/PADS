package arrayQueue;


public class ArrayQueue {
	private final static int MAX_LENGTH = 9999; 
	 private int front;
	 private int rear;
	 private int capacity;
	 private int count;
	 private Object[] array;
	
	public ArrayQueue() {
		this(MAX_LENGTH);
	}
	public ArrayQueue(int capacity) {
		if(capacity > MAX_LENGTH) 
			throw new IllegalArgumentException();
		front = rear = -1;
		this.capacity = capacity;
		array = new Object[capacity];
	}
	
	public boolean isEmpty() {return front == -1 && rear == -1;}
	
	public boolean isFull() { return (rear + 1)% capacity == front  ;}
	
	public void enqueue(Object item) throws QueueFullException {
		if(isFull()) throw new QueueFullException();
		
		if (isEmpty()) {
			front = rear = 0;
		}else {
			rear = (rear+1) % capacity;
		}
		array[rear] = item;
	}
	
	public Object dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		Object result = array[front];
		
		if(front == rear) {
			front = rear = -1;
		}else {
			front = (front + 1) % capacity;
		}
		return result;
	}
	
	public String toString() {
		String result = "[ ";
		if(!isEmpty()) {
			int size = (rear + capacity - front) % capacity + 1;
			for (int i = 0; i < size; i++) {
				int index = (front + i) % capacity;
				result += array[index] + " ";
			}
		}
		return result + "]";
	}
	
	public Object getFront() {
			return array[front];
	}
}
