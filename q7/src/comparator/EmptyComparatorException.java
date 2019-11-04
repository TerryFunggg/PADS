package comparator;

public class EmptyComparatorException extends Exception{
	public EmptyComparatorException() {
		super("Please set the comparator.");
	}
	public EmptyComparatorException(String message) {
		super(message);
	}
}
