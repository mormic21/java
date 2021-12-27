package net.tfobz.ausdrueckeerw;

public class Argument extends Konstante {
	
	public Argument(double ergebnis) {
		this.setErgebnis(ergebnis);
	}
	public Argument() {
		super();
	}
	
	@Override
	public void setErgebnis(double ergebnis) {
		double wert = Math.abs(Math.floor(ergebnis));
		if (wert < 1) {
			wert = 1;
		}
		super.setErgebnis(wert);
	}
	
	public double getErgebnis() {
		return this.ergebnis;
	}
	public String toString() {
		return String.valueOf(this.ergebnis);
	}
}
