package gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagLayoutJPanel extends JPanel {
    protected final GridBagConstraints c;
    
    public AbstractGridBagLayoutJPanel() {
        super(new GridBagLayout());
        this.c = new GridBagConstraints();
    }
    
    public AbstractGridBagLayoutJPanel(final String name) {
        this();
        this.setName(name);
    }

    public AbstractGridBagLayoutJPanel(Dimension size) {
        this();
        this.setPreferredSize(size);
    }

    public AbstractGridBagLayoutJPanel(final String name, Dimension size) {
        this();
        this.setName(name);
        this.setPreferredSize(size);
    }

}
