package gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGridBagLayoutJPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    protected final GridBagConstraints c;
    
    public AbstractGridBagLayoutJPanel() {
        super(new GridBagLayout());
        this.c = new GridBagConstraints();
    }
    
    public AbstractGridBagLayoutJPanel(final String name) {
        this();
        this.setName(name);
    }
    
    public AbstractGridBagLayoutJPanel(final String name, final GridBagConstraints c) {
        super(new GridBagLayout());
        this.setName(name);
        this.c = c;
    }
    
}
