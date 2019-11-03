package arrayQueue;

public class QueueFullException extends Exception {
		public QueueFullException() {
			super("The queue is full!");
		}
}
