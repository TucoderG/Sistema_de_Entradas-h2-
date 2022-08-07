package exeptions;

public class ClaveDuplicadaException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ClaveDuplicadaException() {
	}

	public ClaveDuplicadaException(String message) {
	    super(message);
	}

	public ClaveDuplicadaException(String message, Throwable cause) {
	    super(message, cause);
	}

	public ClaveDuplicadaException(Throwable cause) {
	    super(cause);
	}
}
