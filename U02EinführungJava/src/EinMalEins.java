
public class EinMalEins
{

	public static void main(String[] args) {
		// Überschrift wird ausgegeben
		System.out.println("Einmaleins-Tabelle");
		System.out.println("==================");
		// I soll 1 sein und zahl soll gleich 0 sein.
		int i = 1;
		int zahl = 0;
		//Solange i kleiner gleich 10 ist, wird n gleich 1 gesetzt und in die nächste Schleife gegangen.
		while (i <= 10) {
			int n = 1;
			//Solange n kleiner gleich 10 ist, werden i und n miteinander multipliziert und der Wert in zahl gespeichert
			while (n <= 10) {
				zahl = i * n;
				//Nun wird die Methode printZahl zur Ausgabe von zahl verwendet
				printZahl(zahl);
				//Die variable n wird um 1 erhöht
				n = n + 1;
			}
			//Es wird ein Absatz gemacht, sodass die Zahlen untereinander stehen
			System.out.println();
			//Die Variable i wird um 1 erhöht
			i =i + 1;
		}

	}
	// Methode printZahl: Zahlen untereinander rechtsbündig ausgeben
	public static void printZahl(int zahl) {
		//Wenn zahl kleiner 10 ist, so wird der Wert mit 3 Leerzeichen ausgegeben
		if (zahl < 10) {
			System.out.print("   " + zahl);
		}
		else {
			//Wenn zahl kleiner 100 ist, so wird die Zahl mit 2 Leerzeichen ausgegeben
			if (zahl < 100) {
				System.out.print("  " + zahl);
			}
			else {
				//Andere Werte werden nur mit einem Leerzeichen ausgegeben
				System.out.print(" " + zahl);
			}
		}
	}

}
