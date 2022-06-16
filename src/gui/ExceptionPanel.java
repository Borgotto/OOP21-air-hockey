package gui;

import javax.swing.*;

public class ExceptionPanel {
    public ExceptionPanel(Exception ex, String message, Boolean quit) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        if (quit) {
            Runtime.getRuntime().exit(1);
        }
    }

    public ExceptionPanel(Exception ex, Boolean quit) {
        this(ex, ex.toString(), quit);
    }

    public ExceptionPanel(Exception ex) {
        this(ex, true);
    }

    public ExceptionPanel(Exception ex, String message) {
        this(ex, message, true);
    }
}
