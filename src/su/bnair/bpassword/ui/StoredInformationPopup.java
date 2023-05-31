package su.bnair.bpassword.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import su.bnair.bpassword.models.StoredInformation;
import su.bnair.bpassword.ui.models.NamedJFrame;

public class StoredInformationPopup extends NamedJFrame {

	private JPanel contentPane;
	private JTextField urlTextfield;
	private JTextField userTextfield;
	private JPasswordField passwordTextfield;
	private JButton revealButton;

	public StoredInformationPopup(StoredInformation info) {
		super("Popup");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel urlLabel = new JLabel("URL:");
		urlLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		urlLabel.setBounds(20, 11, 68, 14);
		contentPane.add(urlLabel);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 36, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(20, 61, 68, 14);
		contentPane.add(passwordLabel);
		
		urlTextfield = new JTextField();
		urlTextfield.setBounds(98, 8, 326, 20);
		contentPane.add(urlTextfield);
		urlTextfield.setColumns(10);
		urlTextfield.setEditable(false);
		
		userTextfield = new JTextField();
		userTextfield.setBounds(98, 33, 326, 20);
		contentPane.add(userTextfield);
		userTextfield.setColumns(10);
		userTextfield.setEditable(false);
		
		passwordTextfield = new JPasswordField();
		passwordTextfield.setBounds(98, 58, 326, 20);
		passwordTextfield.setColumns(10);
		passwordTextfield.setEditable(false);
		passwordTextfield.setEchoChar('*');
		contentPane.add(passwordTextfield);

		urlTextfield.setText(info.getUrl());
		userTextfield.setText(info.getUser());
		passwordTextfield.setText(info.getPassword());
		
		revealButton = new JButton("Révéler");
		revealButton.setBounds(434, 57, 89, 23);
		contentPane.add(revealButton);
		
		revealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordTextfield.getEchoChar() == '*') {
					passwordTextfield.setEchoChar('\0');
				} else {
					passwordTextfield.setEchoChar('*');
				}
			}
		});
	}

}
