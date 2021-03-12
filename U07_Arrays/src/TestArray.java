
public class TestArray {
	
	/**
	 * Main-Methode mit Methodenaufrufe und Ausgaben
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a = randomIntArray(11, 1, 20);
		printIntArray("a = ", a);
		printIntArray("", randomIntArray(50, -1, 1));
		System.out.println("Minimum: "+getMinimum(a));
		System.out.println("Maximum: "+getMaximum(a));
		System.out.println("Mittelwert: "+getMittelwert(a));
		System.out.println("IndexOf: "+indexOf(a, 20));
		System.out.println("IndexOf: "+indexOf(a, 20, 5));
		System.out.println("getMinPos: "+getMinPos(a, 5));
		addZahl(a, 100);
		printIntArray("a + 100 = ", a);
		swap(a, 0, 2);
		printIntArray("swap --> ", a);
		a = randomIntArray(50, 1, 100000);
		printIntArray("Nicht sortiert -> ", a);
		sortMinArray(a);
		printIntArray("Sortiert -> ", a);
		int [] b = {1, 3, 3, 1, 2, 1, 5};
		printIntArray("b =", b);
		printIntArray("",delDoppelte(b));
		 
	}
	
	/**
	 * Hier erfolgt die Ausgabe es zufällig ermittelten Int-Array in der Java-Notation. Alternativ
	 * kann vor der Ausgabe des Int-Arrays auch ein Text ausgegeben werden, welcher übermittelt werden muss.
	 * Beispiel: printIntArray("a = ", a); ergibt a = {0, -1, 20, 0, 10}
	 * @param msg, Text, welcher vor der Ausgabe des Int-Arrays ausgegeben wird
	 * @param a, das auszugebene Int-Array
	 */
	public static void printIntArray(String msg, int[] a) {
		System.out.print(msg);
		System.out.print("{");
		//Einzelne Ausgabe der einzelnen Elemente des Int-Arrays mit komma
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("}\n");
	}
	
