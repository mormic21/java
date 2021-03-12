
public class TextStatistik {

	public static void main(String[] args) {
		// Ausgabe der Überschrift
		System.out.println("Textstatistik");
		System.out.println("=============");
		// Variablendeklaration
		int ok = 0;
		/*
		 * Es wird dazu aufgefordert einen Text einzugeben. Wird kein Zeichen eingegeben, so wird der 
		 * Benutzer erneut dazu aufgefordert
		 */
		while (ok == 0) {
			//Methode readString der Klasse TestScannerErweitert zur Benutzereingabe eines Strings
			String text = TestScannerErweitert.readString("Text: ");
			if (Character.isLetterOrDigit(text.charAt(0)) == true) {
				//Variablendeklaration
				int anzahlSelbstlaute = 0;
				int i = 0;
				/*
				 * Für jedes Zeichen des Strings wird geprüft ob es ein Selbstlaut ist.
				 * Wenn ja, so wird die Variable anzahlSelbstlaute erhöht.
				 */
				for (i = 0; i < text.length(); i++) {
					char c = text.charAt(i);
					if (c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                        c == 'A'|| c == 'E' || c == 'I' || c == 'O' || c == 'U') {
						anzahlSelbstlaute++;
					}
				}
				/*
				 * Für jedes Zeichen des Strings wird geprüft ob es ein Buchstabe ist.
				 * Wenn ja, so wird die Variable anzahlBuchstabe erhöht.
				 */
				int anzahlBuchstaben = 0;
				for (i = 0; i < text.length(); i++) {
					if (Character.isLetter(text.charAt(i)) == true) {
						anzahlBuchstaben++;
					}
				}
				/*
				 * Für jedes Zeichen des Strings wird geprüft ob es ein Leerzeichen ist.
				 * Wenn ja, so wird die Variable anzahlLeerzeichen erhöht.
				 */
				int anzahlLeerzeichen = 0;
				for (i = 0; i < text.length(); i++) {
					if (Character.isWhitespace(text.charAt(i)) == true) {
						anzahlLeerzeichen++;
					}
				}
				//Ausgabe eines Absatz und Ausgabe der Ergebnisse
				System.out.println();
				System.out.println("Anzahl Selbstlaute: "+anzahlSelbstlaute);
				System.out.println("Anzahl Buchstaben: "+anzahlBuchstaben);
				System.out.println("Anzahl Leerzeichen: "+anzahlLeerzeichen);
				//Die Anzhal der Zeichen wird aus der Länge des Strings ermittelz
				System.out.println("Anzahl Zeichen: "+text.length());
				//Das Programm wird beendet
				ok = 1;
			}
			else {
				//Fehlermeldung, wenn kein Zeichen eingegeben wurde
				System.out.println("Text muss mindestens ein Zeichen enthalten");
			}
		}

	}

}
