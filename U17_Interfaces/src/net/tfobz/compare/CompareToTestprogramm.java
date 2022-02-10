package net.tfobz.compare;
import net.tfobz.groesse.*;

/**
 * CompareToTestprogramm
 * testet die CompareTo Methode der Elemente im package net.tfobz.groesse
 * @author Michael Morandell
 *
 */
public class CompareToTestprogramm {
	/**
	 * Main
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Groesse-Array
		Groesse [] g = new Groesse[10];
		//Elemente des Arrays
		g[0] = new Auto(4000, 2500, 1500);
		g[1] = new Auto(5600, 2800, 1000);
		g[2] = new Auto(2200, 2100, 1800);
		g[3] = new Fussballfeld();
		g[4] = new Fussballfeld();
		g[5] = new Papierblatt(0);
		g[6] = new Papierblatt(1);
		g[7] = new Papierblatt(2);
		g[8] = new Papierblatt(3);
		g[9] = new Papierblatt(4);
		//Ausgabe unsortiert
		System.out.println("Ausgabe unsortiert");
		for (int i = 0; i < g.length; i++) {
			System.out.println(i+". "+g[i].toString());
		}
		//Ausgabe titel sortiert
		System.out.println("Ausgabe sortiert");
		//Sortieren durch Minimumsuche
		for (int i = 0; i < g.length; i++) {
			int minIndex = i;
			for (int j = minIndex+1; j < g.length; j++) {
				//Cast nach Comparable, um compareTo aufrufen zu können
				if (((Comparable<Groesse>) g[minIndex]).compareTo(g[j]) > 0) {
					minIndex = j;
				}
			}
			//Tauschen der Elemente
			Groesse cache = g[i];
			g[i] = g[minIndex];
			g[minIndex] = cache;
		}
		//Ausgabe der Elemente in sortierter Reihenfolge
		for (int i = 0; i < g.length; i++) {
			System.out.println(i+". "+g[i].toString());
		}
	}
}