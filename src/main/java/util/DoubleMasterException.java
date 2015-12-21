package util;

public class DoubleMasterException extends Exception {
    public DoubleMasterException() {
        super("Данный мастер уже существует");
    }
}
