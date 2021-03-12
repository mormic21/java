
public class QuersummenQuersumme
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Quersummenquersumme");
		System.out.println("===================");
		//Der Benutzer gibt eine Zahl vom Typ Integer ein
		int zahl = TestScanner.readInt("Geben Sie die Zahl ein: ");
		//Ein Absatz wird ausgegeben
		System.out.println();
		//"Die Quersumme lautet: " wird ausgegeben
		System.out.println("Die Quersummenquersumme lautet: ");
		//Die Variable i wird mit 1 initialisiert
		int i = 1;
		//Die Variable zahl1 wird mit dem Wert 0 initialisiert
	  int zahl1 = 0;
	  //Der Teiler für die eingegebene Zahl wird ermittelt
	  while (zahl / i > 1) {
	  	i = i * 10;
    }
	  //Die Variable qsumme wird mit dem Wert 0 initialisert
	  int qsumme  = 0;
	  //While-Schleife zur Ausgabe der einzelnen Zahlen
	  while (zahl >= 1) {
	  	//zahl1 soll sein zahl / i
	  	zahl1 = zahl / i;
	  	//qsumme istgleich qsumme + zahl1
	  	qsumme = qsumme + zahl1;
	  	//Ausgabe von zahl1
	  	System.out.print(zahl1);
	  	//zahl ist zahl % i
	  	zahl = zahl % i;
	  	//i = i /10
	  	i = i / 10;
	  	//Wenn zahl > 1 ist, so wird ein + ausgegeben
	  	if (zahl > 1) {
	  		System.out.print(" + ");
	  	}
	  }
    //Die Variable qsumme wird mit Leerzeichen und "=" ausgegeben
    System.out.print(" = "+qsumme);
    System.out.print(" = ");
    //i soll sein 1
    i = 1;
    //zahl1 soll sein 0
	  zahl1 = 0;
	  //Solange qsumme durch i größer als 1 ist, so wird i mit 10 multpliziert. Die Teiler der Zahl werden ermittelt
	  while (qsumme / i > 1) {
	  	i = i * 10;
    }
	  //Die Variable int qqsumme wird mit dem Wert 0 initialisiert
	  int qqsumme  = 0;
	  //While-schleife zur Ausgabe einzelner Zahlen
	  while (qsumme >= 1) {
	  	zahl1 = qsumme / i;
	  	qqsumme = qqsumme + zahl1;
	  	//zahl1 wird ausgegeben
	  	System.out.print(zahl1);
	  	qsumme = qsumme % i;
	  	i = i / 10;
	  	//Wenn qsumme größer als 1 ist, so wird ein + ausgegeben
	  	if (qsumme > 1) {
	  		System.out.print(" + ");
	  	}
	  }
    //Die Variable qqsumme wird mit Leerzeichen und "=" ausgegeben
    System.out.println(" = "+qqsumme);
	}
	
	
}
