public class Kartentrick {
	
	/**
	 * Hauptprogramm des Kartentricks
	 * @param args
	 */
	public static void main(String[] args) {
		//Ausgabe Überschrift
		System.out.println("Kartentrick");
		System.out.println("===========");
		do {
			int[][]karten = null;
			karten = fuellen(karten, 0);
			ausgeben(karten);
			int spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			karten = fuellen(karten, spalte);
			ausgeben(karten);
			spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			karten = fuellen(karten, spalte);
			ausgeben(karten);
			spalte = TestScannerErweitert.readInt("Spalte der Karte: ");
			karten = fuellen(karten, spalte);
			ausgeben(karten);
			System.out.println("Karte " + karten[3][1] +" wurde gewählt");
		//Wird wiederholt, wenn der Benutzer das so will
		} while (Character.toLowerCase(TestScannerErweitert.readChar("Nochmals (j/n)? ")) == 'j');

	}
	/**
	 * Erzeugt ein zweidimensionales Array, welches die Zahlen 1 - 21 enthält und so die Karten "simuliert".
	 * Das zurückgegebene Array besteht aus 7 Elementen, welche wiederum ein Array mit drei Elementen beinhalten
	 * @param karten, ein zweidimensionales Array mit Karten in einer bestimmten Reihenfolge
	 * @param spalte, in welcher sich die gesuchte Karte befindet
	 * @return ein zweidimensionale Array, welches aufgefüllt wurde
	 */
	public static int [][] fuellen(int [][] karten, int spalte ) {
		//Rüchgabevariable
		int [][] ret = null;
		//Für die erste Ausgabe
		if (spalte == 0) {
			ret = new int [7][3];
			//Auffüllen des zweidimensionalen Arrays
			for (int i = 0; i < ret.length; i++) {
				for (int j = 0; j < ret[i].length; j++) {
					if (j == 0) {
						ret[i][j] = i + 1;
					}
					if (j == 1) {
						ret[i][j] = i + 8;
					}
					if (j == 2) {
						ret[i][j] = i + 15;
					}
				}
			}
		}
		//Ansonsten
		else {
			//Rückgabevariable
			ret = new int [7][3];
			//helparray
			int [] helparray = new int [3];
			/*
			 * Je nach eingegebener Spalte wird hier die Reihenfolge der Spalten festgelegt, welche
			 * dann in dem unteren Schleifenblock gebraucht wird
			 */
			switch (spalte) {
				case 1: {
					helparray[0] = 2;
					helparray[1] = 0;
					helparray[2] = 1;
					break;
				}
				case 2: {
					helparray[0] = 0;
					helparray[1] = 1;
					helparray[2] = 2;
					break;
				}
				case 3: {
					helparray[0] = 1;
					helparray[1] = 2;
					helparray[2] = 0;
					break;
				}
			}
			//Laufvariablen zum reihenweißen Füllen des Ret-Arrays
			int k = 0;
			int l = 0;
			//Das helparray wird durchgangen mit der festgelegten Reihenfolge der Spalten
			for (int i = 0; i < helparray.length; i++) {
				//Geht durch Karten
				for (int j = 0; j < karten.length; j++) {
					//In die Rückgabevariable wird der Wert der Spalte im Kartenarray geschrieben
					ret[k][l] = karten[j][helparray[i]];
					//Wenn variable gleich 2 ist, wird in die nächste Zeile gegangen
					if (l == 2) {
						l = 0;
						k++;
					}
					else {
						l++;
					}
					
				}
			}
			
			
		}
		//Rückgabe
		return ret;
	}
	/**
	 * Gibt ein zweidimensionales Array aus. Dabei wird darauf geachtet, dass das Array geordnet ausgegeben wird,
	 * also dass z.B. bei Zahlen, welche kleiner als 10 sind erst 2 Leerzeichen ausgegeben werden, sodass alles
	 * schön lingsbündig ausgegeben wird
	 * @param karten, das auszugebende zweidimensionale Array
	 */
	public static void ausgeben(int [][] karten) {
		for (int i = 0; i < karten.length; i++) {
			for (int j = 0; j < karten[i].length; j++) {
				//Wenn Zahl kleiner 10, dann werden 2 Leerzeichen mit ausgegeben
				if (karten[i][j] < 10) {
					System.out.print("  "+karten[i][j]);
				}
				//Ansonsten nur 1 Leerzeichen
				else {
					System.out.print(" "+karten[i][j]);
				}
			}
			//Absatz
			System.out.println();
		}
	}

}
