package logics;

import javax.swing.*;
import java.io.Serializable;
import java.util.function.Predicate;

public interface Achievement extends Serializable {
	
	public ImageIcon getIcon();
	
	public String getName();
	
	public String getDescr();
	
	public Predicate<GameState> getCondition();
	
	public boolean isUnlocked(GameState gamestate);
}
