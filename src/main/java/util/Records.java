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

}
