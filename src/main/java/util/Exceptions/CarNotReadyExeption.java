package util.Exceptions;

/**
 * Исключительная ситуация, когда администратор пытается выписать не готовую заявку
 */
public class CarNotReadyExeption extends Exception {
    public CarNotReadyExeption() {
        super("Машина клиента ещё не готова");
    }
}
