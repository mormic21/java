package net.tfobz.groesse;

/**
 * Fussballfeld
 * implementiert Groesse und Comparable<Groesse>
 * @author Michael Morandell
 *
 */
public class Fussballfeld implements Groesse, Comparable<Groesse> {
	
	/**
	 * getLaenge
	 * @return laenge, long
	 */
	@Override
	public long getLaenge() {
		return 105000;
	}
	
	/**
	 * getBreite
	 * @return Breite, long
	 */
	@Override
	public long getBreite() {
		return 70000;
	}
	
	/**
	 * getHoehe
	 * @return hoehe, long
	 */
	@Override
	public long getHoehe() {
		return 0;
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
		return "Fussballfeld L = "+this.getLaenge()+" B = "+this.getBreite()+" H = "+this.getHoehe()+" G = "+this.getGrundflaeche();
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