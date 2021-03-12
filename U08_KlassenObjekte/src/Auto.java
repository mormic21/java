
public class Auto {
	
	//Membervariablen der Klasse Auto
	private int reifen;
	private double leistungkw;
	private String marke;
	
	//Methoden
	public static void main(String[] args) {
		//Neue Objekte werden instanziiert
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		//Wertzuweisungen
		auto1.marke = "audi";
		auto1.leistungkw = 140;
		auto1.reifen = 4;
		//auto2
		auto2.marke = "bmw";
		auto2.leistungkw = 135;
		auto2.reifen = 4;
		//Aufruf - GetPS mit Ausgabe
		System.out.println(auto1.marke);
		System.out.println(auto1.reifen);
		System.out.println(auto1.getPS());
		System.out.println(auto2.getPS());
		
	}
	/**
	 * Methode getPS wandelt die Leistung in Kilowatt in eine Leistung in PS um und gibt diese
	 * als double zurück. Dabei wird der Kilowatt-Wert mit 1,36 multipliziert.
	 * @return Leistung in Kilowatt
	 */
	public double getPS() {
		double ret = this.leistungkw * 1.36;
		return ret;
	}

}
