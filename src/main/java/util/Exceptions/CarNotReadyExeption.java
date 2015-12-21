package util.Exceptions;

public class CarNotReadyExeption extends Exception {
    public CarNotReadyExeption() {
        super("Машина клиента ещё не готова");
    }
}
