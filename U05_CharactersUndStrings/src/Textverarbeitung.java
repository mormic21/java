/**
 * Rohdatei zur Programmieraufgabe "Textverarbeitung"
 * @author Michael Wild
 */
public class Textverarbeitung
{
	public static void main(String[] args) {
		// Länge auf welche die Zeilen abgeschnitten und auf die Blocksatz 
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
	 * Schneidet den übergebenen String s auf eine Länge von l zurecht
	 * und gibt den abgeschnittenen String zurück. Sollte der String weniger
	 * als l Zeichen lang sein, so wird der String unverändert zurück gegeben.
	 * Die Methode kann nur funktionieren, falls s nicht null und falls
	 * l > 0 ist, ansonsten wird null als Ergebnis zurück geliefert
	 * @param s der abzuschneidende String
	 * @param l Laenge die der zurückzuliefernde String haben soll
	 * @return der auf die Länge l gekürzte String oder null falls s gleich null 
	 * oder l <= 0 ist
	 */
	public static String abschneiden(String s, int l) {
		//Wurde nichts übergeben, wird nichts zurück gegeben
		String ret = s;
		if (ret.equals(null) || l <= 0) {
			ret = null;
		}
		else {
			//Wenn die l größer als die Länge des Strings ist, so wird derselbe String wieder zurück gegeben
			if (l > ret.length()) {
				ret = s;
			}
			else {
				/*
				 * Ansonsten wird der eingegebene String auf die vorgegebene Länge gekürzt und in den
				 * Rückgabestring geschrieben
				 */
				String neutext = "";
				for (int i = 0; i < l; i++) {
					neutext = neutext + ret.charAt(i);
				}
				ret = neutext;
			}
			
		}
		//Rückgabe der Methode
		return ret;
	}
	
	/**
	 * Entfernt vom übergebenen String s alle überflüssigen Leerzeichen, die 
	 * nicht nur am Beginn und am Ende sondern auch zwischen den Worten im
	 * String vorhanden sein können. Falls für s null übergeben wird, dann 
	 * liefert die Methode null zurück
	 * @param s String der die zu entfernen Leerzeichen enthält
	 * @return den String, der weder am Anfang noch am Ende Leerzeichen
	 * enthält und der auch zwischen den Worten nur jeweils ein Leerzeichen
	 * enthält. Insbesondere liefert die Methode null zurück, falls ihr null
	 * übergeben wurde
	 */
	public static String leerzeichenEntfernen(String s) {
		//Wird nichts übergeben, so wird null zurück gegeben
		String ret = s;
		if (ret.equals(null)) {
			ret = null;
		}
		else {
			String text = s;
			//Leerzeichen vor und nach dem text im String werden gelöscht
			text = text.trim();
			ret = "";
			int leerzeichen = 0;
			//Löschen von Leerzeichen zwischen Wörtern
			for (int i = 0; i < text.length(); i++) {
				//Zählt die Leerzeichen
				if (Character.isWhitespace(text.charAt(i))) {
					leerzeichen++;
				}
				//Sollte man auf kein Leerzeichen treffen, so wird der Zähler gleich wieder auf 0 gesetzt
				if (!Character.isWhitespace(text.charAt(i))) {
					leerzeichen = 0;
				}
				/*
				 * Wenn der Leerzeichenzähler nicht größer gleich 2 ist, wird das aktuell untersuchte
				 * Zeichen im String in den Rückgabestring gespeichert.
				 */
				if (!(leerzeichen >= 2)) {
					ret = ret + text.charAt(i);
				}
			}
		}
		//Rückgabe des Rückgabestrings
		return ret;
	}
	
	/**
	 * Stellt auf den übergebenen String s einen Blocksatz der Länge l ein.
	 * Sollte der String s gleich null oder länger als l Zeichen sein oder
	 * sollte der String keine Leerzeichen enthalten über die der Blocksatz
	 * gebildet werden kann, so wird null als Ergebnis geliefert. Der Blocksatz 
	 * wird so gebildet, dass die fehlenden Leerzeichen bis zu Länge l 
	 * gleichmäßig auf die bereits vorhandenen Leerzeichen aufgeteilt werden. 
	 * Bevor der Blocksatz eingestellt wird, werden beim vorhandenen String alle 
	 * unnötigen Leerzeichen weggestrichen
	 * @param s String auf den der Blocksatz eingestellt werden soll
	 * @param l die Länge des Blocksatzes
	 * @return den String, auf den der Blocksatz eingestellt wurde
	 */
	public static String blocksatz(String s, int l) {
		String ret = null;
		//Ist der String kleiner als ein Zeichen lang sein, so wird null zurückgegeben
		if (s.length() < 1) {
			ret = null;
		}
		//Die vorhandenden Leerzeichen werden gezählt
		int space = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				space++;
			}
		}
		//Wenn keine Leerzeichen vorhanden sind wird null zurückgegeben
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
					//Einfügen eines Leerzeichens
					if (j <= space){
						s2 = s2 + " ";
						j++;
					}
					//Nach Leerzeichen wird wieder ein Teil des Strings hinzugeführt
					s = s2 + s.substring(i+1);
					//Fortschaltung bei if
					i++;
				}
				/*
				 * Wurde das String-Ende erreicht, aber die gewünschte Länge noch nicht,
				 * so wird wieder zum Anfang des Strings gegangen.
				 */
				if (i == s.length()-1 && j <= space) {
					i = 0;
				}
				//Fortschaltung bei else
				i++;
			}
			//Rückgabevariable soll s sein
			ret = s;
		}
		//Rückgabe
		return ret;
	}

	public static String readString(String text) {
    System.out.print(text);
    return (new java.util.Scanner(System.in).nextLine());
  }
}