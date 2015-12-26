package util;

import util.Exceptions.AlreadyDoneException;
import util.Exceptions.CarNotReadyExeption;
import util.Exceptions.DoubleClientException;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Множество записей и работа с ним
 */
public class Records {
    Set<Record> records;

    public Records() {
        records = new TreeSet<Record>();
    }

    /**
     * Возвращает истину, если множество содержит данную запись
     * @param o
     * @return
     */
    private boolean contain(Record o) {
        Iterator<Record> it = records.iterator();
        while(it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return количество элементов в множестве
     */
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

    /**
     * Добавление новой записи
     * @param r
     * @throws DoubleClientException если запись уже существует
     */
    public void add(Record r) throws DoubleClientException {
        if (!contain(r)) {
            records.add(r);
        }
        else {
            throw new DoubleClientException();
        }
    }

    /**
     * Возвращает данные множества в табличном виде строк для заполнения основной таблицы
     * @return
     */
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

    /**
     * Возвращает данные множества в табличном виде строк для заполнения дополнительной таблицы
     * @return
     */
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
            if (tmpRecord.getMaster() != null) {
                tmp[i][1] = tmpRecord.getMaster().getName();
            }
            else {
                tmp[i][1] = "Уволен";
            }
            tmp[i][2] = KODToString(tmpRecord.getKOD());
            tmp[i][3] = tmpRecord.getBreacking();
            i++;
        }
        return tmp;
    }

    /**
     * Возвращает данные множества в табличном виде строк для сохранения в файл
     * готовность и вид работы, не переводятся в читабельный вид
     * @return
     */
    public String[][] GiveSaveStrings(boolean forsave) {
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
            if (forsave) {
                tmp[i][2] = String.valueOf(tmpRecord.getKOD());
            }
            else {
                tmp[i][2] = KODToString(tmpRecord.getKOD());
            }
            tmp[i][3] = tmpRecord.getBreacking();
            if (tmpRecord.getMaster() != null) {
                tmp[i][4] = tmpRecord.getMaster().getName();
            }
            else {
                tmp[i][4] = "Уволен";
            }
            if (forsave) {
                tmp[i][5] = String.valueOf(tmpRecord.isReady());
            }
            else {
                if (tmpRecord.isReady()) {
                    tmp[i][5] = "Готово";
                }
                else {
                    tmp[i][5] = "Не готово";
                }
            }
            i++;
        }
        return tmp;
    }

    /**
     * Возвращает описание вида работы по коду
     * @param KOD
     * @return
     */
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

    /**
     * Удаление базы данных
     */
    public void Remove() {
        Iterator<Record> it;
        it = records.iterator();
        while (it.hasNext()) {
            records.remove(it.next());
            it = records.iterator();
        }
    }

    /**
     * Удаление элемента базы данных по имени клиента
     * @param name
     * @throws CarNotReadyExeption если машина не готова ещё
     */
    public void Remove(String name) throws CarNotReadyExeption {
        Iterator<Record> it = records.iterator();
        Record tmpRecord;
        while (it.hasNext()) {
            tmpRecord = it.next();
            if (tmpRecord.getClient().equals(name)) {
                if (tmpRecord.isReady()) {
                    records.remove(tmpRecord);
                    return;
                }
                else {
                    throw new CarNotReadyExeption();
                }
            }
        }
    }

    /**
     * Установить готовность машины
     * @param client
     * @throws AlreadyDoneException если машину уже готова
     */
    public void setReady(String client)  throws AlreadyDoneException {
        Iterator<Record> it = records.iterator();
        Record tmp;
        while (it.hasNext()) {
            tmp = it.next();
            if (tmp.getClient().equals(client)) {
                if (!tmp.isReady()) {
                    tmp.setReady();
                    tmp.getMaster().EmployDown();
                    return;
                }
                else {
                    throw new AlreadyDoneException();
                }
            }
        }
    }
}
