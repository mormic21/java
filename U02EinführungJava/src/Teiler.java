
public class Teiler
{

	public static void main(String[] args) {
		//Die variable z wird von der Konsole ausgelesen
		int z = Integer.parseInt(args [0]);
		//Die Variable i soll gleich 1 sein
		int i = 1;
		/*
		 * Solange i kleiner gleich z ist, wird geprüft, ob z durch i teilbar ist. Wenn dem so ist, wird die Variable i ausgeben.
		 * Wird die Bedingung nciht erfüllt, so passiert nichts.
		 */
		while(i <= z) {
			if (z % i == 0) {
				System.out.println(i);
			}
			else {
				
			}
			//Die Variable i wird um 1 erhöht
			i = i + 1;
		}

	}

}
