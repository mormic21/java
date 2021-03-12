import java.io.*;

/**
 * Songliste-Klasse, welche die Klasse Song mit ihren Membervariablen und
 * Funktionen dazu nutzt eine csv-datei zu sortieren
 * 
 * @author Michael Morandell
 *
 */
public class Songliste {

	public static void main(String[] args) {
		// Pfad zu Textdateien
		String quelle = "C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\U08_KlassenObjekte\\src\\tracklist.csv";
		String ziel = "C:\\Users\\Michael Morandell\\Documents\\info\\eclipse\\Info\\Work\\Work\\U08_KlassenObjekte\\src\\sortlist.csv";
		// Initialisierung des Counters mit -1, da im nachfolgendem Code die
		// "Titel"-Zeile übersprungen wird, da sie nicht sortierbar ist
		int counter = -1;
		// Zeilenweises Lesen. Dabei wird von der Zählvariable counter gezählt, wieviele
		// Zeilen die Textdatei enthält
		try {
			BufferedReader reader = new BufferedReader(new FileReader(quelle));
			while (true) {
				String zeile = reader.readLine();
				// Dateiende erkannt
				if (zeile == null)
					break;
				// Zeile wird gezählt
				else
					counter++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		String titel = "";
		// Deklaration eines Objekt-Arrays vom Typ Song mit Anzahl der Elemente, die
		// zuvor vom Counter bestimmt wurde
		Song[] liste = new Song[counter];
		// Textdatei wird wieder geöffnet
		try {
			BufferedReader reader = new BufferedReader(new FileReader(quelle));
			// Erste Zeile wird gelesen. Wird später nicht weiterverarbeitet, also
			// übersprungen
			titel = reader.readLine();
			// Das Song-Array wird Element für Element durchgegangen
			for (int i = 0; i < liste.length; i++) {
				// Zeile wird gelesen und in der String-Variable zeile gespeichert
				String zeile = reader.readLine();
				// Dateiende erkannt
				if (zeile == null)
					break;
				// Instanziierung des Song-Objektes an der Stelle i im Array
				liste[i] = new Song();
				/*
				 * Das Song-Objekt erhält den Inhalt der zuvor ausgelesenen Zeile. Dazu wird die
				 * Methode setSong aus der Klasse Song verwendet
				 */
				liste[i].setSong(zeile);
				// Hilfsvariable
				int j = i;
				/*
				 * Solange j größer, als der kleinste Index 0 ist und das Objekt an der Stelle j
				 * kleiner ist, als das Objekt an der Stelle j-1...
				 */
				while (j > 0 && liste[j].compareTo(liste[j - 1]) == -1) {
					// Ein Hilfs-Objekt vom Typ Song
					Song help = new Song();
					// Die beiden Objekte werden im Array vertauscht
					help = liste[j - 1];
					liste[j - 1] = liste[j];
					liste[j] = help;
					// Fortschaltung
					j--;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("Lesefehler in Datei");
		}
		// Zeilenweises Schreiben in eine Datei
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(ziel));
			// Zeilenschaltung am Ende jeder Zeile: \n
			// Erste Zeile ("Titel"-Zeile) wird in die neue Textdatei geschrieben
			writer.write(titel + "\n");
			/*
			 * Das Array wird einzeln durchgegangen. Die Eigenschaften eines Objektes werden
			 * zu einem String, mithilfe der toString-Methode zusammengefasst und in die
			 * neue Datei geschrieben
			 */
			for (int i = 0; i < counter; i++) {
				writer.write(liste[i].toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Datei nicht angelegt");
		}
	}

}
