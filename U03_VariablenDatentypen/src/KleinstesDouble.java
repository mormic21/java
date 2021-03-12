
public class KleinstesDouble
{

	public static void main(String[] args) {
		//Die Variable i erhält den Wert 1
		double i = 1.0;
		//Die Varaible j erhält den Wert 0
		int j = 0;
		//Die Variable wird initialisiert
		double n = 0;
		/*
		 * Solange die Variable i größer als die Variable j ist, wird die Variable i durch 2 geteilt und das Ergebnis wieder in 
		 * der variable i gespeichert.
		 */
		while (i > j) {
			i = i / 2;
			//Wenn i unglich 0 ist, so wird der Variable n der Wert der Variable n zugewiesen
			if (i != 0) {
				n = i;
			}
		}
		//Der Wert der Variable n wird ausgegeben
		System.out.println(n);
	}
}
