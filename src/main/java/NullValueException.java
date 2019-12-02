public class NullValueException extends Exception {
    static int count = 0;

    public NullValueException(String message){
        super(message);
    }
}
