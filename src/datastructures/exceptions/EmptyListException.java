package datastructures.exceptions;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
}
