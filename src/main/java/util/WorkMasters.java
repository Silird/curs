package util;


import util.Exceptions.DoubleMasterException;
import util.Exceptions.MasterEmploedExeption;

import javax.swing.table.DefaultTableModel;

public class WorkMasters {
    Masters masters;
    DefaultTableModel model;

    public WorkMasters(DefaultTableModel m) {
        model = m;
        masters = new Masters();
        RefreshModel();
    }

    private void RefreshModel() {
        String tmp[][];
        int i, rows;
        tmp = masters.GiveStrings(false);
        rows = model.getRowCount();
        for (i = 0; i < rows; i++) {
            model.removeRow(0);
        }
        if (tmp == null) {

            return;
        }
        for (i = 0; i < tmp.length; i++) {
            model.addRow(tmp[i]);
        }
    }

    public void add(String n, int kod[], int emax) throws DoubleMasterException {
        masters.add(new Master(n, kod, emax));
        RefreshModel();
    }

    public void add(String n, int kod[], int e, int emax) throws DoubleMasterException {
        masters.add(new Master(n, kod, e, emax));
        RefreshModel();
    }

    public void Remove() {
        masters.Remove();
        RefreshModel();
    }

    public void Remove(int row) throws MasterEmploedExeption {
        masters.Remove(model.getValueAt(row, 0).toString());
        RefreshModel();
    }

    public String[][] GiveStrings(boolean forsave) {
        return masters.GiveStrings(forsave);
    }
}
