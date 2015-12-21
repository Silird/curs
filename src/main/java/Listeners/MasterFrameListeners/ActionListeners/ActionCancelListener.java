package Listeners.MasterFrameListeners.ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCancelListener implements ActionListener {
    private JDialog mframe;

    public ActionCancelListener(JDialog mf) {
        mframe = mf;
    }

    public void actionPerformed(ActionEvent e) {
        mframe.setVisible(false);
    }
}
