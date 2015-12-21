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
        Master master;
        Master mastertmp = null;
        while (it.hasNext()) {
            master = it.next();
            if (((mastertmp == null) && (master.isCan(kod) != -1)) || (master.isCan(kod) < mastertmp.isCan(kod))) {
                mastertmp = master;
            }
        }
        return mastertmp;
    }

    public boolean contain(Master o) {
        Iterator<Master> it = records.iterator();
        while(it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(Master m) throws DoubleMasterException {
        if (!contain(m)) {
            records.add(m);
        }
        else {
            throw new DoubleMasterException();
        }
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

    public String[][] GiveStrings(boolean forsave) {
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
            if (!forsave) {
                tmp[i][1] = KODToString(tmpKOD[0]);
                tmp[i][2] = KODToString(tmpKOD[1]);
                tmp[i][3] = KODToString(tmpKOD[2]);
            }
            else {
                tmp[i][1] = String.valueOf(tmpKOD[0]);
                tmp[i][2] = String.valueOf(tmpKOD[1]);
                tmp[i][3] = String.valueOf(tmpKOD[2]);
            }
            tmp[i][4] = String.valueOf(tmpMaster.getEmp());
            tmp[i][5] = String.valueOf(tmpMaster.getEmpMAX());
            i++;
        }
        return tmp;
    }

    public String KODToString(int KOD) {
        switch (KOD) {
            case 0: {
                return new String("Отсутствует");
            }
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

    public void Remove() {
        Iterator<Master> it;
        it = records.iterator();
        while (it.hasNext()) {
            records.remove(it.next());
            it = records.iterator();
        }
    }

    public void Remove(String name) throws MasterEmploedExeption {
        Iterator<Master> it = records.iterator();
        Master tmpMaster;
        while (it.hasNext()) {
            tmpMaster = it.next();
            if (tmpMaster.getName().equals(name)) {
                if (tmpMaster.getEmp() == 0) {
                    records.remove(tmpMaster);
                    return;
                }
                else {
                    throw new MasterEmploedExeption();
                }
            }
        }
    }
}
