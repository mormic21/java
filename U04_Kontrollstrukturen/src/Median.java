
public class Median
{

	public static void main(String[] args) {
	  // Ausgabe der Überschrift
	  System.out.println("Median");
		System.out.println("======");
		//3 Zahlen vom Typ Integer werden vom Benutzer eingegeben
		int zahl1 = TestScanner.readInt("1.Zahl: ");
		int zahl2 = TestScanner.readInt("2.Zahl: ");
		int zahl3 = TestScanner.readInt("3.Zahl: ");
		//Wenn alle 3 Zahlen gleich sind, dann gibt es keinen Median
		if (zahl1 == zahl2 && zahl1 == zahl3) {
			System.out.println("Es gibt keinen Median, da alle 3 Zahlen gleich sind!");
		}
		//Sind alle 3 Zahl nicht gleich, dann:
		else {
			//Wird geprüft ob zahl1 die zweit-kleinste Zahl ist
			if (zahl1 >= zahl2 && zahl1 < zahl3 || zahl1 < zahl2 && zahl1 > zahl3) {
				System.out.println("Der Median lautet "+zahl1);
			}
			//Wird geprüft ob zahl2 die zweitkleinste Zahl ist.
			if (zahl1 >= zahl2 && zahl1 >= zahl3 && zahl2 > zahl3 || zahl1 < zahl2 && zahl1 <= zahl3 && zahl2 < zahl3) {
				System.out.println("Der Median lautet "+zahl2);
			}
			//Wird geprüft ob zahl3 die zweitkleinste Zahl ist.
			if (zahl1 >= zahl2 && zahl1 >= zahl3 && zahl2 <= zahl3 || zahl1 < zahl2 && zahl1 <= zahl3 && zahl2 >= zahl3) {
				System.out.println("Der Median lautet "+zahl3);
			}
		}
  }
}
