package util;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Masters {
    Set<Master> records;

    public Masters() {
        records = new TreeSet<Master>();
    }

    public Master GetMaster(int kod) {
        Iterator<Master> it = records.iterator();
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

    public void add(Master m) {
        records.add(m);
    }

    public int Kolvo() {
        int i;
        Iterator<Master> it = records.iterator();
        i = 0;
        while (it.hasNext()) {
            i++;
            it.next();
        }
        return i;
    }

    public String[][] GiveStrings() {
        if (Kolvo() == 0) {
            return null;
        }
        String tmp[][] = new String[Kolvo()][6];
        Iterator<Master> it = records.iterator();
        Master tmpMaster;
        int i, tmpKOD[];
        i = 0;
        while (it.hasNext()) {
            tmpMaster = it.next();
            tmp[i][0] = tmpMaster.getName();
            tmpKOD = tmpMaster.getKOD();
            tmp[i][1] = KODToString(tmpKOD[0]);
            if (tmpKOD[1] != 0) {
                tmp[i][2] = KODToString(tmpKOD[1]);
                if (tmpKOD[2] != 0) {
                    tmp[i][3] = KODToString(tmpKOD[2]);
                } else {
                    tmp[i][3] = "Отсутствует";
                }
            }
            else {
                tmp[i][2] = "Отсутствует";
            }
            tmp[i][4] = String.valueOf(tmpMaster.getEmp());
            tmp[i][5] = String.valueOf(tmpMaster.getEmpMAX());
        }
        return tmp;
    }

    public String KODToString(int KOD) {
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
