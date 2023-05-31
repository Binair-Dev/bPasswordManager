package su.bnair.bpassword.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import su.bnair.bpassword.Instances;

public class bUtils {
	public static void createOfUpdateConfig() {
		Map<String, Object> data = new HashMap<>();
        data.put("DATABASE_URL", "jdbc:mysql://IP:PORT/DATABASE_NAME?serverTimezone=UTC");
        data.put("USERNAME", "USERNAME");
        data.put("PASSWORD", "PASSWORD");

        DumperOptions options = new DumperOptions();
        options.setPrettyFlow(true);

        Yaml yaml = new Yaml(options);

        try (FileWriter writer = new FileWriter("config.yaml")) {
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void readConfig() throws IOException {
		File file = new File("config.yaml");
		if(file.exists()) {
			try (FileInputStream input = new FileInputStream("config.yaml")) {
	            Yaml yaml = new Yaml();
	            Map<String, Object> data = yaml.load(input);
	            Instances.DATABASE_URL = (String)data.get("DATABASE_URL");
	            Instances.USERNAME = (String)data.get("USERNAME");
	            Instances.PASSWORD = (String)data.get("PASSWORD");
	            if(((String)data.get("USERNAME")).equalsIgnoreCase("USERNAME") || ((String)data.get("USERNAME")).equalsIgnoreCase("PASSWORD")) {
	            	JOptionPane.showMessageDialog(null,"Veuillez remplir le fichier de configuration pour continuer ! (config.yaml)", "Attention", JOptionPane.WARNING_MESSAGE);
	    			System.exit(0);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		} else {
			createOfUpdateConfig();
			JOptionPane.showMessageDialog(null,"Fichier de configuration créer, veuillez donc le remplir (config.yaml)");
			System.exit(0);
		}
	}
}
