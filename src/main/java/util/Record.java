package util;


import util.Exceptions.CantDoItException;

public class Record implements Comparable<Record> {
    private String client, car, breacking;
    private boolean ready;
    private int KOD;
    private Master master;

    public Record(String cl, String c, String br, int kod, WorkMasters masters) throws CantDoItException {
        master = masters.getMaster(kod);
        if (master == null) {
            throw new CantDoItException();
        }
        master.EmployUp();
        client = cl;
        car = c;
        breacking = br;
        KOD = kod;
        ready = false;
    }

    public Record(String cl, String c, String br, int kod, Master m, boolean r) {
        master = m;
        client = cl;
        car = c;
        breacking = br;
        KOD = kod;
        ready = r;
    }

    public String getClient() {
        return client;
    }

    public String getCar() {
        return car;
    }

    public String getBreacking() {
        return breacking;
    }

    public boolean isReady() {
        return ready;
    }

    public int getKOD() {
        return KOD;
    }

    public Master getMaster() {
        return master;
    }

    public void setReady() {
        ready = true;
    }

    public int compareTo(Record o) {
        return client.compareTo(o.getClient());
    }

    public boolean equals(Record o) {
        if (client.equals(o.getClient())) {
            return true;
        }
        return false;
    }
}
