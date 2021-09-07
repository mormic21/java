package net.tfobz.grundobjekte;

import net.tfobz.spielobjekte.Sandwich;

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
	
	/**
	 * Versucht das Objekt in die eingestellte Richtung zu bewegen. 
	 * Erfolgt bei der schrittweisen Bewegung des Objektes ein Zusammenprall 
	 * mit einem unbeweglichen Objekt oder mit dem Fensterrand, so bleibt das
	 * Objekt stehen. Erfolg die Kollision mit einem beweglichen,
	 * "guten" Objekt, so wird dieses Objekt gefressen. Ein Objekt 
	 * fressen bedeutet, dass das gefressene Objekt verschwindet und dass 
	 * die Punkte des steuerbaren Objektes erhöht werden. Kollidiert das 
	 * Objekt mit einem beweglichen, "bösen" Objekt, so stirbt das 
	 * steuerbare Objekt
	 */
	@Override
	public void bewege() {
		int r = this.getxRichtung();
		if(r == 0) {
			r =  this.getyRichtung();
		}
		
		for (int i = 0; i < Math.abs(r); i++) {
			//alles frei
			if (this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
					(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))) == null) {
				this.setLocation((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
					(this.getY() + this.getyRichtung() / (10 * geschwindigkeit)));
			}
			//sandwich
			else if (this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
					(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))).toString().indexOf("Sandwich") >= 0){
				Sandwich s = (Sandwich) (this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
						(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))));
				s.stirb();
				punkte++;
			}
			//bombe
			else if(this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
					(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))).toString().indexOf("Bombe") >= 0){
				this.stirb();
			}
			//mauer oder fensterrand
			else if(this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
					(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))).toString().indexOf("Mauer") >= 0
						|| this.getObjektBei((this.getX() + this.getxRichtung() / (10 * geschwindigkeit)),
							(this.getY() + this.getyRichtung() / (10 * geschwindigkeit))).toString().indexOf("javax.swing.JPanel") >= 0){
				this.setxRichtung(0);
			}
		}
	}
}
