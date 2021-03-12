
public class Primfaktoren
{

	public static void main(String[] args) {
		// Ausgabe der Überschrift
		System.out.println("Primfaktorzerlegung");
		System.out.println("===================");
		//Variablen-Deklaration
		int i = 0;
		/*
		 * Es wird geschaut ob die eingegebene Zahl größer als 1 ist. Ist das der Fall, so werden die Primfaktoren 
		 * berechnet. Ansonsten erfolgt eine Fehlermeldung und der Benutzer wird zur erneuten Eingabe
		 * aufgefordert
		 */
		while (i < 1) {
			int n = TestScanner.readInt("Geben Sie die Zahl ein: ");
			if (n > 1) {
				//Ausgabe der Benutzerschnittstelle
				System.out.println();
				System.out.println("Die Zerlegung lautet:");
				//Der Teiler soll am Anfang  gleich 2 sein
				int teiler = 2;
				//n wird in der Variable Zahl für die spätere Ausgabe abgespeichert
				int zahl = n;
				/*
				 * Solange die Zahl n größer als 1 ist, wird geschaut ob n durch den teiler teilbar ist.
				 * Ist das der Fall so wird die Division durchgeführt und der teiler wird ausgegeben.
				 * Ansonsten wird der teiler um 1 erhöht.
				 */
				while (n > 1) {
					if (n % teiler == 0) {
						n = n / teiler;
						System.out.print(teiler);
						if (n > 1) {
				  		System.out.print(" * ");
				  	}
					}
					else {
						teiler++;
					}
				}
				//Finale Ausgabe am Ende der Primfaktor-Berechnung
				System.out.print(" = "+zahl);
				i++;
			}
			else {
				//Fehlermeldung, wenn die eingegebene Zahl nicht größer 1 ist
				System.out.println("Zahl muss größer als 1 sein");
			}
			
		}

	}

}
