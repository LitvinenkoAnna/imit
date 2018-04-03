package Task3;

public class OutOfBorderException extends MyMatrixException{
    public OutOfBorderException() {
    }

    public OutOfBorderException(String message) {
        super(message);
    }

    public OutOfBorderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfBorderException(Throwable cause) {
        super(cause);
    }
}
