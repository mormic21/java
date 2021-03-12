
public class UmrechnungVonZehn
{

	public static void main(String[] args) {
	  //Ausgabe der Überschrift
		System.out.println("Umrechnung vom Zehnersystem");
		System.out.println("===========================");
		//Benutzereingabe von Zahl
		int zahl = TestScanner.readInt("Geben Sie die Zahl ein: ");			
		int i = 0;
		//Solange i kleiner 1 ist wird der Benutzer dazu aufgefordert die Basis einzugeben 
		while (i < 1) {
			int basis = TestScanner.readInt("Geben sie die Basis ein: ");
			/*
			 * Wenn die Basis zwischen 2 und 9 ist, dann wird die Umrechnung ausgeführt, ansonsten kommt es
			 * zu einer Fehlermeldung und der Benutzer wird erneut dazu aufgefordert die Basis einzugeben
			 */
			if (basis >= 2 && basis <= 9) {
				//Variablen-Deklarationen, welche für die Umrechnung gebruacht werden
				int rest = 0;
				int laenge = 1;
				int sum = 0;
				/*
				 * Solange zahl größer gleich 1 ist wird der Rest der Division aus zahl / basis berechnet.
				 * Die Zahl wird durch die Basis geteilt. Die sum (also das Endergebnis) wird aus dem Integer-Wert
				 * von sum+rest*laenge berechnet und schließlich wird die länge mit 10 multipliziert
				 */
				while (zahl >= 1) {
					rest = zahl % basis;
					zahl /= basis;
					sum = (int)(sum+rest*laenge);
					laenge *= 10;
				}
				//Am Ende erfolgt die Ausgabe der umgerechneten Zahl
				System.out.println();
				System.out.println("Die Zahl im "+basis+"-ersystem lautet "+sum);
				//Die Haupt-Schleife wird durch das Erhöhen von i abgebrochen
				i = 1;
			}
			else {
				//Fehlermeldung, sollte basis nicht zwischen 2 und 9 liegen
				System.out.println("Basis muss zwischen 2 und 9 liegen");
			}
		}
	}
}
