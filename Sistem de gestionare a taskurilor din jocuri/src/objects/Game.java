package objects;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class Game {
	private int id;
	private String name;
	
	/**
	 * Constructor pentru Game
	 */
	public Game() {}
	public Game(int i,String n) {
		id=i;
		name=n;
	}
	/**
	 * Getter pentru ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter pentru ID
	 * @param id ID-ul Jocului
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter pentru name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter pentru name
	 * @param name Numele jocului
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	/**
	 * Metoda toString()
	 */
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}
	
}
