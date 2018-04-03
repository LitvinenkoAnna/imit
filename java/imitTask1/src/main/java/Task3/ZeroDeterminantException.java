package Task3;

public class ZeroDeterminantException extends MyMatrixException {
    public ZeroDeterminantException() {
    }

    public ZeroDeterminantException(String message) {
        super(message);
    }

    public ZeroDeterminantException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroDeterminantException(Throwable cause) {
        super(cause);
    }
}
