package datastructures.exceptions;

public class FullQueueException extends RuntimeException {

    public FullQueueException() {
    }

    public FullQueueException(String message) {
        super(message);
    }

    public FullQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
