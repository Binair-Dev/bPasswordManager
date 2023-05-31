package su.bnair.bpassword.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import su.bnair.bpassword.Instances;
import su.bnair.bpassword.ui.models.NamedJFrame;
import su.bnair.bpassword.utils.PasswordGenerator;
import javax.swing.JSlider;
import javax.swing.JLabel;

public class PassGenFrame extends NamedJFrame {

	private JPanel contentPane;
	private JTextField textField;

	public PassGenFrame() {
		super("Password Generator");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	Instances.hide(Instances.getPassGenFrame());
				Instances.open(Instances.getMainFrame());
            }
        });
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(6, 184, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox useCaps = new JCheckBox("Majuscules");
		useCaps.setHorizontalAlignment(SwingConstants.CENTER);
		useCaps.setBounds(6, 7, 418, 23);
		useCaps.setSelected(true);
		contentPane.add(useCaps);
		
		JCheckBox useNumbers = new JCheckBox("Chiffres");
		useNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		useNumbers.setBounds(10, 33, 414, 23);
		useNumbers.setSelected(true);
		contentPane.add(useNumbers);
		
		JCheckBox useSpecialCaracters = new JCheckBox("Caractères spéciaux");
		useSpecialCaracters.setHorizontalAlignment(SwingConstants.CENTER);
		useSpecialCaracters.setBounds(10, 59, 414, 23);
		useSpecialCaracters.setSelected(true);
		contentPane.add(useSpecialCaracters);
		
		JLabel sizeLabel = new JLabel("Taille: 16");
		sizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sizeLabel.setBounds(10, 89, 414, 14);
		contentPane.add(sizeLabel);
		
		JSlider slider = new JSlider();
		slider.setValue(16);
		slider.setMinimum(8);
		slider.setMaximum(64);
		slider.setBounds(10, 115, 414, 26);
		slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                sizeLabel.setText("Taille: " + value);
            }
        });
		contentPane.add(slider);
		
		JButton generateButton = new JButton("Générer un mot de passe");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(PasswordGenerator.generatePassword(slider.getValue(), useCaps.isSelected(), useNumbers.isSelected(), useSpecialCaracters.isSelected()));
			}
		});
		generateButton.setBounds(6, 152, 414, 23);
		contentPane.add(generateButton);
		
		JButton backButton = new JButton("Retour");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instances.hide(Instances.getPassGenFrame());
				Instances.open(Instances.getMainFrame());
			}
		});
		backButton.setBounds(6, 215, 414, 23);
		contentPane.add(backButton);
	}
}
