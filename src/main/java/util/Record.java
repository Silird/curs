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

    public String KODToString() {
        switch (KOD) {
            case 1: {
                return new String("Покраска");
            }
            case 2: {
                return new String("Кузовной ремонт");
            }
            case 3: {
                return new String("Ремонт подвески");
            }
            case 4: {
                return new String("Ремонт двигателя");
            }
            case 5: {
                return new String("Развал-схождение");
            }
            default: {
                return new String("Прочее");
            }
        }
    }
}
