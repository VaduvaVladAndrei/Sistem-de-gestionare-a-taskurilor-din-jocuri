package gestionareprogresjocuri;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
import javax.swing.*;
import java.awt.*;

public class AddChallenge {
	JFrame frame;
	JLabel instr;
	JTextField desc;
	JSpinner spinner;
	JButton add;
	
	private int gameId;
	/**
	 * Constructor pentru fereastra AddChallenge
	 */
	public AddChallenge() {
		frame=new JFrame("Game Tracker");
		frame.setLayout(new FlowLayout());
		frame.setSize(300,200);
		frame.setResizable(false);
		
		instr=new JLabel("Insert challenge and number.");
		desc=new JTextField();
		desc.setColumns(10);
		spinner=new JSpinner();
		spinner.setPreferredSize(new Dimension(100,25));
		add=new JButton("Add Challenge");
		
		frame.add(instr);
		frame.add(desc);
		frame.add(spinner);
		frame.add(add);
		
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Getter pentru gameId
	 */
	public int getGameId() {
		return gameId;
	}
	/**
	 * Setter pentru gameId
	 * @param  int gameid ID-ul jocului
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
