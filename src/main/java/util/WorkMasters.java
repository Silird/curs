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
        int i, j;
        tmp = masters.GiveStrings();
        if (tmp == null) {
            return;
        }
        for (i = 0; i < tmp.length; i++) {
            for (j = 0; j < tmp[i].length; j++) {
                model.setValueAt(tmp[i][j], i, j);
            }
        }
    }

    public void add(String n, int kod[], int e, int emax) {
        masters.add(new Master(n, kod, e, emax));
    }

    public String[][] GiveStrings() {
        return masters.GiveStrings();
    }
}
