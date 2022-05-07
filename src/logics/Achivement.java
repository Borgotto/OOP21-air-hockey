package logics;

import javax.swing.ImageIcon;

public class Achivement {
	
	private final ImageIcon icon;
	private final String name;
	private final String description;
	/*unlocking condition*/
	
	public Achivement() {
		this.icon = new ImageIcon();
		this.name = "";
		this.description = "";
	}
	
	public Achivement(ImageIcon icon, String name, String description) {
		this.icon = icon;
		this.name = name;
		this.description = description;
	}
	
	
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescr() {
		return this.description;
	}
}
