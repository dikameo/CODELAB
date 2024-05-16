public class IllegalArgumentException extends Exception {
    IllegalArgumentException(String message){
        super(message);
    }
    IllegalArgumentException(String message, Throwable cause){
        super(message,cause);
    }
}
