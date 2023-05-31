package su.bnair.bpassword.ui.models;

import javax.swing.JFrame;

import su.bnair.bpassword.Instances;

public class NamedJFrame extends JFrame {
	
	private String title;
	
	public NamedJFrame(String title) {
		setTitle(Instances.NAME + " | " + Instances.VERSION + " - " + title);
	}
}
