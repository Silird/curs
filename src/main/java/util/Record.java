package util;


import util.Exceptions.CantDoItException;

public class Record implements Comparable<Record> {
    private String client, car, breacking;
    private boolean ready;
    private int KOD;
    private Master master;

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

    public Record(String cl, String c, String br, int kod, Master m) {
        master = m;
        client = cl;
        car = c;
        breacking = br;
        KOD = kod;
        ready = false;
    }

    public String getClient() {
        return client;
    }

    public String getCar() {
        return car;
    }

    public String getBreacking() {
        return car;
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
