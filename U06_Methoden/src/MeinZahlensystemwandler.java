public class MeinZahlensystemwandler
{
	/**
	 * Wandelt das Zeichen nr in eine Zahl um, wobei die Groß-/Klein-schreibung 
	 * ignoriert wird:
	 * '0' ergibt 0, '1' ergibt 1, ... '9' ergbit 9, 'A' ergibt 10, 'B' ergibt 11, ...,
	 * 'Z' ergibt 35
	 * Sollte ein ungültiges Zeichen übergeben werden, so gibt die Methode -1 zurück
	 * @param nr das umzuwandelnde Zeichen
	 * @return die Zahl für die das Zeichen steht
	 */
	public static int getDigit (char nr) {
		int ret = -1;
		if(Character.isLetter(nr) || Character.isDigit(nr) ) {
			nr = Character.toUpperCase(nr);
			if (Character.isDigit(nr)) {
				ret = (nr) - 48;
			}
			if (Character.isLetter((nr))) {
				ret = (nr) - 55;
			}
		}
		return ret;
	}
	/**
	 * Wandelt die Nummer der Ziffer nr in ein Zeichen um:
	 * 0 ergibt '0', 1 ergibt '1', ..., 9 ergibt '9', 10 ergibt 'A', 11 ergibt 'B', 
	 * ..., 35 ergibt 'Z'
	 * Sollte eine ungültige Nummer übergeben werden, so gibt die Methode einen Stern 
	 * '*' zurück
	 * @param nr die Nummer welche in ein Zeichen umgewandelt werden soll
	 * @return das Zeichen das für die Nummer steht
	 */
	public static char getDigit (int nr) {
		char ret = '*';
		if (nr >= 0 && nr <= 35) {
			if (nr < 10) {
				ret = (char)(48+nr);
			}
			if (nr >= 10) {
				ret = (char)(55+nr);
			}
		}
		return ret;
	}
	
	/**
	 * Wandelt die Zahl num mit der Basis basis in eine Dezimalzahl um und liefert
	 * diese zurück. Falls die übergebene Zahl num gleich null oder deren Länge gleich
	 * 0 ist oder die Basis kleiner als 2 ist, wird -1 zurück geliefert. Wenn eine
	 * Ziffer der übergebenen Zahl nicht zur Basis passt, wird ebenfalls -1 zurück
	 * geliefert
	 * Beispiel: numToDec("01110110", 2) ergibt 118
	 * numToDec("170712", 8) ergibt 61898
	 * numToDec("170712", 7) ergibt -1
	 * @param num die umzuwandelnde Zahl als String übergeben
	 * @param basis die Basis der umzuwandelnden Zahl
	 * @return das Ergebnis im Dezimalsystem
	 */
	public static int numToDec(String num, int basis) {
		int ret = -1;
		if (num != null && num.length() > 0 && basis >= 2 && 
			MeinStringAnalysierer.zaehleZeichen(num, getDigit(basis)) == 0) {
			ret = 0;
			int j = 0;
			for (int i = num.length()-1; i >= 0; i--) {
				ret = ret + (getDigit(num.charAt(i)) * (int)Math.pow(basis, j));
				j++;
			}
		}
		return ret;
	}
	
	/**
	 * Wandelt die Dezimalzahl dec in eine Zahl mit der Basis basis um und gibt diese
	 * zurück. Dabei muss die Dezimalzahl dec größer oder gleich 0 sein und die Basis
	 * muss größer als 1 sein, ansonsten wird null zurück geliefert.
	 * Beispiel: decToNum(118,2) ergibt 1110110
	 * decToNum(61898,8) ergibt 170712
	 * @param dec die umzuwandelnde Dezimalzahl
	 * @param basis nach welcher umgewandelt wird
	 * @return die umgewandelte Zahl
	 */
	public static String decToNum(int dec, int basis) {
		String ret = null;
		if (dec >= 0 && basis > 1) {
			ret = "";
			while (dec > 0) {
				int modulo = dec % basis;
				dec = dec / basis;
				ret = ret + modulo;
			}
			ret = MeinStringAnalysierer.umdrehenString(ret);
		}
		return ret;
	}
	
	/**
	 * Wandelt die Zahl hex von Hexadezimalsystem in eine Dezimalzahl um und liefert
	 * diese zurück. Falls die übergebene Zahl hex gleich null oder deren Länge gleich
	 * 0 ist, wird -1 zurück geliefert. 
	 * Beispiel: hexToDec("A") ergibt 10
	 * hexToDec("FF") ergibt 255
	 * hexToDec("") ergibt -1
	 * @param hex die umzuwandelnde Zahl als String übergeben
	 * @return das Ergebnis im Dezimalsystem als Integer
	 */
	public static int hexToDec(String hex) {
		int ret = -1;
		if (hex.length() > 0 && hex != null) {
			ret = 0;
			String hexzeichen = "0123456789ABCDEF";
			hex = hex.toUpperCase();
			for (int i = 0; i < hex.length(); i++) {
				int convert = hexzeichen.indexOf(hex.charAt(i));
				ret = 16 * ret + convert;
			}
		}
		return ret;
	}
	/**
	 * Wandelt die Zahl dec vom Dezimalsystem ins Hexadezimalsystem um und liefert
	 * diese zurück. Falls die übergebene Zahl dec gleich 0 ist, wird 0 zurückgeliefert.
	 * Beispiel: decToHex(15) ergibt "F"
	 * decToHex(255) ergibt "FF"
	 * decToHex(0) ergibt "0"
	 * @param dec die umzuwandelnde Zahl als Integer übergeben
	 * @return das Ergebnis im Hexadezimalsystem als String
	 */
	public static String decToHex(int dec) {
		String ret = "0";
		if (dec > 0) {
			ret = "";
			String hexzeichen = "0123456789ABCDEF";
			int stelle = 0;
			while (dec > 0) {
				stelle = dec % 16;
				ret = ret + hexzeichen.charAt(stelle);
				dec = dec / 16;
			}
		}
		return ret;
	}
	/**
	 * Wandelt die Zahl dual vom Dualsystem ins Dezimalsystem um und liefert
	 * diese zurück. Falls die übergebene Zahl dual gleich null oder deren Länge gleich
	 * 0 ist, wird -1 zurück geliefert.
	 * Beispiel: dualToDec("1010") ergibt 10
	 * dualToDec(101001) ergibt 41
	 * dualToDec() ergibt -1
	 * @param dec die umzuwandelnde Dual-Zahl als String übergeben
	 * @return das Ergebnis im Dezimalsystem als Integer
	 */
	public static int dualToDec(String dual) {
		int ret = -1; 
		if (dual.length() > 0 && dual != null) {
			ret = 0;
			int exponent = 0;
			for (int index = dual.length()-1; index >= 0; index--) {
				ret = ret + (getDigit(dual.charAt(index)) * (int)Math.pow(2, exponent));
				exponent++;
			}
		}
		return ret;
	}
	/**
	 * Wandelt die Zahl dec vom Dezimalsystem ins Dualsystem um und liefert
	 * diese zurück. Falls die übergebene Zahl dec gleich 0 ist, wird 0 zurückgeliefert.
	 * Beispiel: decToDual(15) ergibt "1111"
	 * decToDual(255) ergibt "11111111"
	 * decToDual(0) ergibt "0"
	 * @param dec die umzuwandelnde Zahl als Integer übergeben
	 * @return das Ergebnis im Dualsystem als String
	 */
	public static String decToDual(int dec) {
		String ret = "0";
		if (dec > 0) {
			ret = "";
			while (dec > 0) {
				int modulo = dec % 2;
				dec = dec / 2;
				ret = ret + modulo;
			}
		}
		ret = MeinStringAnalysierer.umdrehenString(ret);
		return ret;
	}
	/**
	 * Wandelt die Zahl num von einem beliebigen Zahlensystem in ein anderes beliebiges Zahlensystem um 
	 * und liefert diese zurück. Falls die übergebene Zahl num gleich null ist, deren Länge gleich
	 * 0 ist, basis1 kleiner oder geleich 1 ist oder falls basis2 kleiner oder gleich 1 ist,
	 * so wird "null" zurück geliefert.
	 * Beispiel: numToNum("15", 10, 16) ergibt "F"
	 * numToNumToDual("377", 8, 10) ergibt "255"
	 * numToNum("520", 1, 8) ergibt "null"
	 * @param num die umzuwandelnde Zahl wird als String übergeben
	 * @param basis1 die Basis des Zahlensystems, aus welchem die Zahl num stammt, als Integer übergeben
	 * @param basis2 die Basis des Zahlensystems, in welches die Zahl num konvertiert werden soll, als Integer
	 * @return das Ergebnis im Ziel-Zahlensystem als String
	 */
	public static String numToNum(String num, int basis1, int basis2) {
		String ret= "null";
		if (num.length() >= 0 && num != null && basis1 > 1 && basis2 > 1) {
			ret = "";
			int dec = 0;
			if (basis1 >= 2 && basis1 <= 10) {
				dec = numToDec(num, basis1);
				if (basis2 >= 2 && basis2 <= 10) {
					ret = decToNum(dec, basis2);
				}
				if (basis2 == 16) {
					ret = decToHex(dec);
				}
				
			}
			if (basis1 == 16) {
				dec = hexToDec(num);
				if (basis2 >= 2 && basis2 <= 10) {
					ret = decToNum(dec, basis2);
				}
				if (basis2 == 16) {
					ret = decToHex(dec);
				}
			}
			
		}
		return ret;
	}
	 
}