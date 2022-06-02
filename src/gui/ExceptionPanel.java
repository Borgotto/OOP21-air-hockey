package gui;

import javax.swing.*;

public class ExceptionPanel {
    public ExceptionPanel(Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        System.exit(1);
    }
}
