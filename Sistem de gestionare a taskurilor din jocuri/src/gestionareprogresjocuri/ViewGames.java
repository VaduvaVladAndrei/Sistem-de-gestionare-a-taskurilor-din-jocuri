package gestionareprogresjocuri;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import objects.Game;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class ViewGames {
	static JFrame frame;
	static JPanel panel;
	static JScrollPane scroll;
	static List<Game> gameList;
	static App app;
	
	/**
	 * Constructor pentru fereastra View Games
	 */
	public ViewGames(App app) {
		gameList=dbmanagement.CreateObject.getGame();
		
		this.app=app;
		frame=new JFrame("Game Tracker");
		frame.setSize(700,500);
		frame.setResizable(false);
		
		panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		scroll = new JScrollPane(panel);
		
		showGames();
		
		frame.setContentPane(scroll);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
	}
	
	/**
	 * Metoda care creaza o lista de jocuri in interfata grafica
	 */
	public static void showGames() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
	    gbc.gridy = 0;
		for(Game g:gameList) {
			panel.add(new JLabel(g.getName()),gbc);
			gbc.gridx=1;
			JButton viewTasksButton=new JButton("View Tasks");
			panel.add(viewTasksButton,gbc);
			gbc.gridx++;
			JButton addTasksButton=new JButton("Add Tasks");
			panel.add(addTasksButton,gbc);
			gbc.gridx++;
			JButton addChallengeButton=new JButton("Add Challenge");
			panel.add(addChallengeButton,gbc);
			gbc.gridx++;
			JButton deleteGameButton=new JButton("Delete Game/DLC");
			panel.add(deleteGameButton,gbc);
			panel.revalidate();
            panel.repaint();
			
            addButtonEvents(g,viewTasksButton, addTasksButton,addChallengeButton, deleteGameButton);
            
			gbc.gridy+=1;
			gbc.gridx=0;
		}
	}
	
	/**
	 * Metoda care adauga event-uri pentru butoanele generate in metoda showGames()
	 * @param g Jocul
	 * @param viewTasksButton Butonul pentru vizualizarea task-urilor
	 * @param addTasksButton Butonul pentru adaugarea task-urilor
	 * @param addChallengeButton Butonul pentru adaugarea challenge-urilor
	 * @param deleteGameButton Butonul pentru stergerea unui joc
	 */
	public static void addButtonEvents(Game g,JButton viewTasksButton, JButton addTasksButton,JButton addChallengeButton, JButton deleteGameButton) {
		viewTasksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				app.viewtasks.tasks=dbmanagement.CreateObject.getTask(g.getId());
				app.viewtasks.challenges=dbmanagement.CreateObject.getChallenge(g.getId());
				app.viewtasks.viewTask(g.getId());
				app.viewtasks.gameid=g.getId();
			}
		});
		deleteGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dbmanagement.Delete.DeleteGame(g.getId());
				dbmanagement.Delete.DeleteDLC(g.getId());
				updateList();
			}
		});
		addChallengeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				app.addchallenge.setGameId(g.getId());
				app.addchallenge.frame.setVisible(true);
			}
		});
		addTasksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				app.addtasks.setGameId(g.getId());
				app.addtasks.frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Metoda care actualizeaza lista de jocuri din interfata grafica
	 */
	public static void updateList() {
		frame.setVisible(false);
        frame.setVisible(true);
		gameList=dbmanagement.CreateObject.getGame();
		panel.removeAll();
		showGames();
	}
}
