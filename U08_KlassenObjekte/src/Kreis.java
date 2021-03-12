/**
 * Kreis-Klasse f�r Objekte vom Typ Kreis mit Methoden
 * @author Michael Morandell
 *
 */
public class Kreis {
	private double radius = 0;

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		if (radius >= 0) {
			this.radius = radius;
		}	
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Setzt den Umfang des Kreises. Der �bergebene Umfang darf nicht 0 sein. 
	 * Die Methode errechnet sich aus dem Umfang den Radius und setzt diesen
	 * @param umfang, der zu setzende Umfang
	 */
	public void setUmfang(double umfang) {
		if (umfang != 0) {
			this.radius = umfang/(2*Math.PI);
		}
	}

	/**
	 * Liefert den Umfang des Kreises zur�ck. Dieser wird aus dem Radius berechnet
	 * @return, den Umfang des Kreises
	 */
	public double getUmfang() {
		double ret = 2*this.radius * Math.PI;
		return ret;
	}

	/**
	 * Setzt die Fl�che des Kreises. Die �bergebene Fl�che darf nicht 0 sein. 
	 * Die Methode errechnet sich aus der Fl�che den Radius und setzt diesen
	 * @param flaeche, die zu setzende Fl�che
	 */
	public void setFlaeche(double flaeche) {
		if (flaeche != 0) {
			this.radius = Math.sqrt(flaeche/Math.PI);
		}
	}

	/**
	 * Liefert die Fl�che des Kreises zur�ck
	 * @return, die Fl�che des Kreises
	 */
	public double getFl�che() {	
		double ret = Math.pow(this.radius, 2)* Math.PI;
		return ret;
	}

	/**
	 * Ermittelt aus dem �bergebenen Kreis-Objekt einen ausgebaren String
	 * @return String
	 */
	public String toString() {
		String ret = "r = " + radius + ", U = "+2*radius*Math.PI+", F = "+Math.PI*Math.pow(radius, 2);
		return ret;
	}

	/**
	 * Erstellt eine Kopie vom Objekt Kreis
	 * @return einen geclonten Kreis
	 */
	public Kreis clone() {
		Kreis ret = new Kreis();
		ret.setRadius(this.radius);
		return ret;
	}

	/**
	 * Ermittelt ob 2 Kreis-Objekte gleich sind
	 * @return boolean, true wenn beide Objekte gleich sind
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kreis other = (Kreis) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
	/**
	 * CompareTo-Mathode. Kontrolliert, ob er Kreis kleiner als das �bergebene 
	 * Kreisobjekt k ist (R�ckgabewert = -1), gr��er (R�ckgabewert = 1) oder 
	 * gleich dem �bergebenen Kreisobjekt k ist (R�ckgabewert = 0)
	 * @param k, das zu vergleichende Objekt
	 * @return -1 falls das Objekt kleiner als das �bergebene Objekt k ist 
	 * 			0 falls das Objekt gleich dem �bergebenen Objekt k ist 
	 * 			1 falls das Objekt gr��er als das �bergebene Objekt k ist

	 */
	public int compareTo(Kreis k) {
		int ret = 0;
		if (this.radius < k.radius) {
			ret = -1;
		}
		if (this.radius > k.radius) {
			ret = 1;
		}
		return ret;
	}
}
