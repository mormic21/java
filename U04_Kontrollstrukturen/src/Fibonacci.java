
public class Fibonacci
{

	public static void main(String[] args) {
		//Überschrift wird ausgegeben
		System.out.println("Fibonacci-Zahlen");
		System.out.println("================");
		//Die Variable i wird mit dem Wert 0 initialisiert
		int i = 0;
		//Solange i kleiner 1 ist, weird der gesamte Block wiederholt
		while (i < 1) {
			//Der Benutzer gibt die Xte-Zahl der Fibonacci-Zahlenfolge ein
			int zahl = TestScanner.readInt("Die wievielte Zahl? ");
			//Wenn zahl größer gleich 0 ist
			if (zahl >= 0) {
				//Wenn zahl gleich 0 oder gleich 1 ist, so wird ausgegeben, dass die Fibonacci-Zahl 1 ist, dann wir das Programm gestoppt
				if (zahl == 0 || zahl == 1) {
					System.out.println("Die "+zahl+". Fibonacci-Zahl lautet 1");
					i = 5;
				}
				//Ansonsten
				else {
					//Deklaration von Variablen vom Typ Integer um die Fibonacci-Zahl zu berechnen
					int fibzahl1 = 0;
					int fibzahl2 = 1;
					int fibsumme = 0;
					//Solange n (gleich der Variable zahl) größer als 0 ist, wird der Block ausgeführt und die Variable n um 1 erniedrigt
					for (int n = zahl; n > 0; n--) {
						fibsumme = fibzahl1 + fibzahl2;
						fibzahl1 =  fibzahl2;
						fibzahl2 = fibsumme;
					}
					//Ausgabe der Fibonacci-Zahl
					System.out.println("Die "+zahl+". Fibonacci-Zahl lautet "+fibsumme);
					//Stoppen des Programms
					i = 5;
				}
			}
			else {
				/*
				 * Sollte die eingegebene Zahl nicht größer gleich 0 sein, so wird folgendes ausgegeben und der Benutzer
				 * wird nochmals aufgefordert eine Zahl einzugeben
				 */
				System.out.println("Die Zahl muss größer oder gleich 0 sein");
			}
		}
	}
}
