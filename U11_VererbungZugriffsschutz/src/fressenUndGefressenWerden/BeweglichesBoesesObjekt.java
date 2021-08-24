package fressenUndGefressenWerden;

public class BeweglichesBoesesObjekt extends BeweglichesGutesObjekt{
	
	/**
	 * Erhält das Bild, welches das böse Objekt darstellt
	 * @param dateiname, der das dazustellende Bild enthält
	 */
	public BeweglichesBoesesObjekt(java.lang.String dateiname) {
		super(dateiname);
	}
	
	/**
	 * Versucht das Objekt in die eingestellte Richtung zu bewegen. 
	 * Erfolgt bei der schrittweisen Bewegung des Objektes ein Zusammenprall mit einem steuerbaren Objekt, so stirbt das steuerbare Objekt
	 */
	@Override
	public void bewege() {
		for (int i = 0; i < Math.abs(getxRichtung()); i++) {
			if (this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung),
					this.getY() + (int) Math.copySign(1, yRichtung)) != null
					&& this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung),
							this.getY() + (int) Math.copySign(1, yRichtung)).toString().indexOf("Hund") >= 0) {
				Hund h = (Hund)(this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung), this.getY() + (int) Math.copySign(1, yRichtung)));
				h.stirb();
			}
			
			
			
			if (this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung),
					this.getY() + (int) Math.copySign(1, yRichtung)) == null) {
				this.setLocation(this.getX() + (int) Math.copySign(1, xRichtung),
						this.getY() + (int) Math.copySign(1, yRichtung));
			} else {
//				//
//				System.out.println(this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung),
//						this.getY() + (int) Math.copySign(1, yRichtung)).getClass().toString());
//				//
				if (this.getObjektBei(this.getX() + ((int) Math.copySign(1, xRichtung) * -1),
						this.getY() + (int) Math.copySign(1, yRichtung)) == null) {
					this.setxRichtung(this.getxRichtung() * -1);
					this.setLocation(this.getX() + (int) Math.copySign(1, xRichtung),
							this.getY() + (int) Math.copySign(1, yRichtung));
				} else {
					if (this.getObjektBei(this.getX() + (int) Math.copySign(1, xRichtung),
							this.getY() + ((int) Math.copySign(1, yRichtung) * -1)) == null) {
						this.setyRichtung(this.getyRichtung() * -1);
						this.setLocation(this.getX() + (int) Math.copySign(1, xRichtung),
								this.getY() + (int) Math.copySign(1, yRichtung));
					} else {
						if (this.getObjektBei(this.getX() + ((int) Math.copySign(1, xRichtung) * -1),
								this.getY() + ((int) Math.copySign(1, yRichtung) * -1)) == null) {
							this.setxRichtung(this.getxRichtung() * -1);
							this.setyRichtung(this.getyRichtung() * -1);
							this.setLocation(this.getX() + (int) Math.copySign(1, xRichtung),
									this.getY() + (int) Math.copySign(1, yRichtung));
						}
					}
				}
			}
		}
	}
}
