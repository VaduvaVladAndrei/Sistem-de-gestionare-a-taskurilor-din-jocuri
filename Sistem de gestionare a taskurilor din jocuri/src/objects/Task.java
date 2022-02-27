package objects;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class Task {
	private String description;
	private int id;
	private int gameid;
	/**
	 * Contructor pentru Task
	 */
	public Task(String description, int id, int gameid) {
		super();
		this.description = description;
		this.id = id;
		this.gameid = gameid;
	}
	/**
	 * Getter pentru description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter pentru description
	 * @param description Descrierea task-ului
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter pentru id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter pentru id
	 * @param id ID-ul task-ului
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pentru gameid
	 */
	public int getGameid() {
		return gameid;
	}
	/**
	 * Setter pentru gameid
	 * @param gameid ID-ul jocului de care apartine
	 */
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
}
