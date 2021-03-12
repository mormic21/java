
public class VerschlüsselungDrehen {

	public static void main(String[] args) {
		// Ausgabe Überschrift
		System.out.println("Verschlüsselung durch Drehen");
		System.out.println("============================");
		//Variblendeklaration
		int wiederholen = 0;
		//Dieser Programmteil wird immer wieder wiederholt, bis er abgebrochen wird
		while (wiederholen == 0) {
			//Benutzereingabe Text
			String text = TestScannerErweitert.readString("Text: ");
			//Ist ein Zeichen vorhanden, so wird das Programm ausgeführt
			if (Character.isLetterOrDigit(text.charAt(0)) == true) {
				//Ausgabe
				System.out.print("Verschlüsselt: ");
				//Variableninitialisierungen für die Ansteuerung der Zeichen im String
				int count1 = 0;
				int count2 = text.length() - 1;
				int i = 0;
				/*
				 * Solange i kleiner als die Länge des String ist, wird das erste und letzte Zeichen,
				 * dann das zweite und vorletzte, dann das dritte und vorvorletzte Zeichen...usw. des 
				 * Strings ausgegeben. Das bildet dann die Verschlüsselung
				 */
				while (i < text.length()) {
					System.out.print(text.charAt(count1));
					count1++;
					i++;
					if (i < text.length()) {
						System.out.print(text.charAt(count2));
						count2--;
						i++;
					}
				}
				//Ausgabe Absatz
				System.out.println();
				/*
				 * Der Benutzer wird gefragt ob er nochmals eine Verschlüsselung machen möchte.
				 * Er kann mit den Zeichen j oder n antworten, welche über die Methode readChar der
				 * Klasse TestScannerErweitert eingelesen wird. Will der Benutzer das Programm beenden,
				 * so wird die Variable wiederholung gleich 1 gesetzt und somit die Haupt-while-schleife 
				 * abgebrochen.
				 */
				char ende = TestScannerErweitert.readChar("Nochmal (j/n)? ");
				if (ende == 'n') {
					wiederholen = 1;
				}
			}
			//Fehlermeldung, wenn Benutzereingabe kein Zeichen enthält
			else {
				System.out.println("Text muss mindestens ein Zeichen enthalten");
			}
		}

	}

}
