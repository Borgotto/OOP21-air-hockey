package utils;

import javax.swing.*;

/**
 * Utility class for loading {@link JComponent}s (mainly {@link JPanel}s) onto a {@link JFrame}.
 */
public class JComponentLoader {
    /**
     * Get the {@link JFrame} from the given {@link JComponent}.
     * @param component The component inside the frame.
     * @return The parent JFrame.
     */
    public static JFrame getParentFrame(JComponent component) {
        return (JFrame) SwingUtilities.getWindowAncestor(component);
    }

    /**
     * Remove the subcomponents inside the frame and load the given {@link JComponent} onto the given {@link JFrame}.
     * @param frame The frame to load the component onto.
     * @param component The component to load.
     */
    public static void load(JFrame frame, JComponent component) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(component);
        frame.setTitle(component.getName());
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
}
