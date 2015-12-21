package util;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;

public class Records {
    Set<Record> records;
    DefaultTableModel model;

    public Records(DefaultTableModel m) {
        model = m;
        records = new HashSet<Record>();

    }

    public void add() {

    }

    public void delete() {

    }

    public void edit() {

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
