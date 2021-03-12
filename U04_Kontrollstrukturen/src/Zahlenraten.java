
public class Zahlenraten
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Zahlenraten");
		System.out.println("===========");
		System.out.println("Ich habe mir eine Zahl im Intervall [0, 1000] augedacht. Versuchen Sie diese zu erraten");
		//Es wird eine zufällige Zahl zwischen 1 und 1000 ermittelt
		int zahl = (int)((Math.random()) * 1000 + 1);
		int ende = 0;
		//Solange ende kleiner als ein ist, wird die Schleife immer wieder ausgeführt
		while (ende < 1) {
			//Der Benutzer gibt seinen Tipp ein
			int tipp = TestScanner.readInt("Ihr Tipp: ");
			/*
			 * Wenn der Tipp gleich der Zufallszahl ist, so wird ausgegeben, dass der Benutzer die Zahl gefunden hat 
			 * und die Schleife wird abgebrochen, indem ende erhöht wird
			 */
			if (tipp == zahl) {
				System.out.println("Mein Kompliment! Sie haben die Zahl gefunden");
				ende++;
			}
			//Wenn der Tipp kleiner als die Zufallszahl ist, so wird ausgegeben, dass die eingegebene Zahl zu klein ist.
			if (tipp < zahl) {
				System.out.println("Ihre Zahl ist zu klein");
			}
			//Wenn der Tipp größer als die Zufallszahl ist, so wird ausgegeben, dass die eingegebene Zahl zu groß ist.
			if (tipp > zahl) {
				System.out.println("Ihre zahl ist zu groß");
			}
			
		}

	}

}
