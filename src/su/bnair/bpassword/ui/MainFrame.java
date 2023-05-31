package su.bnair.bpassword.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import su.bnair.bpassword.Instances;
import su.bnair.bpassword.models.StoredInformation;
import su.bnair.bpassword.ui.models.NamedJFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class MainFrame extends NamedJFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setTitle(Instances.NAME + " | " + Instances.VERSION);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					Instances.setMainFrame(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainFrame() {
		super("Accueil");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
            	int confirm = JOptionPane.showOptionDialog(null, "Voulez vous quitter l'application?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirm == 0) 
                	System.exit(0);
                   
            }
        });
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton genPassButton = new JButton("Générateur de mot de passe");
		genPassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instances.hide(Instances.getMainFrame());
				Instances.open(Instances.getPassGenFrame());
			}
		});
		genPassButton.setBounds(10, 11, 414, 23);
		contentPane.add(genPassButton);
		
		JButton idAddButton = new JButton("Ajouter des identifiants");
		idAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instances.hide(Instances.getMainFrame());
				Instances.open(Instances.getIdStoreFrame());
			}
		});
		idAddButton.setBounds(10, 45, 414, 23);
		contentPane.add(idAddButton);
		
        JList<StoredInformation> list = new JList<StoredInformation>(Instances.getIdList());
        list.setFont(new Font("Tahoma", Font.PLAIN, 16));
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list.getCellRenderer();  
        renderer.setHorizontalAlignment(JLabel.CENTER);  
        
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 108, 394, 142);

		list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JList<StoredInformation> source = (JList<StoredInformation>) e.getSource();
                    StoredInformation selectedValue = source.getSelectedValue();
                    int index = source.getSelectedIndex();
                    if (selectedValue != null) {
                       JFrame temp = new StoredInformationPopup(selectedValue);
                       temp.setLocationRelativeTo(null);
                       temp.setVisible(true);
                    }
                }
            }
        });
		contentPane.add(list);
		
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(10, 108, 414, 142);
		contentPane.add(scrollBar);
		
		textField = new JTextField();
		textField.setBounds(86, 79, 338, 20);
		textField.setColumns(10);
		
		Document searchFieldDocument = new PlainDocument();
		textField.setDocument(searchFieldDocument);
		searchFieldDocument.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterList();
            }

            private void filterList() {
                String searchText;
                try {
                    searchText = searchFieldDocument.getText(0, searchFieldDocument.getLength()).toLowerCase();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                DefaultListModel<StoredInformation> filteredListModel = new DefaultListModel<>();

                for (int i = 0; i < Instances.getIdList().getSize(); i++) {
                	StoredInformation item = Instances.getIdList().getElementAt(i);
                	if (item.getName().toLowerCase().contains(searchText) || item.getUrl().toLowerCase().contains(searchText)) {
                        filteredListModel.addElement(item);
                    }
                }

                list.setModel(filteredListModel);
            }
        });
		
		contentPane.add(textField);

		JLabel searchBar = new JLabel("Rechercher:");
		searchBar.setBounds(10, 83, 79, 14);

		contentPane.add(searchBar);
	}
}
