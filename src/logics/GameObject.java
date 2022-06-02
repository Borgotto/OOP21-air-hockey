package logics;


import java.io.Serializable;

/**
 * interface that defines a game object that needs its state to be updated every
 * frame
 */
public interface GameObject extends Serializable {

    /**
     * Method that allows to update the {@code GameObject}
     */
    void update();
}
