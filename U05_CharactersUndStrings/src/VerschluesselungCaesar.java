
public class VerschluesselungCaesar {

	public static void main(String[] args) {
		// Ausgabe Überschrift
		System.out.println("Verschlüsselung nach Cäsar");
		System.out.println("==========================");
		/*
		 * Eine Variable wird definiert, welche dafür sorgt, dass das Programm immer wieder 
		 * widerholt wird bis es explizit abgebrochen wird
		 */
		int wiederholen = 0;
		while (wiederholen == 0) {
			/*
			 * Der Benutzer kann mittels einem Buchstaben den Modus auswählen. Sollte ein Großbuchstaben
			 * eingegeben werden, so wird dieser zu einem Kleinbuchstaben konvertiert
			 */
			char modus = Character.toLowerCase((TestScannerErweitert.readChar("V>erschlüsseln, E>ntschlüsseln, "
	                + "A>bbruch: ")));
			//Strings mit dem Alphabet in Großbuchstaben/Kleinbuchstaben, welche zur Verschlüsselung benutzt werden.
			String abcgroß = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			//Sollte der Modus v gewählt werden
			if (modus == 'v') {
				//Benutzereingabe des Textes, welcher verschlüsselt werden soll
				String neutext = TestScannerErweitert.readString("Text: ");
				//Benutzereingabe der Verschiebung im Alphabet
				int verschiebung = TestScannerErweitert.readInt("Verschiebung: ");
				//Der eingegebene Text wird in Großbuchstaben konvertiert
				String text = neutext.toUpperCase();
				//Ausgabe (Benutzerschnittstelle)
				System.out.print("Verschlüsselt: ");
				/*
				 * Jedes einzelne Zeichen des eingegebenen Strings werden angesteuert und geschaut ob sie
				 * ein Buchstabe sind. Wenn dem so ist, wird dieses Zeichen mit dem Alphabet 
				 * verglichen. So wird die Stelle des Zeichens im Alphabet ermittelt. Zu der Integerzahl, 
				 * welche die Stelle angibt, wird die Verschiebung addiert und der Großbuchstabe der neuen
				 * Stelle wird schließlich ausgegeben.
				 */
				for (int i = 0; i < text.length(); i++) {
					//Zeichen ist Buchstabe
					if (Character.isLetter(text.charAt(i))) {
						//variablendeklaration
						int stelle = 0;
						int stop = 0;
						//Suche nach dem Zeichen im Alphabet
						while (stop == 0) {
							if (text.charAt(i) == abcgroß.charAt(stelle)) {
								stop++;
							}
							else {
								stelle++;
							}
						}
						//Zur Stelle wird die Verschiebung addiert
						int neustelle = stelle + verschiebung;
						//Ist die neue Stelle größer als 25, so wird die Stelle modulo 26 berechnet
						if (neustelle > 25) {
							neustelle = neustelle % 26;
						}
						//Ausgabe des verschlüssselten Großbuchstabens
						System.out.print(abcgroß.charAt(neustelle));
					}
				}
				//Ausgabe Absatz
				System.out.println();
			}
			//Wenn der Modus e = entschlüsseln gewählt wird
			if (modus == 'e') {
				//Benutzereingabe des zu übersetzenden Textes
				String neutext = TestScannerErweitert.readString("Text: ");
				//Benutzereingabe der Verschiebung
				int verschiebung = TestScannerErweitert.readInt("Verschiebung: ");
				//Der eingegebene Text wird zu Großbuchstaben konvertiert
				String text = neutext.toUpperCase();
				//Ausgabe
				System.out.print("Entschlüsselt: ");
				/*
				 * Jedes einzelne Zeichen des eingegebenen Strings werden angesteuert und geschaut ob sie
				 * ein Buchstabe sind. Wenn dem so ist, wird dieses Zeichen mit dem Alphabet in Großbuchstaben
				 * verglichen. So wird die Stelle des Zeichens im Alphabet ermittelt. Zu der Integerzahl, 
				 * welche die Stelle angibt, wird die Verschiebung addiert und der Großbuchstabe der neuen
				 * Stelle wird schließlich ausgegeben.
				 */
				for (int i = 0; i < text.length(); i++) {
					//Ist Buchstabe
					if (Character.isLetter(text.charAt(i))) {
						//Variablendeklarationen
						int stelle = 0;
						int stop = 0;
						//Suche nach der Stelle im Alphabet
						while (stop == 0) {
							if (text.charAt(i) == abcgroß.charAt(stelle)) {
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
						//Ausgabe des entschlüsselten Großbuchstabens
						System.out.print(abcgroß.charAt(neustelle));
					}
				}
				//Ausgabe Absatz
				System.out.println();
				
			}
			/*
			 * Wenn der Modus a = abbrechen gewählt wird, so wird die Variable wiederholen auf 1
			 * gesetzt und so die Haupt-While-Schleife abgebrochen
			 */
			if (modus == 'a') {
				wiederholen = 1;
			}
		}
	}

}
