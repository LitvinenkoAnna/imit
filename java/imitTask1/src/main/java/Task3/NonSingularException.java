package Task3;

public class NonSingularException extends MyMatrixException {
    public NonSingularException() {
    }

    public NonSingularException(String message) {
        super(message);
    }

    public NonSingularException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonSingularException(Throwable cause) {
        super(cause);
    }
}
