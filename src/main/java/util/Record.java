package util;


public class Record {
    private String client, car, breacking;
    boolean ready;
    int KOD;
    Master master;

    public Record(String cl, String c, String br, int kod, Masters masters) throws CantDoItException {
        master = masters.GetMaster(kod);
        if (master == null) {
            throw new CantDoItException();
        }
        client = cl;
        car = c;
        breacking = br;
        KOD = kod;
        ready = false;
    }
}
