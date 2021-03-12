
public class PythagoreischeTripel
{

	public static void main(String[] args) {
		try {
			// Umleiten der Standardausgabe in die Datei welche unter dem angegebenen
			// Laufwerk und Pfad gespeichert wird. Ist die Datei dort nicht vorhanden,
			// wird sie angelegt
			System.setOut(new java.io.PrintStream("C:\\Users\\Michael Morandell\\Documents\\"
					+ "Informatik\\PythagoreischeTripel.csv"));
			int a = 1;
			int b = 1;
			int c = 1;
			//Ausgabe der Überschrift/Beschriftung
			System.out.println("Pythagoreische Tripel");
			System.out.println("Seite a" + ";" + "Seite b" + ";" + "Seite c");
			// ändert die Seite a wenn alle Möglichkeiten für b und c probiert wurden
			for (a = 1; a <= 1000; a++) {
				// überprüft ob es ein rechtwinkliges Dreieck ist
				if (b * b + c * c == a * a) {
					// überprüft ob es ein Pythagoräisches Dreieck ist
					if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
						System.out.println(a + ";" + b + ";" + c);
					}

				} else if (a * a + c * c == b * b) {
					if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
						System.out.println(a + ";" + b + ";" + c);
					}

				} else if (a * a + b * b == c * c) {
					if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
						System.out.println(a + ";" + b + ";" + c);
					}
				}
				// ändert b wenn alle Möglichkeiten für c probiert wurden
				for (b = a; b <= 1000; b++) {
					if (b * b + c * c == a * a) {
						if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
							System.out.println(a + ";" + b + ";" + c);
						}

					} else if (b * b + c * c == a * a) {
						if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
							System.out.println(a + ";" + b + ";" + c);
						}

					} else if (a * a + b * b == c * c) {
						if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
							System.out.println(a + ";" + b + ";" + c);
						}
					}
					// probiert alle c < 1000 durch
					for (c = b; c <= 1000; c++) {
						if (b * b + c * c == a * a) {
							if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
								System.out.println(a + ";" + b + ";" + c);
							}

						} else if (b * b + c * c == a * a) {
							if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
								System.out.println(a + ";" + b + ";" + c);
							}

						} else if (a * a + b * b == c * c) {
							if (a % 1 == 0 && b % 1 == 0 && c % 1 == 0) {
								System.out.println(a + ";" + b + ";" + c);
							}
						}
					}

				}
			}

		} catch (java.io.FileNotFoundException e) {
			// Es ist ein Fehler beim Erstellen oder Öffnen der Datei aufgetreten
			System.out.println("Fehler beim Erstellen der Datei");
		}
	}

}
