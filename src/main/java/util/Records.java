package util;

import util.Exceptions.AlreadyDoneException;
import util.Exceptions.CarNotReadyExeption;
import util.Exceptions.DoubleClientException;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Records {
    Set<Record> records;

    public Records() {
        records = new TreeSet<Record>();
    }

    public boolean contain(Record o) {
        Iterator<Record> it = records.iterator();
        while(it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int Kolvo() {
        int i;
        Iterator<Record> it = records.iterator();
        i = 0;
        while (it.hasNext()) {
            i++;
            it.next();
        }
        return i;
    }

    public void add(Record r) throws DoubleClientException {
        if (!contain(r)) {
            records.add(r);
        }
        else {
            throw new DoubleClientException();
        }
    }

    public String[][] GiveClientStrings() {
        if (Kolvo() == 0) {
            return null;
        }
        String tmp[][] = new String[Kolvo()][4];
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        int i, tmpKOD[];
        i = 0;
        while (it.hasNext()) {
            tmpRecord = it.next();
            tmp[i][0] = tmpRecord.getClient();
            tmp[i][1] = tmpRecord.getCar();
            tmp[i][2] = KODToString(tmpRecord.getKOD());
            if (tmpRecord.isReady()) {
                tmp[i][3] = "Готово";
            }
            else {
                tmp[i][3] = "Не готово";
            }
            i++;
        }
        return tmp;
    }

    public String[][] GiveAdminStrings() {
        if (Kolvo() == 0) {
            return null;
        }
        String tmp[][] = new String[Kolvo()][4];
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        int i;
        i = 0;
        while (it.hasNext()) {
            tmpRecord = it.next();
            tmp[i][0] = tmpRecord.getClient();
            tmp[i][1] = tmpRecord.getMaster().getName();
            tmp[i][2] = KODToString(tmpRecord.getKOD());
            tmp[i][3] = tmpRecord.getBreacking();
            i++;
        }
        return tmp;
    }

    public String[][] GiveSaveStrings() {
        if (Kolvo() == 0) {
            return null;
        }
        String tmp[][] = new String[Kolvo()][6];
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        int i;
        i = 0;
        while (it.hasNext()) {
            tmpRecord = it.next();
            tmp[i][0] = tmpRecord.getClient();
            tmp[i][1] = tmpRecord.getCar();
            tmp[i][2] = String.valueOf(tmpRecord.getKOD());
            tmp[i][3] = tmpRecord.getBreacking();
            tmp[i][4] = tmpRecord.getMaster().getName();
            tmp[i][5] = String.valueOf(tmpRecord.getBreacking());
            i++;
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

    public void Remove() {
        Iterator<Record> it;
        it = records.iterator();
        while (it.hasNext()) {
            records.remove(it.next());
            it = records.iterator();
        }
    }

    public void Remove(String name) throws CarNotReadyExeption {
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        while (it.hasNext()) {
            tmpRecord = it.next();
            if (tmpRecord.isReady()) {
                records.remove(tmpRecord);
                return;
            }
            else {
                throw new CarNotReadyExeption();
            }
        }
    }

    public void setReady(String name) throws AlreadyDoneException {
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        while (it.hasNext()) {
            tmpRecord = it.next();
            if (!tmpRecord.isReady()) {
                tmpRecord.setReady();
                return;
            }
            else {
                throw new AlreadyDoneException();
            }
        }
    }
}
