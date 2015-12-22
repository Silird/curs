package util.Exceptions;

/**
 * Исключительная ситуация, когда пользователь хочет отметить готовность готовой машины
 */
public class AlreadyDoneException extends Exception {
    public AlreadyDoneException() {
        super("Машина уже готова");
    }
}
