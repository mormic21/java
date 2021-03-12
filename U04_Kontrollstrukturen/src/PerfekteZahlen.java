
public class PerfekteZahlen
{

	public static void main(String[] args) {
		//Variable wird initialisiert, welche zählt wieviele Zahlen ausgegeben werden
		int counter = 0;
		int n = 0;
		//Solange counter kleiner gleich 5 ist, wird erst die Summe der Teiler der Zahl n berechnet
		while (counter <= 5) {
			n++;
			int summe = 0;
			for (int t = 1; t < n; t++) {
				if (n % t == 0) {
					summe = summe + t;
				}
			}
			//Ist die summe der Teiler gleich n, so ist die Zahl n eine perfekte Zahl und wird ausgegeben
			if (summe == n) {
				System.out.println(n);
				counter++;
			}
		}
	}

}
