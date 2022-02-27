package gestionareprogresjocuri;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
	MainMenu mainmenu;
	AddGame addgame;
	ViewGames viewgames;
	static ViewTasks viewtasks;
	AddTasks addtasks;
	AddChallenge addchallenge;
	AddDLC adddlc;
	/**
	 * Constructor pentru App
	 */
	public App() {
		mainmenu=new MainMenu();
		addgame=new AddGame();
		viewgames=new ViewGames(this);
		viewtasks=new ViewTasks();
		addtasks=new AddTasks();
		addchallenge=new AddChallenge();
		adddlc=new AddDLC();
		
		createButtonEvents();
	}
	/**
	 * Metoda care adauga event-uri pentru butoanele din aplicatie
	 */
	public void createButtonEvents() {
		mainmenu.button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addgame.frame.setVisible(true);
			}
		});
		mainmenu.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				viewgames.frame.setVisible(true);
			}
		});
		mainmenu.button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				adddlc.frame.setVisible(true);
			}
		});
		addgame.addGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addgame.createGame(addgame.gameNameField.getText());
				if(viewgames.frame.isShowing()) {
					viewgames.frame.setVisible(false);
					viewgames.frame.setVisible(true);
				}
			}
		});
		addtasks.addTaskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int id=addtasks.getGameId();
				String content=addtasks.tasksField.getText();
				String[] tasks=content.split("\n");
				for(String task:tasks) {
					if(task!="")
						dbmanagement.AddTask.AddTask(id,task);
				}
				addtasks.tasksField.setText("");
			}
		});
		addchallenge.add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int id=addchallenge.getGameId();
				String content=addchallenge.desc.getText();
				int spinnerValue=(int)addchallenge.spinner.getValue();
				if (content!="" && spinnerValue>0){
					dbmanagement.AddChallenge.addChallenge(id,content,spinnerValue);
					addchallenge.desc.setText("");
					addchallenge.spinner.setValue(Integer.valueOf(0));
				}
			}
		});
		adddlc.addDLCButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				adddlc.createDLC(adddlc.DLCNameField.getText());
				if(viewgames.frame.isShowing()) {
					viewgames.frame.setVisible(false);
					viewgames.frame.setVisible(true);
				}
			}
		});
	}
}