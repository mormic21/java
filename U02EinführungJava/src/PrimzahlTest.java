
public class PrimzahlTest 
{

	public static void main(String[] args) {
		//Die Variable z wird aus der Konsole ausgelesen
		int z = Integer.parseInt(args[0]);
		//Die Variable i erhält den Wert 2
		int i = 2;
		//Die Variable primz erhält den Wert 1
		int primz = 1;
		//Wenn z größer 1 ist wird die while-schleife ausgeführt
		if (z > 1) {
		//Solange i kleiner z ist, wird die if-Schleifen geprüft und i um 1 erhöht
			while (i < z) {
				/*
				 * Wenn z durch i teilbar ist, so wird die Variable primz gleich 0 gessetzt und die Variable i gleich der Variable
				 * z gesetzt
				 */
				if (z % i == 0) {
					primz = 0;
					i = z;
				}
				i = i + 1;
			}
		}
		else {
			primz = 0;
		}
		//Wenn die Variable primz gleich 0 ist, so wird ausgegeben, dass die eingegebene Zahl z KEINE Primzahl ist
		if (primz == 0) {
			System.out.println("Die eingegebene Zahl ist KEINE Primzahl!");
		}
		//Ansonsten wird ausgegeben, dass die eingegebene Zahl z EINE Primzahl ist
		else {
			System.out.println(" Die eigegebene Zahl ist eine Primzahl :)");
	  }
	}	
}


