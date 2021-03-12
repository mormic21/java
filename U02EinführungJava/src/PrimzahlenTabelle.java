
public class PrimzahlenTabelle
{

	public static void main(String[] args) {
		//Überschrift wird ausgegeben
		System.out.println("Primzahlentabelle");
		System.out.println("=================");
		//Die Variablen zahl und n legen fest, welcher Zahlenbereich auf Primzahlen getestet wird
		int zahl = 90;
		int n = 120;
		/*
		 * Solange die Variable zahl kleiner gleich n ist, wird zunächst die Methode "printZahl", danach wird die Methode
		 * "istPrimzahl" aufgerufen. Anschließend wird die Variable zahl um 1 erhöht
		 */
		while (zahl <= n) {
			printZahl(zahl);
			istPrimzahl(zahl);
			zahl = zahl + 1;
		}

	}
	//Methode "istPrimzahl" für die Bestimmung ob die Variable zahl eine Primzahl ist mit anschließender Ausgabe
	public static void istPrimzahl(int zahl) {
		int i = 2;
		//Die Variable primz soll gleich 1 sein
		int primz = 1;
		//Wenn die Variable zahl größer 1 ist. so wird die while-schleife ausgeführt
		if (zahl > 1) {
		//Solange die Variable i kleiner als die Variable zahl ist, so wird geprüft, ob zahl durch i teilbar ist
			while (i < zahl) {
				/*
				 * Wenn zahl durch i teilbar ist, so wird die Variable primz gleich 0 gesetzt und die Variable i wird 
				 * gleich der Variable i gesetzt
				 */
				if (zahl % i == 0) {
					primz = 0;
					i = zahl;
				}
				//Die Variable i wird um 1 erhöht
				i = i + 1;
			}
		}
		//Ansonsten wird die Variable primz gleich 0 gesetzt
		else {
			primz = 0;
		}
		
		//Wenn die Variable primz gleich 0 ist, so wird ausgegeben: "ist nicht Primzahl"
		if (primz == 0) {
			System.out.println(" ist nicht Primzahl");
		}
		else {
			//Ansonsten wird ausgegeben: "ist Primzahl"
			System.out.println(" ist Primzahl");
		}
		
	}
	//Methode printZahl zum rechtsbündigen Ausgeben der Variable zahl
	public static void printZahl(int zahl) {
		//Wenn die Variable zahl kleiner 100 ist, so wird der Variabel-Wert mit 2 vorrausgehenden Leerzeichen ausgegeben
		if (zahl < 100) {
			System.out.print("  " + zahl);
		}
		else {
			//Ansonsten wird der Variabel-Wert nur mit einem vorrausgehenden Leerzeichen ausgegeben
			System.out.print(" " + zahl);
		}
		
	}

}
