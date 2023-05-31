package su.bnair.bpassword;

import java.io.IOException;
import su.bnair.bpassword.utils.DatabaseUtils;
import su.bnair.bpassword.utils.bUtils;

public class Main {
	public static void main(String[] args) {
		try {
			bUtils.readConfig();
			DatabaseUtils.createInformationTable();
			DatabaseUtils.getEveryStoredInformations();
			Instances.open(Instances.getMainFrame());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
