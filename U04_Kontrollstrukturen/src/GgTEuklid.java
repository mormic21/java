
public class GgTEuklid
{

	public static void main(String[] args) {
		//Überschrift wird ausgegeben
		System.out.println("Ggt von Euklid");
		System.out.println("==============");
		//Der Benutzer gibt 2 Zahlen im Integer-Format ein
		int zahl1 = TestScanner.readInt("Erste Zahl: ");
		int zahl2 = TestScanner.readInt("Zweite Zahl: ");
		//Wenn zahl1 durch zahl2 teilbar ist, dann ist zahl2 der größte gemeinsame Teiler
		if (zahl1 % zahl2 == 0) {
			System.out.println("Der größte gemeinsame Teiler lautet "+zahl2);
		}
		//Ansonsten:
		else {
			//Die Variable dividend wird mit dem Variablewert von zahl1 initialisiert
			int dividend = zahl1;
		  //Die Variable divisor wird mit dem Variablewert von zahl2 initialisiert
			int divisor = zahl2;
			//Die Variable ggt wird mit 0 initialisiert
			int ggt = 0;
			/*
			 * Solange dividend durch divisor NICHT teilbar ist, wird der Rest der Division berechnet,
			 * dann soll der divided der Wert des alten divisors haben und der divisor wird der Rest
			 * der vorherigen division zugeteilt
			 */
			while (dividend % divisor != 0) {
				ggt = dividend % divisor;
				dividend = divisor;
				divisor = ggt;
			}
			//Ausgabe Absatz
			System.out.println();
			//Ausgabe des ggTs
			System.out.println("Der größte gemeinsame Teiler lautet "+ggt);
		}

	}

}
