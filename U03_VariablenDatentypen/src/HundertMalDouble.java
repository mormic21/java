
public class HundertMalDouble
{

	public static void main(String[] args) {
		//Die Variable i vom Typ Integer wird mit 0 initialisiert
		int i = 0;
		//Die Variable summe vom Typ Double wird mit 0 initialisiert
		double summe = 0.0;
		//Solange die Variable i kleiner 100 ist wird folgendes ausgeführt:
		while (i < 100) {
			//Die Variable summe wird um 0.1 erhöht
			summe = summe + 0.1;
			//Die Laufvariable i wird um 1 erhöht
			i++;
		}
		//Sobald die Bedingungsprüfung der While-Schleife nicht mehr standhält, wird der Wert der Variable Summe ausgegeben
		System.out.println(summe);
	}

}
