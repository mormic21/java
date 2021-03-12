 
public class FakultaetTabelle
{

	public static void main(String[] args) {
		//Die Überschrift wird ausgegeben
		System.out.print("       n");
		System.out.println("      n!");
		System.out.println("================");
		//Die Variable n wird gleich 1 gesetzt
		int n = 1;
		//Solange n kleiner gleich 10 ist, wird die Variable fakultaet gleich n gesetzt, dann folgt eine Bedingungsprüfung
		while (n <= 10) {
			int fakultaet = n;
			//Wenn n kleiner 10 ist, so werden 7 Leerzeichen und dann n ausgegeben (rechtsbündig ausgeben)
			if (n < 10) {
				System.out.print("       " + n);
			}
			//Ansonsten wird n nur mit 6 Leerzeichen ausgegeben
			else {
				System.out.print("      " + n);
			}
			//Die Variable i erhält den Wert 1
			int i = 1;
			/*
			 * Solange i kleiner n ist, wird die Variable fakultaet mit (n-1) multipliziert und der Wert wird wieder in dieser
			 * Variable gespeichert. Danach wird i um 1 erhöht
			 */
			while (i < n) {
				fakultaet = fakultaet * (n-i);
				i = i + 1;
			}
			//Die Methode printZahl wird für die Ausgabe angewand
		  printZahl(fakultaet);
		  //Ein Absatz wird ausgegeben
		  System.out.println();
		  //Die Variable n wird um 1 erhöht
		  n = n + 1;
		}
		

	}
	//Methode printZahl zum rechtsbündigen Ausgeben der Variable fakultaet
	public static void printZahl(int fakultaet) {
		//Wenn fakultaet kleiner 10 ist, so wird die Variable mit 7 vorrausgehenden Leerzeichen ausgegeben
		if (fakultaet < 10) {
			System.out.print("       " + fakultaet);
		}
		else {
		//Ansonsten, wenn fakultaet kleiner 100 ist, so wird der Variabel-Wert mit 6 vorrausgehenden Leerzeichen ausgegeben
			if (fakultaet < 100) {
				System.out.print("      " + fakultaet);
			}
			else {
			//Ansonsten, wenn fakultaet kleiner 1000 ist, so wird der Variabel-Wert mit 5 vorrausgehenden Leerzeichen ausgegeben
				if (fakultaet < 1000) {
				  System.out.print("     " + fakultaet);
				}
				else {
				//Ansonsten, wenn fakultaet kleiner 10000 ist, so wird der Variabel-Wert mit 4 vorrausgehenden Leerzeichen ausgegeben
					if (fakultaet <=10000) {
						System.out.print("    " + fakultaet);
					}
					else {
					//Ansonsten, wenn fakultaet kleiner 100000 ist, so wird der Variabel-Wert mit 3 vorrausgehenden Leerzeichen ausgegeben
						if (fakultaet <= 100000) {
							System.out.print("   " + fakultaet);
						}
						else {
						//Ansonsten, wenn fakultaet kleiner 1000000 ist, so wird der Variabel-Wert mit 2 Leerzeichen ausgegeben
							if (fakultaet <= 1000000) {
								System.out.print("  " + fakultaet);
							}
							else {
								//Ansonsten wird der Variabel-Wert mit einem vorrausgehenden Leerzeichen ausgegeben
									System.out.print(" " + fakultaet);
							}
						}
					}
				}
			}
		}
	}	
}
