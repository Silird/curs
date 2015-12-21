package util.Exceptions;

/**
 * Ситуация, когда никто не может взять машину с данной поломкой
 */
public class CantDoItException extends Exception {
    public CantDoItException() {
        super("Соррян, никто не может взять тачку((");
    }
}
