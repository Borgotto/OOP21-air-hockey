package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class that defines a JComponent with a GridBagLayout as layout manager.
 */
public abstract class AbstractGridBagLayoutJComponent extends JComponent {
    public final GridBagConstraints c;
    
    public AbstractGridBagLayoutJComponent() {
        super();
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
    }
    
    public AbstractGridBagLayoutJComponent(final String name) {
        this();
        this.setName(name);
    }

    public AbstractGridBagLayoutJComponent(Dimension size) {
        this();
        this.setPreferredSize(size);
    }

    public AbstractGridBagLayoutJComponent(final String name, Dimension size) {
        this();
        this.setName(name);
        this.setPreferredSize(size);
    }

}
