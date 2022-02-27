package gestionareprogresjocuri;
import javax.swing.*;  
import java.awt.*;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class AddGame {
	JFrame frame;
	JButton addGameButton;
	JTextField gameNameField;
	
	/**
	 * Constructor pentru fereastra AddGame
	 */
	public AddGame() {
		frame=new JFrame("Game Tracker");
		frame.setSize(300,200);
		frame.setResizable(false);
		
		addGameButton=new JButton("Add Game");
		gameNameField=new JTextField();
		gameNameField.setColumns(20);
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=1;
		frame.add(addGameButton,gbc);
		gbc.gridx=0;
		gbc.gridy=0;
		frame.add(gameNameField,gbc);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
	}
	/**
	 * Metoda care apeleaza metoda addGame si actualizeaza lista de jocuri afisata in interfata grafica
	 * @param  String gameName Numele jocului
	 */
	public void createGame(String gameName) {
		dbmanagement.AddRecord.addGame(gameName);
		ViewGames.updateList();
		gameNameField.setText("");
	}
}
