package util;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;

public class Records {
    Set<Record> record;
    DefaultTableModel model;

    public Records(DefaultTableModel m) {
        model = m;
        record = new HashSet<Record>();

    }

    public void add() {

    }

    public void delete() {

    }

    public void edit() {

    }

}
