
public class WortRatespiel {

	public static void main(String[] args) {
		// Ausgabe der Überschrift
		System.out.println("Wortratespiel");
		System.out.println("=============");
		//Initialisierung und Deklaration von Variablen
		boolean wiederholen = true;
		String tipp = "";
		String tippbuchstaben = "";
		String ihrwort = "";
		int counter = 0;
		//Hauptschleife, die das Programm immer wieder wiederholt, bis es explizit abgebrochen wird
		while (wiederholen == true) {
			//Benutzereingabe des gesuchten Worts, welche dann zu Großbuchstaben konvertiert wird
			String wortgesucht = TestScannerErweitert.readString("Gesuchtes Wort: ");
			wortgesucht = wortgesucht.toUpperCase();
			//Ausgabe
			System.out.print("Ihr Wort:       ");
			//Für jedes Zeichen des gesuchten Worts wird ein Punkt ausgegeben 
			for (int i = 0; i < wortgesucht.length(); i++) {
				System.out.print(".");
			}
			//Ausgabe Absatz
			System.out.println();
			boolean stop = false;
			//Schleife, welche den Raten-vorgang so lange wiederholt bis das Wort gefunden wird
			while (stop == false) {
				//Eingabe des Tipps vom Benuter. Einzelner Buchstabe oder auch ein ganzes Wort sind möglich
				tipp = "";
				tipp = tipp + TestScannerErweitert.readString("Buchstabe/Wort: ");
				//Konvertierung zu Großbuchstaben
				tipp = tipp.toUpperCase();
				//Wurde das gesuchte Wort nicht gefunden...
				if (!tipp.equals(wortgesucht)) {
					//Ausgabe
					System.out.print("Ihr Wort:       ");
					/*
					 * Wenn der eingegeben Tipp nur aus einem Buchstaben besteht, so wird dieser in der
					 * Variable tippbuchstaben gespeichert, wo auch die anderen Tipps gespeichert werden
					 */
					if (tipp.length() <= 1) {
						tippbuchstaben = tippbuchstaben + tipp;
					}
					//Initialisierung für die Punkt-Ausgabe
					boolean punkt = true;
					//Die Strings werden mithilfe des Index untersucht und jedes einzelne Zeichen einzeln angesprochen
					for (int i = 0; i < wortgesucht.length(); i++) {
						for (int j = 0; j < tippbuchstaben.length(); j++) {
							/*
							 * Wurde ein Tipp-Buchstabe im gesuchten Wort gefunden, so wird dieser an der 
							 * richtigen Stelle eingesetzt und es wird kein Punkt ausgegeben.
							 */
							if (wortgesucht.charAt(i) == tippbuchstaben.charAt(j)) {
								ihrwort = ihrwort + tippbuchstaben.charAt(j);
								punkt = false;
							}
						}
						//Wenn die Buchstaben nicht übereinstimmen, so wird an dieser Stelle ein Punkt eingesetzt
						if (punkt == true) {
							ihrwort = ihrwort + ".";
						}
						punkt = true;
						//Ausgabe
						System.out.print(ihrwort);
						//ihrwort wird für den erneuten Durchlauf geleert
						ihrwort = "";
					}
					//Ausgabe Absatz
					System.out.println(ihrwort);
				}
				//counter zählt die benötigten Schritte
				counter++;
				//Wurde das Wort gefunden...
				if(tipp.equals(wortgesucht)) {
					//So erfolgt eine Ausgabe mit den benötigten Schritten
					System.out.println("Sie haben in "+counter+" Schritten das Wort erraten!");
					//Benutzereingabe ob das Programm abgebrochen werden soll oder nicht
					stop = true;
					char abbrechen = 0;
					boolean falsch = true;
					while (falsch == true) {
						abbrechen = TestScannerErweitert.readChar("Nochmal (j/n) ? ");
						//Schutz vor Falscheingaben
						if (abbrechen != 'j' && abbrechen != 'n') {
							System.out.println("Geben Sie bitte j oder n ein, danke :)");
						}
						else {
							falsch = false;
						}
					}
					System.out.println();
					//Wenn 'n' gewählt wurde so wird wiederholen auf false gestetzt und so die Haupt-While-Schleife abgebrochen 
					if (abbrechen == 'n') {
						wiederholen = false;
					}
				}
				
			}
		}

	}

}
