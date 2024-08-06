public class TextLineIndexOutOfBoundsException extends Exception {

	// Super will use the Exceptions default constructor
	public TextLineIndexOutOfBoundsException() {
		super();
	}

	// Super will use the Exceptions constructor
	public TextLineIndexOutOfBoundsException(String errMsg) {
		super(errMsg);
	}

	/*
	 * Super will use the Exceptions constructor printing the index that the out of
	 * bounds exception was thrown
	 */
	public TextLineIndexOutOfBoundsException(int index) {
		super("TextLine index out of range: " + index);
	}

}
