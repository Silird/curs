package util.Exceptions;

/**
 * Исключительная ситуация при попытке зарегестрировать существующего клиента
 */
public class DoubleClientException extends Exception {
    public DoubleClientException() {
        super("Данный клиент уже зарегестрирован");
    }
}
