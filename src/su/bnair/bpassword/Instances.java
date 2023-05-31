package su.bnair.bpassword;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import su.bnair.bpassword.models.StoredInformation;
import su.bnair.bpassword.ui.InformationStoreFrame;
import su.bnair.bpassword.ui.MainFrame;
import su.bnair.bpassword.ui.PassGenFrame;
import su.bnair.bpassword.utils.DatabaseUtils;

public class Instances {
	public static final String NAME = "bPasswordManager";
	public static final String VERSION = "0.0.1";
	public static MainFrame MAIN_FRAME = new MainFrame();
	public static PassGenFrame PASS_GEN_FRAME = new PassGenFrame();
	public static InformationStoreFrame ID_STORE_FRAME = new InformationStoreFrame();
	public static DefaultListModel<StoredInformation> listModel;
	public static String DATABASE_URL;
	public static String USERNAME;
	public static String PASSWORD;
	
	public static void hide(JFrame frame) {
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(false);
	}
	
	public static void open(JFrame frame) {
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static MainFrame getMainFrame() {
		return MAIN_FRAME;
	}
	
	public static void setMainFrame(MainFrame mainFrame) {
		MAIN_FRAME = mainFrame;
	}
	
	public static PassGenFrame getPassGenFrame() {
		return PASS_GEN_FRAME;
	}
	
	public static InformationStoreFrame getIdStoreFrame() {
		return ID_STORE_FRAME;
	}
	
	public static void addElementToIdList(StoredInformation info) {
		listModel.addElement(info);
	}

	public static DefaultListModel<StoredInformation> getIdList() {
		if(listModel == null) {
			listModel = new DefaultListModel<StoredInformation>();
			/*
			listModel.addElement(new StoredInformation("Cloudflare", "https://cloudflare.com/", "van.bellinghen.brian@gmail.com", "azertyuiop"));
			listModel.addElement(new StoredInformation("Facebook", "https://facebook.com/", "van.bellinghen.brian@gmail.com", "azertyuiop"));
			listModel.addElement(new StoredInformation("Youtube", "https://youtube.com/", "van.bellinghen.brian@gmail.com", "azertyuiop"));
			listModel.addElement(new StoredInformation("Twitter", "https://twitter.com/", "van.bellinghen.brian@gmail.com", "azertyuiop"));
			*/
		}
		return listModel;
	}
}
