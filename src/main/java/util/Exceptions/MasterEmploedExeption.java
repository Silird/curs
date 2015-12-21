package util.Exceptions;

public class MasterEmploedExeption extends Exception {
    public MasterEmploedExeption() {
        super("Невозможная операция, так как данный мастер ещё занят работой");
    }
}
