
public class DoppelFaktorielle
{

	public static void main(String[] args) {
		// Aus der Zahl n wird die Doppelfaktorielle berechnet
		int n = Integer.parseInt(args [0]);
		// Der Rest der Divison n/2 soll 0 ergeben
		if (n % 2 == 0) {
			// Wenn n größer gleich 2 ist, so wird i gleich 2 und df gleich n gesetzt. Ansonsten gibt es eine Fehlermeldung
			if (n >= 2) {
				int i = 2;
				int df = n;
				/*
				 * Solange i kleiner n ist wird df mit (n-i) multipliziert und dieser Wert dann wieder in df gespeichert.
				 * Dann wird die Variable i um 2 erhöht.
				 */
				while (i < n) {
					df = df * (n - i);
					i = i + 2;
				}
				// Wenn i nicht mehr kleiner n ist, so wird df ausgegeben
				System.out.println(df);
			}
			else {
				//Ausgabe Fehlermeldung, wenn Zahl n ungültig
				System.out.println("Die eingegebene Zahl ist ungültig!");
			}
		}
		//Wenn der Rest der Divison n/2 nicht 0 ergibt
		else {
			if (n >= 1) {
			// Wenn n größer gleich 1 ist, so wird i gleich 2 und df gleich n gesetzt. Ansonsten gibt es eine Fehlermeldung
				int i = 2;
				int df = n;
				/*
				 * Solange i kleiner n ist wird df mit (n-i) multipliziert und dieser Wert dann wieder in df gespeichert.
				 * Dann wird die Variable i um 2 erhöht.
				 */
				while (i < n) {
					df = df * (n - i);
					i = i + 2;
				}
			// Wenn i nicht mehr kleiner n ist, so wird df ausgegeben
				System.out.println(df);
			}
			else {
			//Ausgabe Fehlermeldung, wenn Zahl n ungültig
				System.out.println("Die eingegebene Zahl ist ungültig!");
			}
		}
	}

}
