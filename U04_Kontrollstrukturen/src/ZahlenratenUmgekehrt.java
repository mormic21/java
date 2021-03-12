
public class ZahlenratenUmgekehrt
{

	public static void main(String[] args) {
		// Ausgabe der Überschrift
		System.out.println("Umgekehrtes Zahlenraten");
		System.out.println("=======================");
		System.out.println("Suchen Sie sich eine Zahl im Intervall [0, 1000]");
		System.out.println("aus. Ich werde sie finden");
		//Erster Tipp ist 500
		int tipp = 500;
		int ende = 0;
		//Solange ende kleiner 1 ist, wird folgende Schleife immer ausgeführt
		while (ende < 1) {
			//Ausgabe des Tipps
			System.out.println("Mein Tipp: "+tipp);
			//Der Benutzer antwortet ob die ausgedachte Zahl kleiner oder größer ist, oder ob die Zahl gefunden wurde
			int antwort = TestScanner.readInt("Zahl kleiner (0), größer (1), gefunden (2): ");
			//Mehrfachauswahl: Wenn Antwort...
			switch (antwort) {
				//Sollte antwort 0 sein, so wird vom tipp (tipp/16) abgzogen. Dann wird die switch-Schleife abgebrochen
				case 0: {
					tipp = tipp - (tipp/16);
					/*
					 * Wenn Tipp kleiner gleich 20 ist, so wird die subtraktion wieder rückgängig gemacht und 1 abgezogen,
					 * um eine Ansteuerung von Zahlen unter 20 zu ermöglichen
					 */
					if(tipp <= 20) {
						tipp = tipp + (tipp/16);
						tipp--;
					}
					break;
				}
			  //Sollte antwort 1 sein, so wird zum tipp (tipp/16) addiert. Dann wird die switch-Schleife abgebrochen
				case 1: {
					tipp = tipp + (tipp/16);
					/*
					 * Wenn Tipp kleiner gleich 20 ist, so wird die addition wieder rückgängig gemacht und 1 dazu-addiert,
					 * um eine Ansteuerung von Zahlen unter 20 zu ermöglichen
					 */
					if(tipp <= 20) {
						tipp = tipp - (tipp/16);
						tipp++;
					}
					break;
				}
				/*
				 * Sollte antwort 2 sein, so wurde die Zahl gefunden, es erfolgt eine entsprechende Ausgabe und 
				 * das Programm wird durch erhöhen von ende beendet.
				 */
				case 2: {
					System.out.println("Ich habe die Zahl gefunden!");
					ende++;
				}
			}
		}

	}

}
