package util.Exceptions;

public class DoubleClientException extends Exception {
    public DoubleClientException() {
        super("Данный клиент уже зарегестрирован");
    }
}
