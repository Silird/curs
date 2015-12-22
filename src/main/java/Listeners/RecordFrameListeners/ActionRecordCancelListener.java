package Listeners.RecordFrameListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRecordCancelListener implements ActionListener {
    private JDialog rframe;

    public ActionRecordCancelListener(JDialog rf) {
        rframe = rf;
    }

    public void actionPerformed(ActionEvent e) {
        rframe.setVisible(false);
    }
}
