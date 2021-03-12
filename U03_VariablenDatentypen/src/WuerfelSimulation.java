
public class WuerfelSimulation
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Wuerfelsimulation");
		System.out.println("================");
		System.out.println("Bitte warten");
		//Die Variable anzahl1 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl1 = 0;
	  //Die Variable anzahl2 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl2 = 0;
	  //Die Variable anzahl3 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl3 = 0;
	  //Die Variable anzahl4 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl4 = 0;
	  //Die Variable anzahl5 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl5 = 0;
	  //Die Variable anzahl6 vom Typ Integer wird mit dem Wert 0 initialisiert.
		int anzahl6 = 0;
		/*
		 * Für die for-Schleife wird die Laufvariable i mit dem Wert 1 initialisert. Solange i kleiner als 1.000.000.000
		 * ist wird der Code in der Schleife ausgeführt. Nach der Ausführung wird 
		 * die Laufvariable um 1 erhöht.
		 */
		for (int i = 1; i <= 1000000000; i++) {
			//Wenn i durch 50.000.000 teilbar ist, so wird 1 Punkt ausgegeben.
			if (i % 50000000 == 0) {
				System.out.print(".");
				//Wenn die Variable i gleich 1.000.000.000 ist, so werden 2 Absaätze ausgegeben
				if (i == 1000000000) {
					System.out.println();
					System.out.println();
				}
			}
			//Die Variable zufall vom Typ Integer wird durch Math.random*6+1 berechnet.
			int zufall = (int)((Math.random()) * 6 + 1);
			//Wenn die Variable zufall gleich 1 ist, so wird die Variable anzahl1 um 1 erhöht
			if (zufall == 1) {
				anzahl1++;
			}
		  //Wenn die Variable zufall gleich 2 ist, so wird die Variable anzahl2 um 1 erhöht
			if (zufall == 2) {
				anzahl2++;
			}
		  //Wenn die Variable zufall gleich 3 ist, so wird die Variable anzahl3 um 1 erhöht
			if (zufall == 3) {
				anzahl3++;
			}
		  //Wenn die Variable zufall gleich 4 ist, so wird die Variable anzahl4 um 1 erhöht
			if (zufall == 4) {
				anzahl4++;
			}
		  //Wenn die Variable zufall gleich 5 ist, so wird die Variable anzahl5 um 1 erhöht
			if (zufall == 5) {
				anzahl5++;
			}
		  //Wenn die Variable zufall gleich 6 ist, so wird die Variable anzahl6 um 1 erhöht
			if (zufall == 6) {
				anzahl6++;
			}
		}
		//Die Variable anzahl1 wird ausgegeben
		System.out.println("Anzahl 1: "+anzahl1);
	  //Die Variable anzahl2 wird ausgegeben
		System.out.println("Anzahl 2: "+anzahl2);
	  //Die Variable anzahl3 wird ausgegeben
		System.out.println("Anzahl 3: "+anzahl3);
	  //Die Variable anzahl4 wird ausgegeben
		System.out.println("Anzahl 4: "+anzahl4);
	  //Die Variable anzahl5 wird ausgegeben
		System.out.println("Anzahl 5: "+anzahl5);
  	//Die Variable anzahl6 wird ausgegeben
		System.out.println("Anzahl 6: "+anzahl6);
		//Ein Absatz wird ausgegeben
		System.out.println();
		/*
		 * Die Anzahl der Würfe werden ausgegeben, diese wird aus der Summe von anzahl1, anzahl2, anzahl3, 
		 * anzahl4, anzahl5 und anzahl6
		 */
		System.out.println("Anzahl Würfe: "+(anzahl1+anzahl2+anzahl3+anzahl4+anzahl5+anzahl6));
		
	}

}
