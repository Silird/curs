package Listeners.MainFrameListeners.ActionListeners;

import Frames.MasterFrame.MasterFrame;
import util.WorkMasters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAddMasterListener implements ActionListener {
    private WorkMasters masters;
    private JFrame owner;

    public ActionAddMasterListener(JFrame o, WorkMasters wm) {
        owner = o;
        masters = wm;
    }

    public void actionPerformed(ActionEvent e) {
        MasterFrame masterframe;
        masterframe = new MasterFrame(masters, owner);
    }
}