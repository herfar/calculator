public class IntRangeException extends Exception{
    public IntRangeException() {
    }

    public IntRangeException(String message) {
        super(message);
    }

    public IntRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntRangeException(Throwable cause) {
        super(cause);
    }

    public IntRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
