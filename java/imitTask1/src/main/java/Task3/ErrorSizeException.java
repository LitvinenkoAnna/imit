package Task3;

class ErrorSizeException extends MyMatrixException {
    public ErrorSizeException() {
    }

    public ErrorSizeException(String message) {
        super(message);
    }

    public ErrorSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorSizeException(Throwable cause) {
        super(cause);
    }
}
