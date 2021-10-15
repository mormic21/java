package net.tfobz.ratenrechner;

public class RatenRechner {
	boolean nachschuessig;
	double barwert;
	double jahreszinssatz;
	double laufzeitInJahren;
	int ratenProJahr;
	
	/**
	 * @return the nachschuessig
	 */
	public boolean isNachschuessig() {
		return nachschuessig;
	}
	/**
	 * @param nachschuessig the nachschuessig to set
	 */
	public void setNachschuessig(boolean nachschuessig) {
		this.nachschuessig = nachschuessig;
	}
	/**
	 * @return the barwert
	 */
	public double getBarwert() {
		return barwert;
	}
	/**
	 * @param barwert the barwert to set
	 */
	public void setBarwert(double barwert) {
		this.barwert = barwert;
	}
	/**
	 * @return the jahreszinssatz
	 */
	public double getJahreszinssatz() {
		return jahreszinssatz;
	}
	/**
	 * @param jahreszinssatz the jahreszinssatz to set
	 */
	public void setJahreszinssatz(double jahreszinssatz) {
		this.jahreszinssatz = jahreszinssatz;
	}
	/**
	 * @return the laufzeitInJahren
	 */
	public double getLaufzeitInJahren() {
		return laufzeitInJahren;
	}
	/**
	 * @param laufzeitInJahren the laufzeitInJahren to set
	 */
	public void setLaufzeitInJahren(double laufzeitInJahren) {
		this.laufzeitInJahren = laufzeitInJahren;
	}
	/**
	 * @return the ratenProJahr
	 */
	public int getRatenProJahr() {
		return ratenProJahr;
	}
	/**
	 * @param ratenProJahr the ratenProJahr to set
	 */
	public void setRatenProJahr(int ratenProJahr) {
		this.ratenProJahr = ratenProJahr;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	double rate;
}
