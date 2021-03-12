
public class SparenInRaten {

	public static void main(String[] args) {
		//Überschrift wird ausgegeben
		System.out.println("Sparen in Raten");
		System.out.println("===============");
		//Für die Variable guthabenanfang vom Typ Integer gibt der Benutzer einen Wert ein
		int guthabenanfang = TestScanner.readInt("Geben Sie das Anfangskapital ein: ");
		//Für die Variable monatsrate vom Typ Integer gibt der Benutzer einen Wert ein
		int monatsrate = TestScanner.readInt("Geben Sie die Monatsrate ein: ");
		//Für die Variable jahreszinssatz vom Typ Double gibt der Benutzer einen Wert ein
		double jahreszinssatz = TestScanner.readDouble("Geben Sie den Jahreszinssatz ein: ");
		//Die Variable gesamtzins vom Typ Double soll gleich der Variable jahreszinssatz sein
		double gesamtzins = 0;
		// In der For-schleife wird 12 mal ausgeführt
		for(int i = 12; i > 0; i--) {
			gesamtzins = gesamtzins + (jahreszinssatz * i/12D);
		}
		//Der Wert für die Variable guthabenende wird berechnet
		double guthabenende = guthabenanfang +(guthabenanfang* jahreszinssatz)/100 + 12* monatsrate + gesamtzins/2;
		//Auf 2 Kommastellen abrunden
		double guthabenendegerundet = Math.floor(guthabenende*100.0)/100.0;
		//Ein Absatz wird ausgegeben
		System.out.println();
		//Das Guthaben am Ende des Jahres wird ausgegeben
		System.out.println("Das Guthaben am Ende des Jahres beträgt "+guthabenendegerundet);

	}

}
