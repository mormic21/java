/**
 * Rohdatei zur Programmieraufgabe "Textverarbeitung"
 * @author Michael Wild
 */
public class Textverarbeitung
{
	public static void main(String[] args) {
		// L�nge auf welche die Zeilen abgeschnitten und auf die Blocksatz 
		// eingestellt wird
		final int LAENGE = 30;
		System.out.println("Textverarbeitung");
		System.out.println("================");
		String s1 = readString("1. Zeile: ");
		String s2 = readString("2. Zeile: ");
		String s3 = readString("3. Zeile: ");
		String s4 = readString("4. Zeile: ");
		
		// Ermittlung der abgeschnittenen Zeilen
		s1 = abschneiden(s1,LAENGE);
		s2 = abschneiden(s2,LAENGE);
		s3 = abschneiden(s3,LAENGE);
		s4 = abschneiden(s4,LAENGE);
		System.out.println(">>Abschneiden");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		// Entfernen der Leerzeichen pro Zeile
		s1 = leerzeichenEntfernen(s1);
		s2 = leerzeichenEntfernen(s2);
		s3 = leerzeichenEntfernen(s3);
		s4 = leerzeichenEntfernen(s4);
		System.out.println(">>Leerzeichen entfernen");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		// Einstellen des Blocksates
		System.out.println(">>Blocksatz");
		s1 = blocksatz(s1,LAENGE);
		s2 = blocksatz(s2,LAENGE);
		s3 = blocksatz(s3,LAENGE);
		s4 = blocksatz(s4,LAENGE);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

	/**
	 * Schneidet den �bergebenen String s auf eine L�nge von l zurecht
	 * und gibt den abgeschnittenen String zur�ck. Sollte der String weniger
	 * als l Zeichen lang sein, so wird der String unver�ndert zur�ck gegeben.
	 * Die Methode kann nur funktionieren, falls s nicht null und falls
	 * l > 0 ist, ansonsten wird null als Ergebnis zur�ck geliefert
	 * @param s der abzuschneidende String
	 * @param l Laenge die der zur�ckzuliefernde String haben soll
	 * @return der auf die L�nge l gek�rzte String oder null falls s gleich null 
	 * oder l <= 0 ist
	 */
	public static String abschneiden(String s, int l) {
		//Wurde nichts �bergeben, wird nichts zur�ck gegeben
		String ret = s;
		if (ret.equals(null) || l <= 0) {
			ret = null;
		}
		else {
			//Wenn die l gr��er als die L�nge des Strings ist, so wird derselbe String wieder zur�ck gegeben
			if (l > ret.length()) {
				ret = s;
			}
			else {
				/*
				 * Ansonsten wird der eingegebene String auf die vorgegebene L�nge gek�rzt und in den
				 * R�ckgabestring geschrieben
				 */
				String neutext = "";
				for (int i = 0; i < l; i++) {
					neutext = neutext + ret.charAt(i);
				}
				ret = neutext;
			}
			
		}
		//R�ckgabe der Methode
		return ret;
	}
	
	/**
	 * Entfernt vom �bergebenen String s alle �berfl�ssigen Leerzeichen, die 
	 * nicht nur am Beginn und am Ende sondern auch zwischen den Worten im
	 * String vorhanden sein k�nnen. Falls f�r s null �bergeben wird, dann 
	 * liefert die Methode null zur�ck
	 * @param s String der die zu entfernen Leerzeichen enth�lt
	 * @return den String, der weder am Anfang noch am Ende Leerzeichen
	 * enth�lt und der auch zwischen den Worten nur jeweils ein Leerzeichen
	 * enth�lt. Insbesondere liefert die Methode null zur�ck, falls ihr null
	 * �bergeben wurde
	 */
	public static String leerzeichenEntfernen(String s) {
		//Wird nichts �bergeben, so wird null zur�ck gegeben
		String ret = s;
		if (ret.equals(null)) {
			ret = null;
		}
		else {
			String text = s;
			//Leerzeichen vor und nach dem text im String werden gel�scht
			text = text.trim();
			ret = "";
			int leerzeichen = 0;
			//L�schen von Leerzeichen zwischen W�rtern
			for (int i = 0; i < text.length(); i++) {
				//Z�hlt die Leerzeichen
				if (Character.isWhitespace(text.charAt(i))) {
					leerzeichen++;
				}
				//Sollte man auf kein Leerzeichen treffen, so wird der Z�hler gleich wieder auf 0 gesetzt
				if (!Character.isWhitespace(text.charAt(i))) {
					leerzeichen = 0;
				}
				/*
				 * Wenn der Leerzeichenz�hler nicht gr��er gleich 2 ist, wird das aktuell untersuchte
				 * Zeichen im String in den R�ckgabestring gespeichert.
				 */
				if (!(leerzeichen >= 2)) {
					ret = ret + text.charAt(i);
				}
			}
		}
		//R�ckgabe des R�ckgabestrings
		return ret;
	}
	
	/**
	 * Stellt auf den �bergebenen String s einen Blocksatz der L�nge l ein.
	 * Sollte der String s gleich null oder l�nger als l Zeichen sein oder
	 * sollte der String keine Leerzeichen enthalten �ber die der Blocksatz
	 * gebildet werden kann, so wird null als Ergebnis geliefert. Der Blocksatz 
	 * wird so gebildet, dass die fehlenden Leerzeichen bis zu L�nge l 
	 * gleichm��ig auf die bereits vorhandenen Leerzeichen aufgeteilt werden. 
	 * Bevor der Blocksatz eingestellt wird, werden beim vorhandenen String alle 
	 * unn�tigen Leerzeichen weggestrichen
	 * @param s String auf den der Blocksatz eingestellt werden soll
	 * @param l die L�nge des Blocksatzes
	 * @return den String, auf den der Blocksatz eingestellt wurde
	 */
	public static String blocksatz(String s, int l) {
		String ret = null;
		//Ist der String kleiner als ein Zeichen lang sein, so wird null zur�ckgegeben
		if (s.length() < 1) {
			ret = null;
		}
		//Die vorhandenden Leerzeichen werden gez�hlt
		int space = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				space++;
			}
		}
		//Wenn keine Leerzeichen vorhanden sind wird null zur�ckgegeben
		if (space == 0) {
			s = null;
		}
		else {
			space = (l - s.length())+1;
			//Hilfsstring
			String s2 = "";
			int i = 0;
			int j = 0;
			//Solange i kleiner s.length ist
			while (i < s.length()) {
				//Wenn das Zeichen am Index i ein Leerzeichen ist, so wird der String bis dort ausgegeben
				if (Character.isWhitespace(s.charAt(i))) {
					s2 = s.substring(0, i + 1);
					//Einf�gen eines Leerzeichens
					if (j <= space){
						s2 = s2 + " ";
						j++;
					}
					//Nach Leerzeichen wird wieder ein Teil des Strings hinzugef�hrt
					s = s2 + s.substring(i+1);
					//Fortschaltung bei if
					i++;
				}
				/*
				 * Wurde das String-Ende erreicht, aber die gew�nschte L�nge noch nicht,
				 * so wird wieder zum Anfang des Strings gegangen.
				 */
				if (i == s.length()-1 && j <= space) {
					i = 0;
				}
				//Fortschaltung bei else
				i++;
			}
			//R�ckgabevariable soll s sein
			ret = s;
		}
		//R�ckgabe
		return ret;
	}

	public static String readString(String text) {
    System.out.print(text);
    return (new java.util.Scanner(System.in).nextLine());
  }
}