	/**
	 * Erstellt ein Int-Array mit der Länge anzahl und füllt dieses mit zufälligen Zahl im Bereich von -> bis.
	 * @param anzahl, Anzahl der Elemente, die das Int-Array beinhalten soll
	 * @param von, Minimum des Zufallsbereichs
	 * @param bis, Maximum des Zufallsbereichs
	 * @return Rückgabe des Int-Arrays mit zufälligen Zahlen
	 */
	public static int[] randomIntArray(int anzahl, int von, int bis) {
		int [] ret = new int[anzahl];
		von--;
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int)(Math.random()*(bis-von+1)+von);
		}
		return ret;
	}
	
	/**
	 * Ermittelt die kleinste Zahl des Int-Arrays und gibt diese anschließend zurück.
	 * Beispiel: {19, -5, 3, 17, 9} ergibt -5
	 * @param a, das zu untersuchende Int-Array
	 * @return die kleinste Zahl im Array, als Integer
	 */
	public static int getMinimum(int[] a) {
		int ret = 0;
		//Ermittelt Summe
		for (int i = 0; i < a.length; i++) {
			ret = ret + a[i];
		}
		//Ermittelt die kleinste Zahl und speichert diese in ret
		for (int i = 0; i < a.length; i++) {
			if (a[i] < ret) {
				ret = a [i];
			}
		}
		//Rückgabe
		return ret;
	}
	
	/**
	 * Ermittelt die größte Zahl des Int-Arrays und gibt diese anschließend zurück.
	 * Beispiel: {-2, 14, 9, 10, 12} ergibt 14
	 * @param a, das zu untersuchende Int-Array
	 * @return die kleinste Zahl im Array, als Integer
	 */
	public static int getMaximum(int[] a) {
		int ret = 0;
		for (int i = 0; i < a.length; i++) {
			ret = ret - a[i];
		}
		//Ermittelt die kleinste Zahl und speichert diese in ret
		for (int i = 0; i < a.length; i++) {
			if (a[i] > ret) {
				ret = a [i];
			}
		}
		//Rückgabe
		return ret;
	}
	/**
	 * Ermittelt den Mittelwert der Zahlen, die sich im Integer-Array befinden.
	 * Beispiel: {-5, 12, 1, 20, -5} ergibt 4.6
	 * @param a, das zu untersuchende Int-Array
	 * @return der Mittelwert, als Double
	 */
	public static double getMittelwert(int[] a) {
		double ret = 0.000;
		//Ermittelt Summe
		for (int i = 0; i < a.length; i++) {
			ret = ret + a[i];
		}
		//Dividiert durch die Länge des Arrays
		ret = ret / a.length;
		return ret;
	}
	/**
	 * Ermittelt die Position der Zahl z im int-Array a. Dabei wird die Position ermittelt, an welcher die Zahl 
	 * zum ersten mal vorkommt. Sonderfall: wird die Zahl im Int-Array nicht gefunden, so wird -1 zurück geliefert.
	 * Beispiel: {4, 12, 6, 17, -3, 16, 11, 20, 0, 5, 2, 20} (20 wird gesucht) ergibt 7
	 * @param a, das zu untersuchende Int-Array
	 * @param z, die zu suchende Zahl
	 * @return die erste Position der Zahl z im Int-Array a, als Integer
	 */
	public static int indexOf(int [] a, int z) {
		int ret = -1;
		for (int i = 0; i < a.length; i++) {
			//Sucht die Zahl
			if (z == a[i]) {
				ret = i;
				/*
				 * Bei Fund: Schleifenabbruch, damit die Position ausgegeben wird, an welcher die Zahl zum 
				 * ersten Mal vorkommt
				 */
				i = a.length;
			}
		}
		//Rückgabe
		return ret;
	}
	/**
	 * Ermittelt die Position im Int-Array a der Zahl z. Dabei wird an der Position pos angefangen zu suchen.
	 * Wird die Zahl ab der eingegebenen Position nicht gefunden, so wird -1 zurückgeliefert.
	 * Beispiel: {20, 14, 4, -4, -4, 1, 20, 5, 20, -3} (20 ab Position 5 wird gesucht) ergibt 6
	 * @param a, das zu untersuchende Int-Array
	 * @param z, die zu suchende Zahl
	 * @param pos, die Position, ab welcher nach der Zahl z im Int-Array gesucht wird
	 * @return die Position der Zahl z im Int-Array ab Position pos
	 */
	public static int indexOf(int [] a, int z, int pos) {
		int ret = -1;
		//Suche startet ab pos
		for (int i = pos; i < a.length; i++) {
			//Sucht die Zahl
			if (z == a[i]) {
				ret = i;
				/*
				 * Bei Fund: Schleifenabbruch, damit die Position ausgegeben wird, an welcher die Zahl zum 
				 * ersten Mal vorkommt
				 */
				i = a.length;
			}
		}
		//Rückgabe
		return ret;
	}
	
	/**
	 * Ermittelt die Position des Minimums im Int-Array ab der übergebenen Position pos.
	 * Beispiel: {3, 2, 9, 5, 2} (das Minimum ab Position 2 wird gesucht) ergibt 4
	 * @param a, das zu untersuchende Int-Array.
	 * @param pos, die Position, ab welcher nach dem Minimum im Int-Array gesucht wird
	 * @return die Position des Minimums im Int-Array ab der Position pos
	 */
	public static int getMinPos(int [] a, int pos) {
		int ret = 0;
		int num = 0;
		for (int i = pos; i < a.length; i++) {
			num = num + a[i];
		}
		//Ermittelt die kleinste Zahl und speichert diese in ret
		for (int i = pos; i < a.length; i++) {
			if (a[i] < num) {
				num = a [i];
			}
		}
		ret = indexOf(a, num, pos);
		return ret;
	}
	/**
	 * Addiert die Zahl z zu jedem Element des Int-Arrays a hinzu.
	 * Beispiel: {1, 8, 8, 9, 0, 4, 0, 0, 6, 4} (z = 100) ergibt {101, 108, 108, 109, 100, 104, 100, 100, 106, 104}
	 * @param a, das zu untersuchende Int-Array
	 * @param z, die zu addierende Zahl
	 */
	public static void addZahl(int [] a, int z) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] + z;
		}
	}
	/**
	 * Vertuascht das Element des Int-Arrays a an der Stelle i mit dem Element des Int-Arrays a an der Stelle j.
	 * Beispiel: {110, 105, 108} (i = 0; j = 2) ergibt {108, 105, 110}
	 * @param a, das zu untersuchende Int-Array
	 * @param i, Stelle im Int-Array
	 * @param j, Stelle im Int-Array
	 */
	public static void swap (int [] a, int i, int j) {
		int help = a[i];
		a[i] = a [j];
		a[j] = help;
	}
	/**
	 * Sortiert das Array der Größe nach. Es wird zunächst das gesamte Array auf das Minimum durchsucht und 
	 * dieses mit dem Element an der ersten Stelle im Array vertauscht. Dann wird ab dem zweiten Element das
	 * Array nach dem Minimum durchsucht und mit der zweiten Stelle im Array vertauscht usw.
	 * @param a, das zu ordnende Array
	 */
	public static void sortMinArray(int[]a) {
		for (int i = 0; i < a.length; i++) {
			int pos = getMinPos(a, i);
			swap(a, i, pos);
		}
	}
	/**
	 * Durchsucht das Array nach doppelt vorkommenden Zahlen und gibt ein neues, gesäubertes Array zurück,
	 * welches keine doppelten Elemente mehr enthält. Dabei wird das übergebene Array nicht übergeben.
	 * Beispiel: {1, 3, 3, 1, 2, 1, 5} ergibt das Array {1, 3, 2, 5} mit Länge 4
	 * @param a, das zu säubernde Int-Array
	 * @return das gesäuberte Int-Array
	 */
	public static int [] delDoppelte(int [] a) {
		int [] ret = null;
		//Kopiert das übergebene Array
		int [] help = new int [a.length];
		for (int i = 0; i < a.length; i++) {
			help[i] = a[i];
		}
		//Kopiertes Array wird sortiert
		sortMinArray(help);
		printIntArray("sort = ", help);
		//Es wird gezählt wie viele Doppelte vorhanden sind
		int counter = 0;
		for (int i = 0; i < help.length-1; i++) {
			if (help[i] == help[i+1]) {
				counter++;
			}
		}
		//Aus der Differenz zur Länge wird die Länge des Rückgabe-Arrays bestimmt
		ret = new int[help.length-counter];
		int stelle = 0;
		//Sind die Zeichen im sortierten Array nicht gleich, so werden sie ins Rückgabe-Array geschrieben
		for (int i = 0; i < help.length-1; i++) {
			if (help[i] != help[i+1]) {
				ret[stelle] = help[i];
				stelle++;
			}
		}
		//Sollte noch Platz sein, das ist das letzte Element im sortierten Array kein Doppeltes;
		if(stelle < ret.length) {
			ret[stelle] = help[help.length-1];
		}
		/*
		 * Neues Hilfs-Array mit der Länge des Rückgabe-Arrays dient dazu die Indizes der zuvor
		 * bestimmten einzelnen Zahlen (ohne doppelte) zu ermitteln und zu speichern. Dies ist notwendig,
		 * um das zuvor sortierte Array in der ursprünglichen Reihenfolge zurückzugeben.
		 */
		int [] indizes = new int [ret.length];
		//Indizes werden bestimmt und gespeichert
		for (int i = 0; i < indizes.length; i++) {
			indizes[i] = indexOf(a, ret[i]);
		}
		//Die Indizes werden aufsteigen sortiert
		sortMinArray(indizes);
		//Die einzelnen Zahlen werden in der ursprünglichen Reihenfolge zurückgegeben.
		for (int i = 0; i < ret.length; i++) {
			ret [i] = a[indizes[i]];
		}
		return ret;
	}
	

}
