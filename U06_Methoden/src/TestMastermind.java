/**
 * Testprogramm für die Klasse Mastermind
 * @author Michael Morandell
 *
 */
public class TestMastermind {
	/**
	 * Methode zum Testen des Programms Mastermind mit Bildschirmausgaben und 
	 * Methodenaufrufe der Klasse Mastermind
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("erzeugeCode(int, int)");
		System.out.println("=====================");
		System.out.println("erzeugeCode(4, 6) ergibt " +
				Mastermind.erzeugeCode(4,6));
		System.out.println("erzeugeCode(2, 4) ergibt " +
				Mastermind.erzeugeCode(2, 4));
		System.out.println("erzeugeCode(6, 6) ergibt " +
				Mastermind.erzeugeCode(6,6));
		System.out.println("erzeugeCode(26, 26) ergibt " +
				Mastermind.erzeugeCode(26,26));
		System.out.println("erzeugeCode(9, 16) ergibt " +
				Mastermind.erzeugeCode(8, 12));
		System.out.println("erzeugeCode(6, 3) ergibt " +
				Mastermind.erzeugeCode(6, 3));
		System.out.println("erzeugeCode(0, 3) ergibt " +
				Mastermind.erzeugeCode(0, 3));
		System.out.println();
		System.out.println();
		System.out.println("enthaeltDoppelte(String)");
		System.out.println("========================");
		System.out.println("enthaeltDoppelte(\"ACFD\") ergibt " +
				Mastermind.enthaeltDoppelte("ACFD"));
		System.out.println("enthaeltDoppelte(\"ACAD\") ergibt " +
				Mastermind.enthaeltDoppelte("ACAD"));
		System.out.println("enthaeltDoppelte() ergibt " +
				Mastermind.enthaeltDoppelte(""));
		System.out.println("enthaeltDoppelte(\"asdasdf\") ergibt " +
				Mastermind.enthaeltDoppelte("asdasdf"));
		System.out.println("enthaeltDoppelte(\"asdASD\") ergibt " +
				Mastermind.enthaeltDoppelte("asdASD"));
		System.out.println("enthaeltDoppelte(\"asduio\") ergibt " +
				Mastermind.enthaeltDoppelte("asduio"));
		System.out.println("enthaeltDoppelte(\"qweloiuztQ\") ergibt " +
				Mastermind.enthaeltDoppelte("qweloiuztQ"));
		System.out.println();
		System.out.println();
		System.out.println("eingabeTipp(int)");
		System.out.println("================");
		System.out.println("eingabeTipp(5) ergibt ");
		System.out.println(Mastermind.eingabeTipp(5));
		System.out.println("eingabeTipp(4) ergibt ");
		System.out.println(Mastermind.eingabeTipp(4));
		System.out.println("eingabeTipp(10) ergibt ");
		System.out.println(Mastermind.eingabeTipp(10));
		System.out.println();
		System.out.println();
		System.out.println("ermittleSchwarz(String, String)");
		System.out.println("===============================");
		System.out.println("ermittleSchwarz(\"ABCD\",\"BACF\") ergibt " +
				Mastermind.ermittleSchwarz("ABCD","ABCD"));
		System.out.println("ermittleSchwarz(\"ABCD\",\"EFGH\") ergibt " +
				Mastermind.ermittleSchwarz("ABCD","EFGH"));
		System.out.println("ermittleSchwarz(\"ABCDE\",\"BASD\") ergibt " +
				Mastermind.ermittleSchwarz("ABCDE","BASD"));
		System.out.println("ermittleSchwarz(\"ABDE\",\"  \") ergibt " +
				Mastermind.ermittleSchwarz("ABDE","  "));
		System.out.println();
		System.out.println();
		System.out.println("ermittleWeiss(String, String)");
		System.out.println("=============================");
		System.out.println("ermittleWeiss(\"ABCD\",\"BACF\") ergibt " +
				Mastermind.ermittleWeiss("ABCD","BACF"));
		System.out.println("ermittleWeiss(\"ABCDE\",\"BACF\") ergibt " +
				Mastermind.ermittleWeiss("ABCDE","BACF"));
		System.out.println("ermittleWeiss(\"ABCD\",\"EFGH\") ergibt " +
				Mastermind.ermittleWeiss("ABCD","EFGH"));
		System.out.println("ermittleWeiss(\"ABDE\",\"  \") ergibt " +
				Mastermind.ermittleWeiss("ABDE","  "));
		
		
	}

}
