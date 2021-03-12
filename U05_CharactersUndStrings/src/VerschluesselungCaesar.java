
public class VerschluesselungCaesar {

	public static void main(String[] args) {
		// Ausgabe �berschrift
		System.out.println("Verschl�sselung nach C�sar");
		System.out.println("==========================");
		/*
		 * Eine Variable wird definiert, welche daf�r sorgt, dass das Programm immer wieder 
		 * widerholt wird bis es explizit abgebrochen wird
		 */
		int wiederholen = 0;
		while (wiederholen == 0) {
			/*
			 * Der Benutzer kann mittels einem Buchstaben den Modus ausw�hlen. Sollte ein Gro�buchstaben
			 * eingegeben werden, so wird dieser zu einem Kleinbuchstaben konvertiert
			 */
			char modus = Character.toLowerCase((TestScannerErweitert.readChar("V>erschl�sseln, E>ntschl�sseln, "
	                + "A>bbruch: ")));
			//Strings mit dem Alphabet in Gro�buchstaben/Kleinbuchstaben, welche zur Verschl�sselung benutzt werden.
			String abcgro� = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			//Sollte der Modus v gew�hlt werden
			if (modus == 'v') {
				//Benutzereingabe des Textes, welcher verschl�sselt werden soll
				String neutext = TestScannerErweitert.readString("Text: ");
				//Benutzereingabe der Verschiebung im Alphabet
				int verschiebung = TestScannerErweitert.readInt("Verschiebung: ");
				//Der eingegebene Text wird in Gro�buchstaben konvertiert
				String text = neutext.toUpperCase();
				//Ausgabe (Benutzerschnittstelle)
				System.out.print("Verschl�sselt: ");
				/*
				 * Jedes einzelne Zeichen des eingegebenen Strings werden angesteuert und geschaut ob sie
				 * ein Buchstabe sind. Wenn dem so ist, wird dieses Zeichen mit dem Alphabet 
				 * verglichen. So wird die Stelle des Zeichens im Alphabet ermittelt. Zu der Integerzahl, 
				 * welche die Stelle angibt, wird die Verschiebung addiert und der Gro�buchstabe der neuen
				 * Stelle wird schlie�lich ausgegeben.
				 */
				for (int i = 0; i < text.length(); i++) {
					//Zeichen ist Buchstabe
					if (Character.isLetter(text.charAt(i))) {
						//variablendeklaration
						int stelle = 0;
						int stop = 0;
						//Suche nach dem Zeichen im Alphabet
						while (stop == 0) {
							if (text.charAt(i) == abcgro�.charAt(stelle)) {
								stop++;
							}
							else {
								stelle++;
							}
						}
						//Zur Stelle wird die Verschiebung addiert
						int neustelle = stelle + verschiebung;
						//Ist die neue Stelle gr��er als 25, so wird die Stelle modulo 26 berechnet
						if (neustelle > 25) {
							neustelle = neustelle % 26;
						}
						//Ausgabe des verschl�ssselten Gro�buchstabens
						System.out.print(abcgro�.charAt(neustelle));
					}
				}
				//Ausgabe Absatz
				System.out.println();
			}
			//Wenn der Modus e = entschl�sseln gew�hlt wird
			if (modus == 'e') {
				//Benutzereingabe des zu �bersetzenden Textes
				String neutext = TestScannerErweitert.readString("Text: ");
				//Benutzereingabe der Verschiebung
				int verschiebung = TestScannerErweitert.readInt("Verschiebung: ");
				//Der eingegebene Text wird zu Gro�buchstaben konvertiert
				String text = neutext.toUpperCase();
				//Ausgabe
				System.out.print("Entschl�sselt: ");
				/*
				 * Jedes einzelne Zeichen des eingegebenen Strings werden angesteuert und geschaut ob sie
				 * ein Buchstabe sind. Wenn dem so ist, wird dieses Zeichen mit dem Alphabet in Gro�buchstaben
				 * verglichen. So wird die Stelle des Zeichens im Alphabet ermittelt. Zu der Integerzahl, 
				 * welche die Stelle angibt, wird die Verschiebung addiert und der Gro�buchstabe der neuen
				 * Stelle wird schlie�lich ausgegeben.
				 */
				for (int i = 0; i < text.length(); i++) {
					//Ist Buchstabe
					if (Character.isLetter(text.charAt(i))) {
						//Variablendeklarationen
						int stelle = 0;
						int stop = 0;
						//Suche nach der Stelle im Alphabet
						while (stop == 0) {
							if (text.charAt(i) == abcgro�.charAt(stelle)) {
								stop++;
							}
							else {
								stelle++;
							}
						}
						//Von der Stelle wird die Verschiebung abgezogen
						int neustelle = stelle - verschiebung;
						/*
						 * Wenn die Stelle kleiner 0 ist, so wird aus der negativen Zahl die positive 
						 * Zahl ermittelt und die Differenz auf 26 ist die neue Stelle
						 */
						if (neustelle < 0) {
							neustelle = neustelle * -1;
							neustelle = 26-neustelle;
						}
						//Ausgabe des entschl�sselten Gro�buchstabens
						System.out.print(abcgro�.charAt(neustelle));
					}
				}
				//Ausgabe Absatz
				System.out.println();
				
			}
			/*
			 * Wenn der Modus a = abbrechen gew�hlt wird, so wird die Variable wiederholen auf 1
			 * gesetzt und so die Haupt-While-Schleife abgebrochen
			 */
			if (modus == 'a') {
				wiederholen = 1;
			}
		}
	}

}
