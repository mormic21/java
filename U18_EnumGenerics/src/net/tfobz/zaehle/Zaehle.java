package net.tfobz.zaehle;
import java.util.Hashtable;

/**
 * Zaehle
 * realisiert eine Klasse, welche alle zaehlt, wieoft Elemente vorhanden sind
 * @author Michael Morandell
 *
 */
public class Zaehle {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(zaehleZahlen(new int[]{6, 6, 3, 2, 4, 0, 1, 8, 1, 4}));
	}
	
	/**
	 * zaehleZahlen
	 * @param args, variabel lange Parameterliste
	 * @return Hashtable<Integer, Integer>
	 */
	public static Hashtable<Integer, Integer> zaehleZahlen(int... args) {
		//neue Hashtable
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		//Für jeden Parameter
		for (int i: args) {
			//wenn schon in der hashtable, dann wird values-wert um 1 erhöht
			if (table.containsKey(i)) {
				table.put(i, table.get(i)+1);
			}
			//neuer Eintrag in Hashtable
			else {
				table.put(i, 1);
			}
		}
		//return
		return table;
	}
}