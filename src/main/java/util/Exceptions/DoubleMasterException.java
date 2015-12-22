package util.Exceptions;

/**
 * Исключительая ситуация при попытке добавления существующего мастера
 */
public class DoubleMasterException extends Exception {
    public DoubleMasterException() {
        super("Данный мастер уже существует");
    }
}
