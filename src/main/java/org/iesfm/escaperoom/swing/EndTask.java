package org.iesfm.escaperoom.swing;

import javax.swing.*;
import java.util.TimerTask;

public class EndTask extends TimerTask {

    private JFrame jFrame;

    public EndTask(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(jFrame, "Se ha acabado el tiempo. ");
        System.exit(0);
    }
}
