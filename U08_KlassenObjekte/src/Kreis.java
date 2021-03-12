/**
 * Kreis-Klasse für Objekte vom Typ Kreis mit Methoden
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
	 * Setzt den Umfang des Kreises. Der übergebene Umfang darf nicht 0 sein. 
	 * Die Methode errechnet sich aus dem Umfang den Radius und setzt diesen
	 * @param umfang, der zu setzende Umfang
	 */
	public void setUmfang(double umfang) {
		if (umfang != 0) {
			this.radius = umfang/(2*Math.PI);
		}
	}

	/**
	 * Liefert den Umfang des Kreises zurück. Dieser wird aus dem Radius berechnet
	 * @return, den Umfang des Kreises
	 */
	public double getUmfang() {
		double ret = 2*this.radius * Math.PI;
		return ret;
	}

	/**
	 * Setzt die Fläche des Kreises. Die übergebene Fläche darf nicht 0 sein. 
	 * Die Methode errechnet sich aus der Fläche den Radius und setzt diesen
	 * @param flaeche, die zu setzende Fläche
	 */
	public void setFlaeche(double flaeche) {
		if (flaeche != 0) {
			this.radius = Math.sqrt(flaeche/Math.PI);
		}
	}

	/**
	 * Liefert die Fläche des Kreises zurück
	 * @return, die Fläche des Kreises
	 */
	public double getFläche() {	
		double ret = Math.pow(this.radius, 2)* Math.PI;
		return ret;
	}

	/**
	 * Ermittelt aus dem übergebenen Kreis-Objekt einen ausgebaren String
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
	 * CompareTo-Mathode. Kontrolliert, ob er Kreis kleiner als das übergebene 
	 * Kreisobjekt k ist (Rückgabewert = -1), größer (Rückgabewert = 1) oder 
	 * gleich dem übergebenen Kreisobjekt k ist (Rückgabewert = 0)
	 * @param k, das zu vergleichende Objekt
	 * @return -1 falls das Objekt kleiner als das übergebene Objekt k ist 
	 * 			0 falls das Objekt gleich dem übergebenen Objekt k ist 
	 * 			1 falls das Objekt größer als das übergebene Objekt k ist

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
