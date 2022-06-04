package gui;

import javax.swing.*;

public class ExceptionPanel {
    public ExceptionPanel(Exception ex) {
        this(null,ex);
    }

    public ExceptionPanel(String message, Exception ex) {
        ex.printStackTrace();
        if (message == null) {
            message = ex.toString();
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
