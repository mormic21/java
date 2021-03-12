
public class Fakultaet
{

	public static void main(String[] args) {
		 //Von der Zahl n wird die Fakulät berechnet
	  int n = 3;
	  //Wenn n größer gleich 1 ist, so wird die Fakultät berechnet, ansonsten (else) wird eine Fehlermeldung ausgegeben
	  if (n >= 1) {
	  	// i und fakultaet werden initialisiert
	  	int i = 1;
	  	int fakultaet = n;
	  	/*
	  	 * Solange i kleiner als n ist wird die fakultaet mit (n-i) multipliziert. Der Wert wird wieder in fakultaet
	  	 * gespeichert. Danach wird i um 1 erhöht.
	  	 */
	  	while (i < n) {
	  		fakultaet = fakultaet * (n-i);
	  		i = i + 1;
	  	}
	  	//Ist i nicht mehr kleiner als n, so wird fakutät (also die endgültige Falkultät der Zahl n) ausgegeben.
	  	System.out.println(fakultaet);
	  }
	  else {
	  	//Fehlermeldung bei n kleiner 1
	  	System.out.println("Die eingegebene Zahl ist ungültig!");
	  }
	}

}
