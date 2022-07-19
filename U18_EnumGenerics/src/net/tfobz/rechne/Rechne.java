package net.tfobz.rechne;

/**
 * Rechne
 * realisiert eine Klasse, welche mit einer variabel langen Parameterliste, alle Zahlen addiert und ausgibt
 * @author Michael Morandell
 *
 */
public class Rechne {
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(rechne(1.45,0.79,19.9,"Ware",-3.0,1.5,"Pfand",-10,"Gutschein"));
	}
	
	/**
	 * rechne
	 * @param args, Rechnungen und Strings
	 * @return String mit Ergebnisen
	 */
	public static String rechne(Object... args) {
		String ret = "";
		//sum
		double sum = 0;
		//gesamtsumme
		double totale = 0;
		//Für alle Parameter in der Liste
		for (Object o: args) {
			//Wenn Parameter ein Number ist
			if (o instanceof Number) {
				//Integer
				if (o instanceof Integer) {
					sum = sum + (Integer) o;
				}
				//Byte
				if (o instanceof Byte) {
					sum = sum + (Byte) o;
				}
				//Double
				if (o instanceof Double) {
					sum = sum + (Double) o;
				}
				//Short
				if (o instanceof Short) {
					sum = sum + (Short) o;
				}
				//Float
				if (o instanceof Float) {
					sum = sum + (Float) o;
				}
				//Long
				if (o instanceof Long) {
					sum = sum +(Long) o;
				}
			}
			else {
				//Wenn Parameter String ist
				if (o instanceof String) {
					//String wird ausgegeben
					ret = ret + (String)o + ": ";
					//summe wird hinzugefuegt
					ret = ret + sum + "\n";
					//berechnung der Totalsumme
					totale = totale + sum;
					sum = 0;
				}
			}
		}
		//Gesamtsumme wird in den String geschrieben
		ret = ret + "Gesamtsumme: "+ totale;
		//return
		return ret;
	}
}