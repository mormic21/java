/**
 * Quadrat-Klasse für Obejekte vom Typ Quadrat mit Methoden
 * @author Michael Morandell
 *
 */
public class Quadrat {
	//Membervariable
	private double seiteA;

	/**
	 * Liefert die SeiteA des Quadrats zurück
	 * @return seiteA des Quadrats
	 */
	public double getSeiteA() {
		return seiteA;
	}

	/**
	 * Setzt die SeiteA. Die SeiteA wird nur gesetzt, wenn der Parameter größer oder gleich 0 ist. 
	 * Ansonsten wird der Wert 0 gesetzt
	 * @param seiteA - die zu setzende seiteA
	 */
	public void setSeiteA(double seiteA) {
		if (seiteA >= 0)
			this.seiteA = seiteA;
		else
			this.seiteA = 0;
	}
	
	/**
	 * Liefert die SeiteB des Quadrats zurück
	 * @return seiteB des Quadrats
	 */
	public double getSeiteB() {
		return seiteA;
	}
	
	/**
	 * Setzt die SeiteB. Die SeiteB wird nur gesetzt, wenn der Parameter größer oder gleich 0 ist. 
	 * Ansonsten wird der Wert 0 gesetzt
	 * @param seiteB - die zu setzende seiteB
	 */
	public void setSeiteB(double seiteB) {
		if(seiteB >= 0)
			this.seiteA = seiteB;
		else
			this.seiteA = 0;
	}
	
	/**
	 * Liefert den Umfang des Quadrats zurück
	 * @return Umfang, berechnet aus der seiteA
	 */
	public double getUmfang() {
		return 4*seiteA;
	}
	
	/**
	 * Setzt den Umfang. Der Umfang wird nur gesetzt, wenn der Parameter größer oder gleich 0 ist. 
	 * Ansonsten wird der Wert 0 gesetzt
	 * @param umfang, aus dem die SeiteA berechnet wird
	 */
	public void setUmfang(double umfang) {
		if(umfang >= 0)
			this.seiteA = umfang/4;
		else
			this.seiteA = 0;
	}
	
	/**
	 * Liefert den Fläche des Quadrats zurück
	 * @return Fläche, berechnet aus der seiteA
	 */
	public double getFlaeche() {
		return Math.pow(this.getSeiteA(), 2);
	}
	
	/**
	 * Setzt die Fläche. Die Fläche wird nur gesetzt, wenn der Parameter größer oder gleich 0 ist. 
	 * Ansonsten wird der Wert 0 gesetzt
	 * @param flaeche, aus dem die SeiteA berechnet wird
	 */
	public void setFlaeche(double flaeche) {
		if(flaeche >= 0)
			this.seiteA = Math.sqrt(flaeche);
		else
			this.seiteA = 0;
	}

	/**
	 * Erstellt eine Kopie vom Objekt Quadrat
	 * @return einen geclontes Objekt vom Typ Quadrat
	 */
	public Quadrat clone() {
		Quadrat ret = new Quadrat();
		ret.setSeiteA(this.seiteA);
		return ret;
	}
	
	/**
	 * Equals Methode. Kontolliert ob 2 Objekte gleich sind
	 * @return boolean, true wenn beide Objekte gleich sind, ansonsten false
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quadrat other = (Quadrat) obj;
		if (Double.doubleToLongBits(seiteA) != Double.doubleToLongBits(other.seiteA))
			return false;
		return true;
	}
	
	/**
	 * CompareTo-Mathode. Kontrolliert, ob das Quadrat kleiner (Rückgabewert = -1), 
	 * größer (Rückgabewert = 1) oder gleich als das übergebene 
	 * Quadrat-Objekt q (Rückgabewert = 0)
	 * @param q, das Quadrat-Pbjekt, mit dem verglichen wird
	 * @return -1 falls das Objekt kleiner als das übergebene Objekt q 
	 * 			0 falls das Objekt gleich dem übergebenen Objekt q 
	 * 			1 falls das Objekt größer als das übergebene Objekt q

	 */
	public int compareTo(Quadrat q) {
		int ret = 0;
		if (this.seiteA < q.seiteA)
			ret = -1;
		if (this.seiteA > q.seiteA) 
			ret = 1;
		return ret;
	}
	
	/**
	 * toString. Gibt den Inhalt eines Objektes vom Typ Quadrat, zum ausgeben, zurück.
	 * Beispiel: Quadrat mit Seitenlänge von 3.5 ergibt: a = 3.5, b = 3.5, U = 14.0, F = 12.25.
	 * @return Inhalt des Quadrat-Objektes als String
	 */
	public String toString() {
		return "a = "+ this.getSeiteA()+ ", b = " + this.getSeiteB()+ ", U = "+ this.getUmfang()
				+ ", F = " + this.getFlaeche();
	}
	
	
	
	

}
