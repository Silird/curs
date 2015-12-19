package util;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Masters {
    Set<Master> record;

    public Masters() {
        record = new HashSet<Master>();
    }

    public Master GetMaster(int kod) {
        Iterator<Master> it = record.iterator();
        int prev;
        Master master;
        Master mastertmp = null;
        //prev = -1;
        while (it.hasNext()) {
            master = it.next();
            if (((mastertmp == null) && (master.isCan(kod) != -1)) || (master.isCan(kod) < mastertmp.isCan(kod))) {
                mastertmp = master;
            }
        }
        return mastertmp;
    }
}
