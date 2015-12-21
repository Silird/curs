package util.Exceptions;


public class AlreadyDoneException extends Exception {
    public AlreadyDoneException() {
        super("Машина уже готова");
    }
}
