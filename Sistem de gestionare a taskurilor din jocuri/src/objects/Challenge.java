package objects;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class Challenge {
	private int id;
	private int gameid;
	private String description;
	private int maxNr;
	
	/**
	 * Constructor pentru Challenge
	 */
	public Challenge(int id, int gameid, String description, int maxNr) {
		this.id = id;
		this.gameid = gameid;
		this.description = description;
		this.maxNr = maxNr;
	}

	/**
	 * Getter pentru ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter pentru ID
	 * @param id ID-ul challenge-ului
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pentru gameId
	 */
	public int getGameid() {
		return gameid;
	}
	/**
	 * Setter pentru gameId
	 * @param gameid ID-ul jocului de care apartine
	 */
	public void setGameid(int gameid) {
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
	 * @param description descrierea Challenge-ului
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter pentru maxNr
	 */
	public int getMaxNr() {
		return maxNr;
	}
	/**
	 * Setter pentru maxNr
	 * @param maxNr Numarul asociat challenge-ului
	 */
	public void setMaxNr(int maxNr) {
		this.maxNr = maxNr;
	}

	@Override
	/**
	 * Metoda toString()
	 */
	public String toString() {
		return "Challenge [id=" + id + ", gameid=" + gameid + ", description=" + description + ", maxNr=" + maxNr + "]";
	}
	
}
