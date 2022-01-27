package net.tfobz.groesse;

/**
 * Auto
 * implementiert Groesse und Comparable<Groesse>
 * @author Michael Morandell
 *
 */
public class Auto implements Groesse, Comparable<Groesse> {
	//Membervariablen
	private long laenge;
	private long breite;
	private long hoehe;
	
	/**
	 * Auto-Konstruktor
	 * @param laenge
	 * @param breite
	 * @param hoehe
	 */
	public Auto(long laenge, long breite, long hoehe) {
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	/**
	 * getLaenge
	 * @return laenge, long
	 */
	@Override
	public long getLaenge() {
		return this.laenge;
	}

	/**
	 * setLaenge
	 * @param laenge the laenge to set
	 */
	public void setLaenge(long laenge) {
		this.laenge = laenge;
	}
	
	/**
	 * getBreite
	 * @return Breite, long
	 */
	@Override
	public long getBreite() {
		return this.breite;
	}

	/**
	 * setBreite
	 * @param breite the breite to set
	 */
	public void setBreite(long breite) {
		this.breite = breite;
	}
	
	/**
	 * getHoehe
	 * @return hoehe, long
	 */
	@Override
	public long getHoehe() {
		return this.hoehe;
	}

	/**
	 * setHoehe
	 * @param hoehe the hoehe to set
	 */
	public void setHoehe(long hoehe) {
		this.hoehe = hoehe;
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
		return "Auto L = "+this.getLaenge()+" B = "+this.getBreite()+" H = "+this.getHoehe()+" G = "+this.getGrundflaeche();
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