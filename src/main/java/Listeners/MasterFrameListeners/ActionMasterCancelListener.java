package Listeners.MasterFrameListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionMasterCancelListener implements ActionListener {
    private JDialog mframe;

    public ActionMasterCancelListener(JDialog mf) {
        mframe = mf;
    }

    public void actionPerformed(ActionEvent e) {
        mframe.setVisible(false);
    }
}
