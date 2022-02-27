package functions;

import java.util.Date;  
/**
 * @author      Vaduva Vlad-Andrei vlad.vaduva02@e-uvt.ro
 * @version     1.0
 * @since       1.0
 */
public class GenerateId {
	/**
	 * Metoda care genereaza un ID pentru DLC-uri
	 * @return long id Se returneaza id-ul
	 */
	public static long generateId() {
		Date d=new Date();
		long result=d.getTime();
		return result%100000000;
	}
}
