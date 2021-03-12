
public class DreieckEigenschaften
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Eigenschaften eines Dreiecks");
		System.out.println("============================");
		int ende = 0;
		//Solange ende kleiner 1 ist wird das Programm immer wieder wiederholt
		while (ende < 1) {
			//Benutzereingaben von Seite a, Seite b, und Seite c
			int seitea = TestScanner.readInt("Seite a: ");
			int seiteb = TestScanner.readInt("Seite b: ");
			int seitec = TestScanner.readInt("Seite c: ");
			//Wenn die Summe zweier Seite kleiner als eine Seite ist, so handelt es sich um ein unmögliches Dreieck
			if (seitea + seiteb < seitec || seitea + seitec < seiteb || seiteb + seitec < seitea) {
				System.out.println("Unmögliches Dreieck");
			}
			else {
				//Ansonsten wird der Umfang und die Fläche des Dreiecks berechnet
				System.out.println();
				int umfang = seitea + seiteb + seitec;
				System.out.println("Umfang: "+umfang);
				double s = (seitea + seiteb + seitec) /2 ;
				double flaeche = Math.sqrt(s*(s-seitea)*(s-seiteb)*(s-seitec));
				System.out.println("Fläche: "+(double)flaeche);
				//Wenn alle 3 Seiten gleich lang sind, so handelt es sich um ein Gleichseitiges Dreieck
				if (seitea == seiteb && seitea== seitec) {
					System.out.println("Gleichseitiges Dreieck");
				}
				//Wenn 2 Seiten gleich sind, so handelt es sich im ein Gleischenkeliges Drieeck
				if (seitea == seiteb && seitea != seitec || seitea == seitec && seitea != seiteb 
						|| seiteb == seitec && seitec != seitea) {
					System.out.println("Gleichschenkeliges Dreieck");
				}
				//Wenn a^2+b^2=c2 gilt, dann handelt es sich um ein rechtwinkeliges/pythagoreisches Dreieck
				if ((boolean)(Math.pow(seitea, 2) + Math.pow(seiteb, 2) == Math.pow(seitec, 2)) || 
						(Math.pow(seitea, 2) + Math.pow(seitec, 2) == Math.pow(seiteb, 2)) ||
						(Math.pow(seiteb, 2) + Math.pow(seitec, 2) == Math.pow(seitea, 2))) {
					System.out.println("Pythagoreisches Dreieck");
					//Es wird die längste Seite des Pythagoreischen Dreiecks (Hypothenuse) gesucht und ausgegeben.
					if (seitea > seiteb && seitea > seitec) {
						System.out.println("Hypothenuse: "+(double)seitea);
					}
					if (seiteb > seitea && seiteb > seitec) {
						System.out.println("Hypothenuse: "+(double)seiteb);
					}
					if (seitec > seitea && seitec > seiteb) {
						System.out.println("Hypothenuse: "+(double)seitec);
					}
				}
			}
			//Benutzereingabe ob das Programm wiederholt oder beendet werden soll
			System.out.println();
			int beenden = TestScanner.readInt("Nochmal (0), Beenden (1): ");
			//Wenn der Benutzer "Beenden" wählt, wird ende um 1 erhöht und so die Haptschleife aubgebrochen 
			if (beenden == 1) {
				ende++;
			}
		}

	}

}
