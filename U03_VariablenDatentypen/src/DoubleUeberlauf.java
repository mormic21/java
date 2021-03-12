
public class DoubleUeberlauf
{

	public static void main(String[] args) {
		//Die Variable i erhält den hochst-möglichen Wert für den Datentyp Double
		double i = 1.79769313486231570E308;
		//Die Variable j erhält den Wert 1
		int j = 1;
		//Die Variable n erhält den Wert 10000
		int n = 100000;
		/*
		 * Während die Variable j kleiner gleich der Variable n ist, so wird die Variable i mit 1E100 multipliziert
		 * Anschließend wird die Variable j um 1 erhöht
		 */
		while (j <= n) {
			i = i * 1E100;
			j = j + 1;
		}
		//Ausgabe der Variable i
		System.out.println(i);
	}

}
