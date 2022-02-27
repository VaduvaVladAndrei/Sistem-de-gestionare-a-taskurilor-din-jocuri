package gestionareprogresjocuri;
import javax.swing.*;   
import java.awt.*;    
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class MainMenu {
	JFrame frame;
	JButton button;
	JButton button2;
	JButton button3;
	/**
	 * Constructor pentru fereastra Main Menu
	 */
	public MainMenu() {
		frame=new JFrame("Game Tracker");
		frame.setSize(400,200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button=new JButton("View Your Games");
		button2=new JButton("Add New Game");
		button3=new JButton("Add New DLC");
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 0;
		frame.add(button,gbc);

		gbc.gridx = 1;
	    gbc.gridy = 0;
		frame.add(button2,gbc);
		
		gbc.gridx = 2;
	    gbc.gridy = 0;
		frame.add(button3,gbc);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
