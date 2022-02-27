package gestionareprogresjocuri;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddDLC {
	JFrame frame;
	JButton addDLCButton;
	JTextField DLCNameField;
	
	/**
	 * Constructor pentru fereastra AddDLC.
	 */
	public AddDLC() {
		frame=new JFrame("Game Tracker");
		frame.setSize(300,200);
		frame.setResizable(false);
		
		addDLCButton=new JButton("Add DLC");
		DLCNameField=new JTextField();
		DLCNameField.setColumns(20);
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=1;
		frame.add(addDLCButton,gbc);
		gbc.gridx=0;
		gbc.gridy=0;
		frame.add(DLCNameField,gbc);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
	}
	/**
	 * Metoda care apeleaza metoda addDLC si actualizeaza lista de jocuri afisata in interfata grafica
	 * @param  String dlcName Numele DLC-ului
	 */
	public void createDLC(String dlcName) {
		if (dlcName.length()>0) {
			dbmanagement.AddRecord.addDLC(dlcName);
			ViewGames.updateList();
			DLCNameField.setText("");
		}
	}
}
