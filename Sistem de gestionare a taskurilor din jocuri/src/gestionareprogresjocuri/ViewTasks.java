package gestionareprogresjocuri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import objects.Challenge;
import objects.Task;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class ViewTasks {
	static JFrame frame;
	static JPanel tasksPanel;
	JScrollPane scroll;
	JPanel addTaskPanel;
	static List<Task> tasks;
	static List<Challenge> challenges;
	static int gameid;
	
	/**
	 * Constructor pentru ViewTasks
	 */
	public ViewTasks() {
		frame=new JFrame("Game Tracker");
		
		tasksPanel=new JPanel();
		tasksPanel.setLayout(new GridBagLayout());
		scroll=new JScrollPane(tasksPanel);
		
		frame.setContentPane(scroll);
        frame.setSize(400,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
        frame.setResizable(false);
	}
	
	/**
	 * Metoda care afiseaza o lista de task-uri in interfata grafica
	 * @param id ID-ul jocului de care apartine
	 */
	public static void viewTask(int id) {
		frame.setVisible(false);
		frame.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    tasksPanel.removeAll();
        tasksPanel.revalidate();
		
		for(Task t:tasks) {
			tasksPanel.add(new JLabel(t.getDescription()),gbc);
			gbc.gridx++;
			JButton doneBttn=new JButton("Done");
			tasksPanel.add(doneBttn,gbc);
			gbc.gridy++;
			gbc.gridx=0;
			
			addTaskButtonEvents(t.getId(),doneBttn);
		}
		for(Challenge c:challenges) {
			tasksPanel.add(new JLabel(c.getDescription()),gbc);
			gbc.gridx++;
			
			JSpinner s=new JSpinner();
			s.setPreferredSize(new Dimension(50,25));
			s.setValue(c.getMaxNr());
			tasksPanel.add(s,gbc);
			gbc.gridx++;
			
			JButton saveBttn=new JButton("Save");
			tasksPanel.add(saveBttn,gbc);
			gbc.gridx++;
			
			JButton doneBttn=new JButton("Done");
			tasksPanel.add(doneBttn,gbc);
			gbc.gridy++;
			gbc.gridx=0;
			
			addChButtonEvents(c.getId(),s,doneBttn,saveBttn);
		}
	}
	
	/**
	 * Metoda care adauga event-uri pentru butonul Done
	 * @param id ID-ul task-ului
	 * @param doneBttn Butonul Done
	 */
	public static void addTaskButtonEvents(int id,JButton doneBttn) {
		doneBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dbmanagement.Delete.DeleteTask(id);
				updateList(gameid);
			}
		});
	}
	
	/**
	 * Metoda care adauga event-uri pentru butonul Done si Save a challenge-urilor
	 * @param id ID-ul challenge-ului
	 * @param spinner Spinner-ul folosit pentru a schimba numarul asociat challenge-ului
	 * @param doneBttn Butonul Done
	 * @param saveBttn Butonul Save
	 */
	public static void addChButtonEvents(int id,JSpinner spinner,JButton doneBttn,JButton saveBttn) {
		doneBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dbmanagement.Delete.DeleteChallenge(id);
				updateList(gameid);
			}
		});
		
		saveBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dbmanagement.Update.updateChallenge(id,(int)spinner.getValue());
				updateList(gameid);
			}
		});
	}
	
	/**
	 * Metoda care actualizeaza lista de task-uri.
	 * @param id ID-ul jocului de care apartine fiecare task
	 */
	public static void updateList(int id){
		frame.setVisible(false);
        frame.setVisible(true);
        tasksPanel.removeAll();
        tasksPanel.revalidate();
		tasks=dbmanagement.CreateObject.getTask(id);
		challenges=dbmanagement.CreateObject.getChallenge(id);
		viewTask(id);
	}
}
