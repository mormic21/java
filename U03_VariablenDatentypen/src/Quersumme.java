
public class Quersumme
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Quersumme");
		System.out.println("=========");
		//Der Benutzer gibt eine Zahl vom Datentyp Integer ein
		int zahl = TestScanner.readInt("Geben sie die Zahl ein: ");
		//Absatz und Text werden ausgegeben
		System.out.println();
		System.out.println("Die Quersumme lautet: ");
		//Die Variable i wird mit dem Wert 1 initialisiert
		int i = 1;
		//Die Variable zahl 1 wird mit dem Wert 1 initialisiert
		int zahl1 = 0;
		//Die Teiler der eingegebenen Zahl werden ermittelt
		while (zahl / i > 1) {
	  	i = i * 10;
    }
		//Die Variable qsumme wird mit dem Wert 0 initialisert
		int qsumme  = 0;
		//Die einzelnen Zahlen werden ausgegeben
		while (zahl >= 1) {
	  	zahl1 = zahl / i;
	  	qsumme = qsumme + zahl1;
	  	//Die Variable zahl1 wird ausgegeben
	  	System.out.print(zahl1);
	  	zahl = zahl % i;
	  	i = i / 10;
	  	//Wenn zahl größer 1 so wird ein + ausgegeben
	  	if (zahl > 1) {
	  		System.out.print(" + ");
	  	}
	  }
    //Die Variable summe wird mit Leerzeichen und "=" ausgegeben
    System.out.println(" = "+qsumme);
	}
}
