package exception;

public class MyException extends Exception {
//	private static final long serial = 0;
	
	public MyException() {
		super("MyException Occurs...");
	}
	
	public MyException(String message) {
		super(message);
	}
	
}
