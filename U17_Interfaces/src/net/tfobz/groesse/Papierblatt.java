package net.tfobz.groesse;

/**
 * Papierblatt
 * implementiert Groesse und Comparable<Groesse>
 * @author Michael Morandell
 *
 */
public class Papierblatt implements Groesse, Comparable<Groesse> {
	//Memberkonstanten
	private final long LAENGE;
	private final long BREITE;
	private final long HOEHE = 0;
	
	/**
	 * Papierblatt
	 * @param format, int
	 */
	public Papierblatt(int format) {
		switch (format) {
			//Wenn DIN-A0
			case 0: {
				this.LAENGE = 1189;
				this.BREITE = 841;
				break;
			}
			//Wenn DIN-A1
			case 1: {
				this.LAENGE = 841;
				this.BREITE = 594;
				break;
			}
			//Wenn DIN-A2
			case 2: {
				this.LAENGE = 594;
				this.BREITE = 420;
				break;
			}
			//Wenn DIN-A3
			case 3: {
				this.LAENGE = 420;
				this.BREITE = 297;
				break;
			}
			//Wenn DIN-A4
			case 4: {
				this.LAENGE = 297;
				this.BREITE = 210;
				break;
			}
			//Wenn ungueltige Eingabe
			default: {
				this.LAENGE = 0;
				this.BREITE = 0;
			}
		}
	}
	
	/**
	 * getLaenge
	 * @return laenge, long
	 */
	@Override
	public long getLaenge() {
		return this.LAENGE;
	}
	
	/**
	 * getBreite
	 * @return Breite, long
	 */
	@Override
	public long getBreite() {
		return this.BREITE;
	}
	
	/**
	 * getHoehe
	 * @return hoehe, long
	 */
	@Override
	public long getHoehe() {
		return this.HOEHE;
	}
	
	/**
	 * getGrundflaeche
	 * @return grundflaeche, berechnet aus laenge * breite, long
	 */
	@Override
	public long getGrundflaeche() {
		return this.getLaenge() * this.getBreite();
	}
	
	/**
	 * toSting
	 * @return alle Eigenschaften, als String
	 */
	@Override
	public String toString() {
		return "Papierblatt L = "+this.getLaenge()+" B = "+this.getBreite()+" H = "+this.getHoehe()+" G = "+this.getGrundflaeche();
	}
	
	/**
	 * compareTo
	 * vergleicht zwei Objekte aufgrund ihrer Grundflaeche
	 * @param Groesse o
	 * @return int, 0 if equal, -1 wenn kleiner, 1 wenn groesser
	 */
	@Override
	public int compareTo(Groesse g) {
		int ret = 0;
		if (this.getGrundflaeche() < g.getGrundflaeche()) {
			ret = -1;
		}
		else {
			if (this.getGrundflaeche() > g.getGrundflaeche()) {
				ret = 1;
			}
		}
		return ret;
	}
}