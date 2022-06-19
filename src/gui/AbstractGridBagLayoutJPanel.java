package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class that defines a JComponent with a GridBagLayout as layout manager.
 */
public abstract class AbstractGridBagLayoutJPanel extends JPanel {
    private static final long serialVersionUID = -9036032217146760602L;
    public final GridBagConstraints c;
    
    public AbstractGridBagLayoutJPanel() {
        super();
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
    }
    
    public AbstractGridBagLayoutJPanel(final String name) {
        this();
        this.setName(name);
    }

    public AbstractGridBagLayoutJPanel(final String name, Dimension size) {
        this();
        this.setName(name);
        this.setPreferredSize(size);
    }

}
