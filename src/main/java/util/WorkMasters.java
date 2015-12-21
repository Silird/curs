package util;


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
        if (tmp == null) {
            return;
        }
        rows = model.getRowCount();
        for (i = 0; i < rows; i++) {
            model.removeRow(0);
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
    }

    public String[][] GiveStrings(boolean forsave) {
        return masters.GiveStrings(forsave);
    }
}
