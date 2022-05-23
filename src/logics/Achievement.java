package logics;

import java.io.Serializable;
import java.util.function.Predicate;
import javax.swing.ImageIcon;

public interface Achievement extends Serializable {
	
	public ImageIcon getIcon();
	
	public String getName();
	
	public String getDescr();
	
	public Predicate<GameState> getCondition();
	
	public boolean isUnlocked(GameState gamestate);
}
