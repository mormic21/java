
public class Zinseszinsen
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Zinzeszinzen");
		System.out.println("============");
		//Für die Variable akapital vom Typ Double wird ein Wert vom Benutzer eingegeben
		double akapital = readDouble("Geben sie das Anfangskapital ein: ");
		//Für die Variable zsatz vom Typ Double wird vom Benutzer ein Wert eingegeben
		double zsatz = readDouble("Geben Sie den Zinssatz sein: ");
		//Für die Variable jahre vom Typ Integer gibt der Benutzer einen Wert ein
		int jahre = readInt("Geben sie die Jahre ein: ");
		//Der Variabelwert von ekapital wird aus den zuvor eingegebenen Daten berechnet
		double ekapital = Math.floor(akapital*Math.pow(1+(zsatz/100), jahre));
		//Ein Absatz wird ausgegeben
		System.out.println();
		//Der wert der variable ekapital wird am Ende ausgegeben
		System.out.println("Das Endkapital nach "+jahre+" Jahren beträgt "+(int)ekapital);

	}
	//Methode readDouble zum Einlesen von Benutzereingaben vom Datentyp Double
	public static double readDouble(String text) {
    System.out.print(text);
    return (new java.util.Scanner(System.in)).nextDouble();
    }
	//Methode readDouble zum Einlesen von Benutzereingaben vom Datentyp Integer
	public static int readInt(String text) {
    System.out.print(text);
    return (new java.util.Scanner(System.in)).nextInt();
    }

}
