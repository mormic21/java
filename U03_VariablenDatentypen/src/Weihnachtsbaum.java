
public class Weihnachtsbaum
{

	public static void main(String[] args) {
		//Die Variable anzahlleerzeichen vom Typ Integer wird mit dem Wert 14 initialisiert
		int anzahlleerzeichen = 14;
		//Die Variable anzahlsterne vom Typ Integer wird mit dem Wert 1 initialisiert
		int anzahlsterne = 1;
		/*
		 * Für die for-schleife wird die Variable j mit dem Wert 1 initialisiert. Solange j kleiner gleich 
		 * 15 ist wird der Code innerhalb der Schleife ausgeführt. Nach der Ausführung wird die Laufvariable
		 * j um 1 erhöht.
		 */
		for (int j = 1; j <=15; j++) {
			//Die Methode printLeerzeichen wird aufgerufen und die Variable anzahlleerzeichen wird übergeben
			printLeerzeichen(anzahlleerzeichen);
			//Die Methode printSterne wird aufgerufen und die Variable anzahlsterne wird übergeben
			printSterne(anzahlsterne);
		  //Die Methode printLeerzeichen wird aufgerufen und die Variable anzahlleerzeichen wird übergeben
			printLeerzeichen(anzahlleerzeichen);
			//Absatz wird ausgegeben
			System.out.println();
			//Die Variable anzahlleerzeichen wird um 1 erniedrigt
			anzahlleerzeichen--;
			//Die Variable anzahlsterne wird um 2 erhöht
			anzahlsterne = anzahlsterne +2;
		}
		//Die Variable anzahlleerzeichen soll sein 13
		anzahlleerzeichen = 13;
		//Die Variable anzahlsterne soll sein 3
		anzahlsterne = 3;
		/*
		 * Für die for-Schleife wird die Laufvariable m mit 1 initialisiert. Solange m kleiner gleich
		 * 3 ist, so wird der Code innerhalb der Schleife ausgeführt. Nach der Ausführung wird die Laufvariable
		 * m um 1 erhöht.
		 */
		for (int m = 1; m <= 3; m++) {
		  //Die Methode printLeerzeichen wird aufgerufen und die Variable anzahlleerzeichen wird übergeben
			printLeerzeichen(anzahlleerzeichen);
		  //Die Methode printSterne wird aufgerufen und die Variable anzahlsterne wird übergeben
			printSterne(anzahlsterne);
		  //Die Methode printLeerzeichen wird aufgerufen und die Variable anzahlleerzeichen wird übergeben
			printLeerzeichen(anzahlleerzeichen);
			//Absatz wird ausgegeben
			System.out.println();
		}

	}
	//Methode printLeerzeichen für die Ausgabe von Leerzeichen
  public static void printLeerzeichen(int anzahl) {
  	//Der Wert der übermittelten Variable anzahl steuert wie viele Leerzeichen ausgegeben werden
  	for (int i = 1; i <= anzahl; i++) {
  		System.out.print(" ");
  	}
  }
  //Methode printSterne für die Ausgabe von Sternen
  public static void printSterne (int anzahl) {
  	//Der Wert der übermittelten Variable anzahl steuert wie viele Sterne ausgegeben werden
  	for (int n = 1; n <= anzahl; n++) {
  		System.out.print("*");
  	}
  }
}
