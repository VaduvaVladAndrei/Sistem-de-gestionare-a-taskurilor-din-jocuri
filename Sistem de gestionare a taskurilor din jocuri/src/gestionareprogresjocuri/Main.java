package gestionareprogresjocuri;
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class Main {
	public static void main(String[] args) {
		new App();
		dbmanagement.Initialize.createMainTable();
		dbmanagement.Describe.structure();
	}
}
