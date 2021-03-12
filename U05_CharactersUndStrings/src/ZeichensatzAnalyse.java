
public class ZeichensatzAnalyse {

	public static void main(String[] args) {
		// Ausgabe
		System.out.println("isLetter");
		// Variablendeklaration
		int counter = 0;
		/*
		 * Wenn die Zeichen zwischen 32 und 256 ein Buchstabe sind, so werden sie 
		 * in einer Zeile ausgegeben. Nach 30 Zeichen wird ein Absatz gemacht.
		 */
		for (int i = 32; i < 256; i++) {
			if (Character.isLetter(i) == true) {
				System.out.print((char)i+" ");
				counter++;
			    if (counter % 30 == 0) {
			    	System.out.println();
			    }
			}
		}
		//Ausgabe
		System.out.println();
		System.out.println("isDigit");
		/*
		 * Wenn die Zeichen zwischen 32 und 256 eine Zahl sind, so werden sie
		 * in einer Zeile ausgegeben.
		 */
		for (int i = 32; i < 256; i++) {
			if (Character.isDigit(i) == true) {
				System.out.print((char)i+" ");
			}
		}
		//Ausgabe
		System.out.println();
		System.out.println("isWhitespace");
		/*
		 * Wenn die Zeichen zwischen 32 und 256 ein Leerzeichen sind, so wird der
		 * Integer-Wert des Characters ausgegeben
		 */
		for (int i = 32; i < 256; i++) {
			if (Character.isWhitespace(i) == true) {
				System.out.print((int)i+" ");
			}
		}
		//Ausgabe
		System.out.println();
		System.out.println("isLowerCase");
		counter = 0;
		/*
		 * Wenn die Zeichen zwischen 32 und 256 ein kleiner Buchstabe sind, so werden die
		 * Character in einer Zeile ausgegeben. Nach 30 Zeichen wird ein Absatz gemacht
		 */
		for (int i = 32; i < 256; i++) {
			if (Character.isLowerCase(i) == true) {
				System.out.print((char)i+" ");
				counter++;
			    if (counter % 30 == 0) {
			    	System.out.println();
			    }
			}
		}
		//Ausgabe
		System.out.println();
		System.out.println("isUpperCase");
		counter = 0;
		/*
		 * Wenn die Zeichen zwischen 32 und 256 ein großer Buchstabe sind, so werden die
		 * Character in einer Zeile ausgegeben. Nach 30 Zeichen wird ein Absatz gemacht
		 */
		for (int i = 32; i < 256; i++) {
			if (Character.isUpperCase(i) == true) {
				System.out.print((char)i+" ");
				counter++;
			    if (counter % 30 == 0) {
			    	System.out.println();
			    }
			}
		}
	}

}
