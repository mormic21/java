/**
 * Testprogramm für die Klasse MeinZahlensystemwandler
 * @author Michael Morandell
 *
 */
public class TestZahlensystemwandler {

	public static void main(String[] args) {
		System.out.println("getDigit(char)");
		System.out.println("==============");
		System.out.println("getDigit(\'0\')ergibt " +
				MeinZahlensystemwandler.getDigit('0'));
		System.out.println("getDigit(\'1\') ergibt " +
				MeinZahlensystemwandler.getDigit('1'));
		System.out.println("getDigit(\'6\') ergibt " +
				MeinZahlensystemwandler.getDigit('6'));
		System.out.println("getDigit(\'A\') ergibt " +
				MeinZahlensystemwandler.getDigit('A'));
		System.out.println("getDigit(\'b\') ergibt " +
				MeinZahlensystemwandler.getDigit('b'));
		System.out.println("getDigit(\'Z\') ergibt " +
				MeinZahlensystemwandler.getDigit('Z'));
		System.out.println("getDigit(\'*\') ergibt " +
				MeinZahlensystemwandler.getDigit('*'));		
		System.out.println();
		System.out.println("getDigit(int)");
		System.out.println("==============");
		System.out.println("getDigit(0)ergibt " +
				MeinZahlensystemwandler.getDigit(0));
		System.out.println("getDigit(1) ergibt " +
				MeinZahlensystemwandler.getDigit(1));
		System.out.println("getDigit(6) ergibt " +
				MeinZahlensystemwandler.getDigit(6));
		System.out.println("getDigit(10) ergibt " +
				MeinZahlensystemwandler.getDigit(10));
		System.out.println("getDigit(11) ergibt " +
				MeinZahlensystemwandler.getDigit(11));
		System.out.println("getDigit(35) ergibt " +
				MeinZahlensystemwandler.getDigit(35));
		System.out.println("getDigit(36) ergibt " +
				MeinZahlensystemwandler.getDigit(36));	
		System.out.println("getDigit(-1) ergibt " +
				MeinZahlensystemwandler.getDigit(-1));		
		System.out.println();
		System.out.println("numToDec(String, int)");
		System.out.println("=====================");
		System.out.println("numToDec(\"01110110\", 2) ergibt " +
				MeinZahlensystemwandler.numToDec("01110110", 2));
		System.out.println("numToDec(\"170712\", 8) ergibt " +
				MeinZahlensystemwandler.numToDec("170712", 8));
		System.out.println("numToDec(\"170712\", 7) ergibt " +
				MeinZahlensystemwandler.numToDec("170712", 7));
		System.out.println("numToDec(\"170712\", 1) ergibt " +
				MeinZahlensystemwandler.numToDec("170712", 1));
		System.out.println();
		System.out.println("decToNum(int, int)");
		System.out.println("=====================");
		System.out.println("decToNum(118,2) ergibt " +
				MeinZahlensystemwandler.decToNum(118,2));
		System.out.println("decToNum(61898,8) ergibt " +
				MeinZahlensystemwandler.decToNum(61898,8));
		System.out.println("decToNum(118,1) ergibt " +
				MeinZahlensystemwandler.decToNum(118,1));
		System.out.println("decToNum(-5,2) ergibt " +
				MeinZahlensystemwandler.decToNum(-5,2));
		System.out.println();
		System.out.println("hexToDec(String)");
		System.out.println("=====================");
		System.out.println("hexToDec(A) ergibt " +
				MeinZahlensystemwandler.hexToDec("A"));
		System.out.println("hexToDec(FF) ergibt " +
				MeinZahlensystemwandler.hexToDec("FF"));
		System.out.println("hexToDec(b) ergibt " +
				MeinZahlensystemwandler.hexToDec("b"));
		System.out.println("hexToDec() ergibt " +
				MeinZahlensystemwandler.hexToDec(""));
		System.out.println();
		System.out.println("decToHex(int)");
		System.out.println("=====================");
		System.out.println("decToHex(15) ergibt " +
				MeinZahlensystemwandler.decToHex(15));
		System.out.println("decToHex(255) ergibt " +
				MeinZahlensystemwandler.decToHex(255));
		System.out.println("decToHex(3180) ergibt " +
				MeinZahlensystemwandler.decToHex(3180));
		System.out.println("decToHex(0) ergibt " +
				MeinZahlensystemwandler.decToHex(0));
		System.out.println();
		System.out.println("dualToDec(String)");
		System.out.println("=====================");
		System.out.println("dualToDec(1010) ergibt " +
				MeinZahlensystemwandler.dualToDec("1010"));
		System.out.println("dualToDec(101001) ergibt " +
				MeinZahlensystemwandler.dualToDec("101001"));
		System.out.println("dualToDec(101000) ergibt " +
				MeinZahlensystemwandler.dualToDec("101000"));
		System.out.println("dualToDec() ergibt " +
				MeinZahlensystemwandler.dualToDec(""));
		System.out.println();
		System.out.println("decToDual(int)");
		System.out.println("=====================");
		System.out.println("decToDual(15) ergibt " +
				MeinZahlensystemwandler.decToDual(15));
		System.out.println("decToDual(255) ergibt " +
				MeinZahlensystemwandler.decToDual(255));
		System.out.println("decToDual(36) ergibt " +
				MeinZahlensystemwandler.decToDual(36));
		System.out.println("decToDual(0) ergibt " +
				MeinZahlensystemwandler.decToDual(0));
		System.out.println();
		System.out.println("numToNum(String, int, int)");
		System.out.println("=====================");
		System.out.println("numToNum(\"15\", 10, 16) ergibt " +
				MeinZahlensystemwandler.numToNum("15", 10, 16));
		System.out.println("numToNum(\"377\", 8, 10) ergibt " +
				MeinZahlensystemwandler.numToNum("377", 8, 10));
		System.out.println("numToNum(\"520\", 8, 2) ergibt " +
				MeinZahlensystemwandler.numToNum("520", 8, 2));
		System.out.println("numToNum(\"520\", 1, 8) ergibt " +
				MeinZahlensystemwandler.numToNum("520", 1, 8));
	
	}

}
