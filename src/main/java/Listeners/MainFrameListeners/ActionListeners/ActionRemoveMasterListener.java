package Listeners.MainFrameListeners.ActionListeners;

import Frames.MyTable;
import util.Exceptions.MasterEmploedExeption;
import util.WorkMasters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRemoveMasterListener implements ActionListener {
    private JFrame frame;
    private JTabbedPane tables;
    private MyTable table;
    private WorkMasters masters;

    public ActionRemoveMasterListener(JFrame f, JTabbedPane ts, MyTable t, WorkMasters m) {
        frame = f;
        tables = ts;
        table = t;
        masters = m;
    }

    private class NotSelectedTableException extends Exception {
        public NotSelectedTableException() {
            super("Не открыта таблица мастеров");
        }
    }

    private class NotSelectedMasterException extends Exception {
        public NotSelectedMasterException() {
            super("Не выбран мастер для удаления");
        }
    }

    private class DoubleSelectedMasterException extends Exception {
        public DoubleSelectedMasterException() {
            super("Выбрано несколько мастеров");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (tables.getSelectedIndex() != 1) {
                throw new NotSelectedTableException();
            }
            if (table.getSelectedRowCount() == 0) {
                throw new NotSelectedMasterException();
            }
            if (table.getSelectedRowCount() > 1) {
                throw new DoubleSelectedMasterException();
            }
            masters.Remove(table.getSelectedRow());
        }
        catch (NotSelectedTableException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (NotSelectedMasterException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (DoubleSelectedMasterException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        catch (MasterEmploedExeption ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
}
