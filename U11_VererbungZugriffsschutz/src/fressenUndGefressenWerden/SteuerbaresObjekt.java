package fressenUndGefressenWerden;

public class SteuerbaresObjekt extends BeweglichesGutesObjekt{
	
	//Merkt sich die Punkte welche beim Fressen von beweglichen, "guten" Objekten erhalten werden
	protected int punkte;
	
	/**
	 * Erhält das Bild, welches dargestellt werden soll. Der Konstruktor 
	 * sorgt dafür, dass das Objekt sich vorerst nicht im Fenster bewegt
	 * @param dateiname, der das dazustellende Bild enthält
	 */
	public SteuerbaresObjekt(java.lang.String dateiname) {
		super(dateiname);
		setGeschwindigkeit(0);
	}
	
	/**
	 * Lesen der Punkte welches das Objekt momentan hat
	 * @return die Punkte des Objektes
	 */
	public int getPunkte() {
		return this.punkte;
	}
	
	@Override
	/**
	 * Setzt die X-Richtung des Objektes. 
	 * Das Objekt darf sich nicht diagonal bewegen.
	 * Das bedeutet, dass beim Setzen der X-Richtung die
	 * Y-Richtung auf 0 gesetzt werden muss. Da für das steuerbare 
	 * Objekt immer die Maximalgeschwindigkeit eingestellt werden muss, 
	 * wird die X-Richtung folgendermaßen gesetzt:
	 */
	public void setxRichtung(int xRichtung) {
		if (xRichtung == 0) {
			this.xRichtung = 0;
			this.yRichtung = 0;
		}
		else {
			if (xRichtung < 0) {
				this.xRichtung = -10 * getGeschwindigkeit();
				this.yRichtung = 0;
			}
			else {
				this.xRichtung = 10 * getGeschwindigkeit();
				this.yRichtung = 0;
			}
		}
	}
	
	@Override
	/**
	 * Setzt die X-Richtung des Objektes. 
	 * Das Objekt darf sich nicht diagonal bewegen.
	 * Das bedeutet, dass beim Setzen der X-Richtung die
	 * Y-Richtung auf 0 gesetzt werden muss. Da für das steuerbare 
	 * Objekt immer die Maximalgeschwindigkeit eingestellt werden muss, 
	 * wird die X-Richtung folgendermaßen gesetzt:
	 */
	public void setyRichtung(int yRichtung) {
		if (yRichtung == 0) {
			this.yRichtung = 0;
			this.xRichtung = 0;
		}
		else {
			if (yRichtung < 0) {
				this.yRichtung = -10 * getGeschwindigkeit();
				this.xRichtung = 0;
			}
			else {
				this.yRichtung = 10 * getGeschwindigkeit();
				this.xRichtung = 0;
			}
		}
	}
	
	public void bewege() {
		
	}
	
}
