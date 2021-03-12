
public class ISOLatin1Zeichensatz {

	public static void main(String[] args) {
		// Variabeldefinition für einen Counter
		int counter = 1;
		//Wenn i zwischen 32 und 256 liegt wird die Schleife ausgeführt und die Laufvariable um 1 erhöht
		for (int i = 32; i < 256; i++) {
			//Ausgabe von Zeichen und Zeichen mit 2 Leerzeichen dazwischen
			if (i < 100) {
				System.out.print("  "+i+" "+ (char)i);
			}
			//Ausgabe von Zeichen und Zeichen mit 1 Leerzeichen dazwischen
			else {
				System.out.print(" "+i+" "+ (char)i);
			}
			//Nach 8 Ausgaben wird ein Absatz gemacht 
			if (counter % 8 == 0) {
				System.out.println();
			}
			//Erhöhung des Counters
			counter++;
		}

	}

}
