
public class UmrechnungNachZehn
{

	public static void main(String[] args) {
	  //Ausgabe der Überschrift
		System.out.println("Umrechnung ins Zehnersystem");
		System.out.println("===========================");
		//Benutzereingabe von Zahl
		int zahl = TestScanner.readInt("Geben Sie die Zahl ein: ");
		int i = 0;
		/*
		 * Solange die Schleife durch das erhöhen von i nicht abgebrochen wird, wird der Benutzer dazu aufgefordert
		 * die Basis einzugeben.
		 */
		while (i < 1) {
			int basis = TestScanner.readInt("Geben sie die Basis ein: ");
			//Ist die Basis zwischen 2 und 9, so wird die Umrechnung ausgeführt ansonsten erfolgt eine Fehlermeldung.
			if (basis >= 2 && basis <= 9) {
				//Es wird geschaut wieviele stellen die Zahl hat
				int exponent = 0;
				int n = 1;
		  	while (zahl / n > 1) {
			  	n = n * 10;
			  	exponent ++;
			  }
			 	int zahl1 = 0;
			 	/*
			 	 * Solange die Zahl größer als 1 ist wird jede Ziffer der Zahl wird einzeln hervorgehoben und mit der Basis, 
			 	 * hoch dem Exponenten, multipliziert. Der exponent wird immer um 1 verringert.
			 	 */
			 	int summe = 0;
		  	while (zahl >= 1) {
			  	zahl1 = zahl / n;
			  	summe += zahl1 * Math.pow(basis, exponent);
			  	zahl = zahl % n;
				 	n = n / 10;
				 	exponent--;
			  }
		  	//Ausgabe der Zahl im Zehnersystem
		    System.out.println();
  	    System.out.println("Die Zahl im Zehnersystem lautet "+summe);
			  i = 1;
			}
			//Fehlermeldung, sollte die Basis nicht zwischen 2 und 9 liegen
			else {
		  	System.out.println("Basis muss zwischen 2 und 9 liegen");
		  }
		}
	}
}
