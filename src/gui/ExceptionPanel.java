package gui;

import javax.swing.*;

public class ExceptionPanel {
    public ExceptionPanel(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        // Close program
        System.exit(1);
    }
}
