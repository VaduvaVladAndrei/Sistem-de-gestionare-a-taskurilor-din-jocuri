package gestionareprogresjocuri;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
import javax.swing.*;
import java.awt.*;

public class AddTasks {
	JFrame frame;
	JTextArea tasksField;
	JScrollPane scrollableArea;
	JButton addTaskButton;
	JLabel instr;
	
	private int gameId;
	/**
	 * Constructor pentru fereastra AddTasks
	 */
	public AddTasks() {
		frame=new JFrame("Game Tracker");
		frame.setLayout(new FlowLayout());
		frame.setSize(300,430);
		frame.setResizable(false);
		
		instr=new JLabel("Insert one task per row.");
		
		tasksField=new JTextArea();
		tasksField.setRows(20);
		tasksField.setColumns(20);
		
		scrollableArea=new JScrollPane(tasksField);
		scrollableArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		addTaskButton=new JButton("Add Task");
		
		frame.add(instr);
		frame.add(scrollableArea);
		frame.add(addTaskButton);
		
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
	}
	/**
	 * Setter pentru gameId
	 * @param  int gameid ID-ul jocului
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	/**
	 * Getter pentru gameId
	 */
	public int getGameId() {
		return gameId;
	}
	
}
