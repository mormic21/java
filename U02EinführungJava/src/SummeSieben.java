
public class SummeSieben
{

	public static void main(String[] args) {
		/*
		 * Eine Anpassung von n bestimmt den höchsten Wert, den ein Vielfaches von 7 jaben kann
		 * i beginnt bei 1 (neutrales Element der Multiplikation)
		 */
	  int i =	1;
	  int n = 1000;
	  int summe = 0;
	  // Solange das Vielfache von 7 unter n ist, wird dieses Vielfache zur Summe addiert und i um 1 erhöht.
	  while (i * 7 < n) {
	  	summe = summe + (i * 7);
	  	i = i + 1;
	  }
	  // Ist das Vielfache von 7 nicht mehr kleiner n, so wird die Summe ausgegeben
	  System.out.println(summe);
	}

}
