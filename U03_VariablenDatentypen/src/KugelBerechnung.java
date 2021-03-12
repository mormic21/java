
public class KugelBerechnung
{

	public static void main(String[] args) {
	  // Ausgabe der Überschrift
		System.out.println("Kugelberechnung");
		System.out.println("===============");
		//Es wird ausgegeben "GebenSie den Radius der Kugel ein" und die Variable double radius wird mit dem Wert initialisiert, welcher der Benutzer eingibt
		double radius = readDouble("Geben Sie den Radius der Kugel ein: ");
		//Ein leerer Absatz wird ausgegeben
		System.out.println();
		//Der Umfang der Kugfel wird berecnet und schließlich ausgegeben
		System.out.println("Der Umfang der Kugel betr�gt: "+ 2*radius*Math.PI);
		//Die Oberfläche der Kugel wird ausgegeben und schließlich ausgegeben
		System.out.println("Die Oberfläche der Kugel betr�gt: "+ 4*Math.PI*Math.pow(radius, 2));
		//Das Volumen der Kugel wird ausgegeben und schließlich ausgegeben
		System.out.println("Das Voliumen der Kugel betr�gt: "+ 4*Math.PI*(Math.pow(radius, 3)/3));
	}
	//Methode readDouble zur Benutzereingabe des Radius der Kugel (Double)
	public static double readDouble(String text) {
    System.out.print(text);
    return (new java.util.Scanner(System.in)).nextDouble();
  }

}
