package util;

import util.Exceptions.AlreadyDoneException;
import util.Exceptions.CantDoItException;
import util.Exceptions.CarNotReadyExeption;
import util.Exceptions.DoubleClientException;

import javax.swing.table.DefaultTableModel;

public class WorkRecords {
    Records records;
    DefaultTableModel clientModel, adminModel;

    public WorkRecords(DefaultTableModel cm, DefaultTableModel am) {
        clientModel = cm;
        adminModel = am;
        records = new Records();
        RefreshModels();
    }

    private void RefreshModels() {
        String tmp1[][], tmp2[][];
        int i, rows;
        tmp1 = records.GiveClientStrings();
        tmp2 = records.GiveAdminStrings();
        rows = clientModel.getRowCount();
        for (i = 0; i < rows; i++) {
            clientModel.removeRow(0);
            adminModel.removeRow(0);
        }
        if (tmp1 == null) {
            return;
        }
        for (i = 0; i < tmp1.length; i++) {
            clientModel.addRow(tmp1[i]);
            adminModel.addRow(tmp2[i]);
        }
    }

    public void add(String cl, String c, String br, int kod, WorkMasters masters) throws DoubleClientException, CantDoItException {
        records.add(new Record(cl, c, br, kod, masters));
        RefreshModels();
        masters.RefreshModel();
    }

    public void add(String cl, String c, String br, int kod, Master m, boolean r) throws DoubleClientException {
        records.add(new Record(cl, c, br, kod, m, r));
        RefreshModels();
    }

    public void Remove() {
        records.Remove();
        RefreshModels();
    }

    public void Remove(int row) throws CarNotReadyExeption {
        records.Remove(clientModel.getValueAt(row, 0).toString());
        RefreshModels();
    }

    public void setReady(int row, WorkMasters masters) throws AlreadyDoneException {
        records.setReady(clientModel.getValueAt(row, 0).toString());
        RefreshModels();
        masters.RefreshModel();
    }

    public String[][] GiveClientStrings() {
        return records.GiveClientStrings();
    }

    public String[][] GiveAdminStrings() {
        return records.GiveAdminStrings();
    }

    public String[][] GiveSaveStrings() {
        return records.GiveSaveStrings();
    }
}
