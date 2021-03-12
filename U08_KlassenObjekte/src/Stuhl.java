
public class Stuhl {

	private String material;
	private double preis;
	private int anzahlTeile;
	private Polsterung polsterung = new Polsterung();
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String s) {
		if (s != null) {
			this.material = s;
		}
	}
	
	public double getPreis() {
		return preis;
	}
	
	public void setPreis(double d) {
		this.preis = d;
	}
	
	public int getAnzahlTeile() {
		return anzahlTeile;
	}
	
	public void setAnzahlTeile(int i) {
		this.anzahlTeile = i;
	}
	
	public Polsterung getPolsterung() {
		return polsterung;
	}
	
	public void setPolsterung(Polsterung pol) {
		this.polsterung = pol;
	}
	
	public Stuhl clone() {
		Stuhl ret = new Stuhl();
		ret.setMaterial(this.material);
		ret.setAnzahlTeile(this.anzahlTeile);
		ret.setPreis(this.preis);
		ret.setPolsterung(this.polsterung);
		return ret;
	}
	
	public boolean equals(Object obj) {
		boolean ret =  false;
		if (obj instanceof Stuhl) {
			Stuhl o = (Stuhl)obj;
			ret = o.material.equals(this.material) && 
					o.anzahlTeile == this.anzahlTeile &&
					Math.abs(o.preis - this.preis) < Math.pow(10, -10) &&
					o.polsterung.equals(this.polsterung);
		}
		return ret;
	}
	
	public int compareTo(Stuhl o) {
		int ret = o.material.compareTo(this.material);
		if (ret == 0) {
			ret = o.anzahlTeile - this.anzahlTeile;
			if (ret == 0) {
				ret = (int)(Math.floor((o.preis - this.preis)*100000)/100000);
			}
		}
		return ret;
	}

}
