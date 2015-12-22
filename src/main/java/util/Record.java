package util;

import util.Exceptions.CantDoItException;

/**
 * Класс одной записи в базе
 * Содержит:
 * Имя клиента
 * Марку машины
 * Тип работы
 * Описание работы
 * Мастера
 * Готовность
 */
public class Record implements Comparable<Record> {
    private String client, car, breacking;
    private boolean ready;
    private int KOD;
    private Master master;

    /**
     * создание новой записи, подбор мастера по типу работы
     * @param cl
     * @param c
     * @param br
     * @param kod
     * @param masters
     * @throws CantDoItException никакой мастер не может взяться за работу
     */
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

    /**
     * @return имя клиента
     */
    public String getClient() {
        return client;
    }

    /**
     * @return марку машины
     */
    public String getCar() {
        return car;
    }

    /**
     * @return описание поломки
     */
    public String getBreacking() {
        return breacking;
    }

    /**
     * @return готовность
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * @return тип работы
     */
    public int getKOD() {
        return KOD;
    }

    /**
     * @return мастера
     */
    public Master getMaster() {
        return master;
    }

    /**
     * Установить флаг готовности на истину
     */
    public void setReady() {
        ready = true;
    }

    /**
     * Сравнение с другой записью, производится по имени клиента
     * @param o
     * @return
     */
    public int compareTo(Record o) {
        return client.compareTo(o.getClient());
    }

    /**
     * Приравнивание двух записей, по имени клиента
     * @param o
     * @return
     */
    public boolean equals(Record o) {
        if (client.equals(o.getClient())) {
            return true;
        }
        return false;
    }
}
