package Listeners.RecordFrameListeners;

import util.Exceptions.CantDoItException;
import util.Exceptions.DoubleClientException;
import util.WorkMasters;
import util.WorkRecords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRecordAddListener implements ActionListener {
    private JDialog rframe;
    private JTextField clientField, carField, breackingField;
    private JComboBox KODBox;
    private WorkMasters masters;
    private WorkRecords records;

    public ActionRecordAddListener (JDialog rf, JTextField clf, JTextField cf, JComboBox kod, JTextField bf,
                                    WorkMasters m, WorkRecords r) {
        rframe = rf;
        clientField = clf;
        carField = cf;
        KODBox = kod;
        breackingField = bf;
        masters = m;
        records = r;
    }

    private class NullClientException extends Exception {
        public NullClientException() {
            super("Не введено имя клиента");
        }
    }

    private class NullCarException extends Exception {
        public NullCarException() {
            super("Не выбрана марка машины");
        }
    }

    private class NullKODException extends Exception {
        public NullKODException() {
            super("Не выбран вид работы");
        }
    }

    private class NullBreackingException extends Exception {
        public NullBreackingException() {
            super("Не описана неисправность");
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (clientField.getText().equals("")) {
                throw new NullClientException();
            }
            if (KODBox.getSelectedIndex() == 0) {
                throw new NullKODException();
            }
            if (carField.getText().equals("")) {
                throw  new NullCarException();
            }
            if (breackingField.getText().equals("")) {
                throw  new NullBreackingException();
            }
            records.add(clientField.getText(), carField.getText(), breackingField.getText(),
                    KODBox.getSelectedIndex(), masters);
            rframe.setVisible(false);
        }
        catch (NullClientException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
        }
        catch (NullKODException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
        }
        catch (NullCarException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
        }
        catch (NullBreackingException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
        }
        catch (DoubleClientException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
        }
        catch (CantDoItException ex) {
            JOptionPane.showMessageDialog(rframe, ex.getMessage());
            rframe.setVisible(false);
        }
    }
}
