
public class SatellitenZeit
{

	public static void main(String[] args) {
		//Ausgabe der Überschrift
		System.out.println("Satellitenzeit");
		System.out.println("==============");
		//Der Benutzer gibt einen Integer-Wert für die Variable anzahlsek ein
		int anzahlsek = TestScanner.readInt("Geben Sie die Sekunden ein: ");
		//anzahlsek wird durch 86400 geteilt und der double Wert in der Variable tage gespeichert
		double tage = anzahlsek/86400D;
		//tage - der Integer-Wert von tage ergibt den Variabelwert rest
		double rest = tage -(int)tage;
		//Die Variable rest wird mit 86400 multipliziert und durch 3600 geteilt und das Ergebnis in der Variable stunden gespeichert
		double stunden = (rest*86400)/3600;
		/*
		 * Sollte der Wert der Variable stunden größer gleich 24 sein, so wird die Variable tage um 1 erhöht und von der 
		 * Variable stunden werden 24 abgezogen
		 */
		if (stunden >= 24) {
			tage++;
			stunden = stunden-24;
		}
		//stunden minus den Integerwert von stunden ergibt den Variabelwert rest
		rest = stunden - (int)stunden;
		//Die Variable rest wird mit 3600 multipliziert und mit 60 dividiert und das Ergebnis wird in der Variable minuten gespeichert
		double minuten = (rest*3600)/60;
		/*
		 * Sollte der Wert der Variable minuten größer gleich 60 sein, so wird die Variable stunden um 1 erhöht und von
		 * der Variable minuten werden 60 abgezogen
		 */
		if (minuten >= 60) {
			stunden++;
			minuten = minuten - 60;
		}
		//miunten minus den Integer-Wert von minuten ergibt den Wert der Variable rest
		rest = minuten - (int)minuten;
		//Die variable rest wird mit 60 multipliziert, auf die nächste Ganzzahl gerundet und in der Variable sekunden gespeichert
		double sekunden = Math.round(rest*60);
		//Absatz wird ausgegeben
		System.out.println();
		//"Die umgerechnete Zeit ist:" wird ausgegeben
		System.out.println("Die umgerechnete Zeit ist:");
		//Die Ergebnisse der Umrechnung werden ausgegeben
		System.out.println("d "+(int)tage+" h "+(int)stunden+" m "+(int)minuten+" s "+(int)sekunden);
	}

}
