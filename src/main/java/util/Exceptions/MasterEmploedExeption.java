package util.Exceptions;

/**
 * Исключительная ситуация, когда администратор пытается уволить занятого работой мастера
 */
public class MasterEmploedExeption extends Exception {
    public MasterEmploedExeption() {
        super("Невозможная операция, так как данный мастер ещё занят работой");
    }
}
